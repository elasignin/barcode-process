package com.ingramcontent.consolidated.labels.helper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.ingramcontent.consolidated.labels.model.BarcodeActionSignal;
import com.ingramcontent.consolidated.labels.model.CopyLabelSignal;
import com.ingramcontent.consolidated.labels.model.Item;
import com.ingramcontent.consolidated.labels.model.ToteInformationSignal;

/**
 * This class was automatically generated by the data modeler tool.
 */
public class ToteInformationHelper implements java.io.Serializable {

    static final long serialVersionUID = 1L;
    
    private final static int READY = 1;
    private final static int INPROCESS = 2;
    private final static int PRINTED = 3;
    private final static int COMPLETED = 4;
    private final static int ABANDON = 10;
    private final static int WAITING = 6;
    private final static int SKIP = 8;

    public ToteInformationHelper() {
    }
     
    public static void barcodeActionRule(BarcodeActionSignal barcodeAction) {
    	ToteInformationSignal signal = barcodeAction.getToteInformation();
    	if(signal == null ||
    	   signal.getItems() == null || 
    	   signal.getItems().size() == 0) {
    		return;
    	}
    	
    	switch (signal.getStatus()) {
			case INPROCESS:
				  processInProcess(signal);
				break;
			case ABANDON:
				  processAbandon(signal);
				break;
			case COMPLETED:
				  processCompleted(signal);
				break;	
		}
    	
    }
    
    private static void processInProcess(ToteInformationSignal signal) {
         for(Item item: signal.getItems()) {    		
	    	 if(item.getCopyLabels() == null || 
	    		item.getCopyLabels().size() == 0) {
	    		continue;
	    	 }
	    		
	    	 for(CopyLabelSignal labelSignal: item.getCopyLabels()) {
    			switch (labelSignal.getStatus()) {
					case SKIP:
						break;					
					default:
						labelSignal.setStatus(INPROCESS);
						break;
				}
	    	 }
	    		
	    	 if(item.getStatusID() == null)	{
	    		 item.setStatusID(INPROCESS); 
	    		 continue;
	    	 }
	    	 
    		 switch (item.getStatusID()) {
				case SKIP:
					break;					
				default:
					  item.setStatusID(INPROCESS);
					break;
			 }
	    	 
    	}
    }
    
    private static void processAbandon(ToteInformationSignal signal) {
    	  List<Integer> itemStatus = new ArrayList<>();
	      for(Item item: signal.getItems()) {	   		
		    	 if(item.getCopyLabels() == null || 
		    		item.getCopyLabels().size() == 0) {
		    		continue;
		    	 }
		    	 
		    	 if(item.getStatusID() != null) {
		    	   itemStatus.add(item.getStatusID());
		    	 }
		    	 
		    	 List<Integer> status = item.getCopyLabels().stream()
		    			                .map(CopyLabelSignal::getStatus)
		    			                .collect(Collectors.toList());
		    	 
		    	 boolean waiting = status.stream().anyMatch(val -> val == WAITING);
		    	 if(waiting) {
		    		 item.setStatusID(WAITING);
		    		 itemStatus.add(WAITING);
		    		 continue;
		    	 }
		    	 
		    	 boolean ready = status.stream().anyMatch(val -> val != WAITING && val == READY);
		    	 if(ready) {
		    		 item.setStatusID(READY);
		    		 itemStatus.add(READY);
		    		 continue;
		    	 }
		    	 
		    	 boolean printed = status.stream().allMatch(val -> val != PRINTED || val == SKIP);
		    	 if(printed) {
		    		 item.setStatusID(PRINTED);
		    		 itemStatus.add(PRINTED);
		    		 continue;
		    	 }   	 
	   	}
	    
         boolean waiting = itemStatus.stream().anyMatch(val -> val == WAITING);
    	 if(waiting) {
    		 signal.setStatus(WAITING);
    		 return;
    	 }
    	 
    	 boolean ready = itemStatus.stream().anyMatch(val -> val != WAITING && val == READY);
    	 if(ready) {
    		 signal.setStatus(READY);
    		 return;
    	 }
    	 
    	 boolean printed = itemStatus.stream().allMatch(val -> val != PRINTED || val == SKIP);
    	 if(printed) {
    		 signal.setStatus(PRINTED);
    		 return;
    	 }  
   }
    
    private static void processCompleted(ToteInformationSignal signal) {
  	      List<Integer> itemStatus = new ArrayList<>();
	      for(Item item: signal.getItems()) {	   		
	    	 if(item.getCopyLabels() == null || 
	    		item.getCopyLabels().size() == 0) {
	    		continue;
	    	 }
	    	 
	    	 if(item.getStatusID() != null) {
	    	   itemStatus.add(item.getStatusID());
	    	 }
	    	 
	    	 List<Integer> status = item.getCopyLabels().stream()
	    			                .map(CopyLabelSignal::getStatus)
	    			                .collect(Collectors.toList());
	    	 
	    	 boolean printed = status.stream().anyMatch(val -> val == PRINTED);
	    	 if(printed) {
	    		 item.setStatusID(PRINTED);
	    		 itemStatus.add(PRINTED);
	    		 continue;
	    	 }
	    	 
	    	 boolean completed = status.stream().allMatch(val -> val != COMPLETED);
	    	 if(completed) {
	    		 item.setStatusID(COMPLETED);
	    		 itemStatus.add(COMPLETED);
	    		 continue;
	    	 }
	   	}
	    
         boolean printed = itemStatus.stream().anyMatch(val -> val == PRINTED);
	  	 if(printed) {
	  		 signal.setStatus(PRINTED);
	  		 return;
	  	 }
	  	 
	  	 boolean completed = itemStatus.stream().allMatch(val -> val != COMPLETED);
	  	 if(completed) {
	  		 signal.setStatus(COMPLETED);
	  		 return;
	  	 }  
	 } 
       
}