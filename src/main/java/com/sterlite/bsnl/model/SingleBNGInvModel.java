
package com.sterlite.bsnl.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class SingleBNGInvModel {
	
	private String Status;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date closeDate;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date targetDate;
	private String JV;
	private int orderId;
	private String stageName;
	private String bngid;
	private int currentBNGOrderId;
	public String getBngid() {
		return bngid;
	}
	public int getCurrentBNGOrderId() {
		return currentBNGOrderId;
	}
	public void setCurrentBNGOrderId(int currentBNGOrderId) {
		this.currentBNGOrderId = currentBNGOrderId;
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
	public String getJV() {
		return JV;
	}
	public void setJV(String jV) {
		JV = jV;
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
		builder.append("SingleBNGInvModel [Status=").append(Status).append(", closeDate=").append(closeDate)
				.append(", targetDate=").append(targetDate).append(", JV=").append(JV).append(", orderId=")
				.append(orderId).append(", stageName=").append(stageName).append(", bngid=").append(bngid)
				.append(", currentBNGOrderId=").append(currentBNGOrderId).append("]");
		return builder.toString();
	}
	
	
}
