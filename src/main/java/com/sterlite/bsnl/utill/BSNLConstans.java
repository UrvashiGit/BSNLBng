package com.sterlite.bsnl.utill;

public class BSNLConstans {

	public static final String circularPath = "/root/BSNL-BNG/circulars/";

	public static final String localPath = "D:\\task\\bsnl bng\\reregexcelpdfformat\\";

	public static final String sqlZoneWiseDetailed = "select b.phase,b.zonename,b.circlename,b.circlecode,b.location,b.ssacode,b.bngtype,b.EXITNEWTRAIN,b.bngid,c.SiteSurvey, "
			+ " c.SiteReady,c.MaterialDelivery, "
			+ " c.PowerOn,c.NWIntegration,c.AT,c.Commissinong,c.ATC,a.ERPPO,a.MIGO,a.MIRO,a.PaymentStatus from (select bngid,bngtype,if( Name_exp_3='ERP PO',status,NULL ) as 'ERPPO',max(if( Name_exp_3='MIGO',status,NULL ))  as 'MIGO', "
			+ "  max(if( Name_exp_3='MIRO',status,NULL ))  as 'MIRO', "
			+ "  max(if( Name_exp_3='Payment Status',status,NULL )) as 'PaymentStatus' " + " from test  "
			+ " group by bngid,bngtype) a, "
			+ " (select bngid,bngtype,max(if( Name_exp_3='Site Survey',status,NULL )) as 'SiteSurvey',max(if( Name_exp_3='Site Ready',status,NULL ))  as 'SiteReady', "
			+ " max(if( Name_exp_3='Material Delivery',status,NULL ))  as 'MaterialDelivery', "
			+ " max(if( Name_exp_3='Power On',status,NULL )) as 'PowerOn', "
			+ " max(if( Name_exp_3='NW Integration',status,NULL )) as 'NWIntegration', "
			+ " max(if( Name_exp_3='AT',status,NULL )) as 'AT', "
			+ " max(if( Name_exp_3='Commissinong',status,NULL )) as 'Commissinong', "
			+ " max(if( Name_exp_3='ATC',status,NULL )) as 'ATC' from test1  group by bngid " + " ) c, " + " TBLBNGMASTER b where c.bngid=a.bngid and c.bngid=b.bngid  "
			+ " group by b.bngid ";
	

	public static final String sqlCircleWiseDetailed = "select b.phase,b.circlename,b.circlecode,b.location,b.ssacode,b.bngtype,b.EXITNEWTRAIN,b.bngid,c.SiteSurvey,c.SiteReady, c.MaterialDelivery, "
			+ " c.PowerOn,c.NWIntegration,c.AT,c.Commissinong,c.ATC,a.ERPPO,a.MIGO,a.MIRO,a.PaymentStatus from (select bngid,bngtype,if( Name_exp_3='ERP PO',status,NULL ) as 'ERPPO',max(if( Name_exp_3='MIGO',status,NULL ))  as 'MIGO', "
			+ "  max(if( Name_exp_3='MIRO',status,NULL ))  as 'MIRO', "
			+ " max(if( Name_exp_3='Payment Status',status,NULL )) as 'PaymentStatus' " + " from test "
			+ " group by bngid,bngtype) a, "
			+ " (select bngid,bngtype,max(if( Name_exp_3='Site Survey',status,NULL )) as 'SiteSurvey',max(if( Name_exp_3='Site Ready',status,NULL ))  as 'SiteReady', "
			+ "  max(if( Name_exp_3='Material Delivery',status,NULL ))  as 'MaterialDelivery', "
			+ "  max(if( Name_exp_3='Power On',status,NULL )) as 'PowerOn', "
			+ "  max(if( Name_exp_3='NW Integration',status,NULL )) as 'NWIntegration', "
			+ "  max(if( Name_exp_3='AT',status,NULL )) as 'AT', "
			+ "  max(if( Name_exp_3='Commissinong',status,NULL )) as 'Commissinong', "
			+ "  max(if( Name_exp_3='ATC',status,NULL )) as 'ATC' from test1 group by bngid " + "  ) c, " + " TBLBNGMASTER b  where c.bngid=a.bngid and c.bngid=b.bngid "  
			+ " group by b.bngid,b.bngtype  " + " order by b.circlename ";

	public static final String sqlZoneWiseSummary = "";

	public static final String sqlCircleWiseSummary = "";

	public static final String sqlSingleBNGIAndCStatus = "select B.STAGENAME,A.STATUS,A.CLOSEDATE,A.TARGETDATE,B.ORDERID,A.bngid from \r\n"
			+ "TBLBNGINSTANDCOMMISTAGE A, TBLBNGINSTANDCOMMISTAGEODER B where B.STAGEID=A.STAGEID and A.bngid= :bngid  order by B.STAGEID";
	
	public static final String sqlSingleBNGInvStatus = "select B.STAGENAME,A.STATUS,A.CLOSEDATE,A.TARGETDATE, A.JV,B.ORDERID,A.bngid  from TBLBNGINVOICEANFAPYMENTSTAGE A, TBLBNGINVOICEANDPAYMENTSTAGEODER B where B.STAGEID=A.STAGEID and A.bngid= :bngid order by B.STAGEID";
	
	
	//Query to Update BNG INS Stage Detail
	
	public static final String updateBNGInsStageDetail= "update TBLBNGINSTANDCOMMISTAGE A set A.TARGETDATE =:TDATE, A.CLOSEDATE=:CLDATE, A.STATUS=:STATUS ,A.LASTMODIFIEDDATE=SYSDATE(), A.LATMODIFIEDBY=1 where BNGID=:bngId and  A.STAGEID=:stageId";
	
	
	/** Constanst for BNG  I & C*/
	
	public static final String SITE_SURVEY="Site Survey";
	public static final String SITE_READY="Site Ready";
	public static final String MATERIAL_DELIVERY="Material Delivery";
	public static final String POWER_ON="Power On";
	public static final String NW_INTEGRATION="NW Integration";
	public static final String AT="AT";
	public static final String COMMISIONING="Commissinong";
	public static final String ATC="ATC";
	
	/** Constanst for BNG  Inv*/

	public static final String ERP_PO="ERP PO";
	public static final String MIGO="MIGO";
	public static final String MIRO="MIRO";
	public static final String PAYMENT_STATUS="Payment Status";
	

}