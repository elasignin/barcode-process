package com.ingramcontent.consolidated.labels.helper;

/**
 * This class was automatically generated by the data modeler tool.
 */

public class CustomLogger implements java.io.Serializable {

    static final long serialVersionUID = 1L;

    public CustomLogger() {
    }


    public static Logger log() {
      return LoggerFactory.getLogger("com.jbpm.log");
    }

}