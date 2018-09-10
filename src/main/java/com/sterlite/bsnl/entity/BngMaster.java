package com.sterlite.bsnl.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TBLBNGMASTER")
public class BngMaster implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="BNGID")
	private String id;
	
	@Column(name="PHASE")
	private String phase;
	
	@Column(name="ZONENAME")
	private String zoneName;
	
	@Column(name="CIRCLENAME")
	private String circleName;
	
	@Column(name="CIRCLECODE")
	private String circleCode;
	
	@Column(name="LOCATION")
	private String location;	
	
	@Column(name="SSACODE")
	private String ssaCode;
	
	@Column(name="BNGTYPE")
	private String bngType;
	
	@Column(name="EXITNEWTRAIN")
	private String exitNewTrain;
	
	@Column(name="SITENAMELOCATION")
	private String siteNameLocation;
	
	@Column(name="CIRCLECOORDINATEDET")
	private String circleCoordinatorDet;	
	
	@Column(name="CONSIGNEEDET")
	private String consigneeDet;
	
	@Column(name="SITEADDRESS")
	private String siteAddress;
	
	@Column(name="SITEPERSONDET")
	private String sitePersonDet;
	
	@Column(name="SITECONTACTNO")
	private String siteContactNo;
	
	@Column(name="GSTIN")
	private String gstin;
	
	@Column(name="ORDERBICID")
	private int orderBicId;
	
	@Column(name="ORDERBINVID")
	private int orderBInvId;
	
	@Column(name="CREATEDDATE")
	private Date createdDate;
	
	@Column(name="LASTMODIFIEDDATE")
	private Date lastModifiDate;
	
	@Column(name="CREATEDBY")
	private int createdBy;
	
	@Column(name="LATMODIFIEDBY")
	private int modifiedBy;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPhase() {
		return phase;
	}

	public void setPhase(String phase) {
		this.phase = phase;
	}

	public String getZoneName() {
		return zoneName;
	}

	public void setZoneName(String zoneName) {
		this.zoneName = zoneName;
	}

	public String getCircleName() {
		return circleName;
	}

	public void setCircleName(String circleName) {
		this.circleName = circleName;
	}

	public String getCircleCode() {
		return circleCode;
	}

	public void setCircleCode(String circleCode) {
		this.circleCode = circleCode;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getSsaCode() {
		return ssaCode;
	}

	public void setSsaCode(String ssaCode) {
		this.ssaCode = ssaCode;
	}

	public String getBngType() {
		return bngType;
	}

	public void setBngType(String bngType) {
		this.bngType = bngType;
	}

	public String getExitNewTrain() {
		return exitNewTrain;
	}

	public void setExitNewTrain(String exitNewTrain) {
		this.exitNewTrain = exitNewTrain;
	}

	public String getSiteNameLocation() {
		return siteNameLocation;
	}

	public void setSiteNameLocation(String siteNameLocation) {
		this.siteNameLocation = siteNameLocation;
	}

	public String getCircleCoordinatorDet() {
		return circleCoordinatorDet;
	}

	public void setCircleCoordinatorDet(String circleCoordinatorDet) {
		this.circleCoordinatorDet = circleCoordinatorDet;
	}

	public String getConsigneeDet() {
		return consigneeDet;
	}

	public void setConsigneeDet(String consigneeDet) {
		this.consigneeDet = consigneeDet;
	}

	public String getSiteAddress() {
		return siteAddress;
	}

	public void setSiteAddress(String siteAddress) {
		this.siteAddress = siteAddress;
	}

	public String getSitePersonDet() {
		return sitePersonDet;
	}

	public void setSitePersonDet(String sitePersonDet) {
		this.sitePersonDet = sitePersonDet;
	}

	public String getSiteContactNo() {
		return siteContactNo;
	}

	public void setSiteContactNo(String siteContactNo) {
		this.siteContactNo = siteContactNo;
	}

	public String getGstin() {
		return gstin;
	}

	public void setGstin(String gstin) {
		this.gstin = gstin;
	}

	public int getOrderBicId() {
		return orderBicId;
	}

	public void setOrderBicId(int orderBicId) {
		this.orderBicId = orderBicId;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getLastModifiDate() {
		return lastModifiDate;
	}

	public void setLastModifiDate(Date lastModifiDate) {
		this.lastModifiDate = lastModifiDate;
	}

	public int getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}

	public int getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(int modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public int getOrderBInvId() {
		return orderBInvId;
	}

	public void setOrderBInvId(int orderBInvId) {
		this.orderBInvId = orderBInvId;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BngMaster [id=").append(id).append(", phase=").append(phase).append(", zoneName=")
				.append(zoneName).append(", circleName=").append(circleName).append(", circleCode=").append(circleCode)
				.append(", location=").append(location).append(", ssaCode=").append(ssaCode).append(", bngType=")
				.append(bngType).append(", exitNewTrain=").append(exitNewTrain).append(", siteNameLocation=")
				.append(siteNameLocation).append(", circleCoordinatorDet=").append(circleCoordinatorDet)
				.append(", consigneeDet=").append(consigneeDet).append(", siteAddress=").append(siteAddress)
				.append(", sitePersonDet=").append(sitePersonDet).append(", siteContactNo=").append(siteContactNo)
				.append(", gstin=").append(gstin).append(", orderBicId=").append(orderBicId).append(", orderBInvId=")
				.append(orderBInvId).append(", createdDate=").append(createdDate).append(", lastModifiDate=")
				.append(lastModifiDate).append(", createdBy=").append(createdBy).append(", modifiedBy=")
				.append(modifiedBy).append("]");
		return builder.toString();
	}
	
	
	

}
