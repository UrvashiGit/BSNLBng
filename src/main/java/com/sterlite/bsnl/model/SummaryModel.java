package com.sterlite.bsnl.model;

public class SummaryModel {
	
	private String Phase;
	private String ZoneName;
	private String totalBng;
	private String CircleName;
	private String CircleCode;
	private String SiteSurvey;
	private String SiteReady;
	private String MaterialDelivery;
	private String PowerOn;
	private String NWIntegration;
	private String AT;
	private String Commissioning;
	private String ATC;
	private String ERPPO;
	private String MIGO;
	private String MIRO;
	private String PaymentStatus;
	public String getPhase() {
		return Phase;
	}
	public void setPhase(String phase) {
		Phase = phase;
	}
	public String getZoneName() {
		return ZoneName;
	}
	public void setZoneName(String zoneName) {
		ZoneName = zoneName;
	}
	public String getTotalBng() {
		return totalBng;
	}
	public void setTotalBng(String totalBng) {
		this.totalBng = totalBng;
	}
	public String getCircleName() {
		return CircleName;
	}
	public void setCircleName(String circleName) {
		CircleName = circleName;
	}
	public String getCircleCode() {
		return CircleCode;
	}
	public void setCircleCode(String circleCode) {
		CircleCode = circleCode;
	}
	public String getSiteSurvey() {
		return SiteSurvey;
	}
	public void setSiteSurvey(String siteSurvey) {
		SiteSurvey = siteSurvey;
	}
	public String getSiteReady() {
		return SiteReady;
	}
	public void setSiteReady(String siteReady) {
		SiteReady = siteReady;
	}
	public String getMaterialDelivery() {
		return MaterialDelivery;
	}
	public void setMaterialDelivery(String materialDelivery) {
		MaterialDelivery = materialDelivery;
	}
	public String getPowerOn() {
		return PowerOn;
	}
	public void setPowerOn(String powerOn) {
		PowerOn = powerOn;
	}
	public String getNWIntegration() {
		return NWIntegration;
	}
	public void setNWIntegration(String nWIntegration) {
		NWIntegration = nWIntegration;
	}
	public String getAT() {
		return AT;
	}
	public void setAT(String aT) {
		AT = aT;
	}
	public String getCommissioning() {
		return Commissioning;
	}
	public void setCommissioning(String commissioning) {
		Commissioning = commissioning;
	}
	public String getATC() {
		return ATC;
	}
	public void setATC(String aTC) {
		ATC = aTC;
	}
	public String getERPPO() {
		return ERPPO;
	}
	public void setERPPO(String eRPPO) {
		ERPPO = eRPPO;
	}
	public String getMIGO() {
		return MIGO;
	}
	public void setMIGO(String mIGO) {
		MIGO = mIGO;
	}
	public String getMIRO() {
		return MIRO;
	}
	public void setMIRO(String mIRO) {
		MIRO = mIRO;
	}
	public String getPaymentStatus() {
		return PaymentStatus;
	}
	public void setPaymentStatus(String paymentStatus) {
		PaymentStatus = paymentStatus;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SummaryModel [Phase=").append(Phase).append(", ZoneName=").append(ZoneName)
				.append(", totalBng=").append(totalBng).append(", CircleName=").append(CircleName)
				.append(", CircleCode=").append(CircleCode).append(", SiteSurvey=").append(SiteSurvey)
				.append(", SiteReady=").append(SiteReady).append(", MaterialDelivery=").append(MaterialDelivery)
				.append(", PowerOn=").append(PowerOn).append(", NWIntegration=").append(NWIntegration).append(", AT=")
				.append(AT).append(", Commissioning=").append(Commissioning).append(", ATC=").append(ATC)
				.append(", ERPPO=").append(ERPPO).append(", MIGO=").append(MIGO).append(", MIRO=").append(MIRO)
				.append(", PaymentStatus=").append(PaymentStatus).append("]");
		return builder.toString();
	}
	
	

}
