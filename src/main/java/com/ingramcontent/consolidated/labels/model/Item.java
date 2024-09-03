package com.ingramcontent.consolidated.labels.model;

/**
 * This class was automatically generated by the data modeler tool.
 */

public class Item implements java.io.Serializable {

	static final long serialVersionUID = 1L;

	private Integer statusID;

	private java.lang.Integer itemId;

	private java.util.List<com.ingramcontent.consolidated.labels.model.CopyLabelSignal> copyLabels;

	public Item() {
	}

	public java.lang.Integer getItemId() {
		return this.itemId;
	}

	public void setItemId(java.lang.Integer itemId) {
		this.itemId = itemId;
	}

	public java.util.List<com.ingramcontent.consolidated.labels.model.CopyLabelSignal> getCopyLabels() {
		return this.copyLabels;
	}

	public void setCopyLabels(
			java.util.List<com.ingramcontent.consolidated.labels.model.CopyLabelSignal> copyLabels) {
		this.copyLabels = copyLabels;
	}

	public java.lang.Integer getStatusID() {
		return this.statusID;
	}

	public void setStatusID(java.lang.Integer statusID) {
		this.statusID = statusID;
	}

	public Item(
			java.lang.Integer statusID,
			java.lang.Integer itemId,
			java.util.List<com.ingramcontent.consolidated.labels.model.CopyLabelSignal> copyLabels) {
		this.statusID = statusID;
		this.itemId = itemId;
		this.copyLabels = copyLabels;
	}

}