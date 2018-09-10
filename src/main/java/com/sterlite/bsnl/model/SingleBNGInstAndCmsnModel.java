package com.sterlite.bsnl.model;

import java.util.Date;

public class SingleBNGInstAndCmsnModel {
	
	private String Status;
	private Date closeDate;
	private Date targetDate;
	private int orderId;
	private String stageName;
	private String bngid;
	public String getBngid() {
		return bngid;
	}
	public void setBngid(String bngid) {
		this.bngid = bngid;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getStageName() {
		return stageName;
	}
	public void setStageName(String stageName) {
		this.stageName = stageName;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public Date getCloseDate() {
		return closeDate;
	}
	public void setCloseDate(Date closeDate) {
		this.closeDate = closeDate;
	}
	public Date getTargetDate() {
		return targetDate;
	}
	public void setTargetDate(Date targetDate) {
		this.targetDate = targetDate;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SingleBNGInstAndCmsnModel [Status=").append(Status).append(", closeDate=").append(closeDate)
				.append(", targetDate=").append(targetDate).append(", orderId=").append(orderId).append(", stageName=")
				.append(stageName).append(", bngid=").append(bngid).append("]");
		return builder.toString();
	}
	
	
}
