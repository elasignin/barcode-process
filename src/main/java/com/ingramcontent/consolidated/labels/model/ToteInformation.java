package com.ingramcontent.consolidated.labels.model;

/**
 * This class was automatically generated by the data modeler tool.
 */

public class ToteInformation implements java.io.Serializable {

	static final long serialVersionUID = 1L;

	private java.lang.String oeNumber;
	private java.lang.String plRunNumber;
	private java.lang.String shipTo;
	private java.lang.String parentShip;
	private int toteId;
	private java.lang.String toteBarcode;
	private int copyCount;
	private int status;
	private com.ingramcontent.consolidated.labels.model.BarcodeRules barcodeRules;
	private java.lang.String createdByUserId;
	private java.lang.String createDate;
	private java.lang.String updatedByUserId;
	private java.lang.String updateDate;
	private com.ingramcontent.consolidated.labels.model.CopyLabel copyLabels;

	public ToteInformation() {
	}

	public java.lang.String getOeNumber() {
		return this.oeNumber;
	}

	public void setOeNumber(java.lang.String oeNumber) {
		this.oeNumber = oeNumber;
	}

	public java.lang.String getPlRunNumber() {
		return this.plRunNumber;
	}

	public void setPlRunNumber(java.lang.String plRunNumber) {
		this.plRunNumber = plRunNumber;
	}

	public java.lang.String getShipTo() {
		return this.shipTo;
	}

	public void setShipTo(java.lang.String shipTo) {
		this.shipTo = shipTo;
	}

	public java.lang.String getParentShip() {
		return this.parentShip;
	}

	public void setParentShip(java.lang.String parentShip) {
		this.parentShip = parentShip;
	}

	public int getToteId() {
		return this.toteId;
	}

	public void setToteId(int toteId) {
		this.toteId = toteId;
	}

	public java.lang.String getToteBarcode() {
		return this.toteBarcode;
	}

	public void setToteBarcode(java.lang.String toteBarcode) {
		this.toteBarcode = toteBarcode;
	}

	public int getCopyCount() {
		return this.copyCount;
	}

	public void setCopyCount(int copyCount) {
		this.copyCount = copyCount;
	}

	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public com.ingramcontent.consolidated.labels.model.BarcodeRules getBarcodeRules() {
		return this.barcodeRules;
	}

	public void setBarcodeRules(
			com.ingramcontent.consolidated.labels.model.BarcodeRules barcodeRules) {
		this.barcodeRules = barcodeRules;
	}

	public java.lang.String getCreatedByUserId() {
		return this.createdByUserId;
	}

	public void setCreatedByUserId(java.lang.String createdByUserId) {
		this.createdByUserId = createdByUserId;
	}

	public java.lang.String getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(java.lang.String createDate) {
		this.createDate = createDate;
	}

	public java.lang.String getUpdatedByUserId() {
		return this.updatedByUserId;
	}

	public void setUpdatedByUserId(java.lang.String updatedByUserId) {
		this.updatedByUserId = updatedByUserId;
	}

	public java.lang.String getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(java.lang.String updateDate) {
		this.updateDate = updateDate;
	}

	public com.ingramcontent.consolidated.labels.model.CopyLabel getCopyLabels() {
		return this.copyLabels;
	}

	public void setCopyLabels(
			com.ingramcontent.consolidated.labels.model.CopyLabel copyLabels) {
		this.copyLabels = copyLabels;
	}

	public ToteInformation(
			java.lang.String oeNumber,
			java.lang.String plRunNumber,
			java.lang.String shipTo,
			java.lang.String parentShip,
			int toteId,
			java.lang.String toteBarcode,
			int copyCount,
			int status,
			com.ingramcontent.consolidated.labels.model.BarcodeRules barcodeRules,
			java.lang.String createdByUserId, java.lang.String createDate,
			java.lang.String updatedByUserId, java.lang.String updateDate,
			com.ingramcontent.consolidated.labels.model.CopyLabel copyLabels) {
		this.oeNumber = oeNumber;
		this.plRunNumber = plRunNumber;
		this.shipTo = shipTo;
		this.parentShip = parentShip;
		this.toteId = toteId;
		this.toteBarcode = toteBarcode;
		this.copyCount = copyCount;
		this.status = status;
		this.barcodeRules = barcodeRules;
		this.createdByUserId = createdByUserId;
		this.createDate = createDate;
		this.updatedByUserId = updatedByUserId;
		this.updateDate = updateDate;
		this.copyLabels = copyLabels;
	}

}