package com.sterlite.bsnl.dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.itextpdf.text.pdf.PdfStructTreeController.returnType;
import com.sterlite.bsnl.entity.BngMaster;
import com.sterlite.bsnl.entity.CircularMaster;
import com.sterlite.bsnl.model.SingleBNGInstAndCmsnModel;
import com.sterlite.bsnl.model.SingleBNGInvModel;
import com.sterlite.bsnl.model.SummaryModel;
import com.sterlite.bsnl.model.ZoneWiseDetailed;
import com.sterlite.bsnl.utill.BSNLConstans;

@Transactional
@Repository
public class BngMasterDaoImpl implements IBngMasterDAO {

	@PersistenceContext
	private EntityManager entityManager;

	
	//@Autowired
	//private SessionFactory sessionFactory;
	
	private Session getSession() {
        return entityManager.unwrap(Session.class);
    }
	
	@Override
	public List<BngMaster> getBngMasterList() {
		String hql = "FROM BngMaster as atcl ORDER BY atcl.id";
		return (List<BngMaster>) entityManager.createQuery(hql).getResultList();
		//return null;
	}
	
	@Override
	public List<CircularMaster> getCircularMasterList() {
		String hql = "FROM CircularMaster as cm ORDER BY cm.circulardate desc";
		return (List<CircularMaster>) entityManager.createQuery(hql).getResultList();
		//return null;
	}

	@SuppressWarnings("deprecation")
	@Override
	public List getZoneWiseDetailedReportDAO() {
		
		// TODO Auto-generated method stub
		Session session;
		String hqlFetch;
		List<Object[]> listOfZoneWise = null;
		List<ZoneWiseDetailed> zoneWiseDetailedList=new ArrayList<>();
		System.out.println("Inside getZoneWiseDetailedReportDAO()");
		try{
			session = getSession(); 
	 		hqlFetch = BSNLConstans.sqlZoneWiseDetailed; 
	 		System.out.println("hqlFetch :  "+ hqlFetch);
	 		listOfZoneWise = session.createSQLQuery(hqlFetch).list(); 
	 		System.out.println(listOfZoneWise.get(0));
	 		System.out.println("Size "+ listOfZoneWise.size());
			//session.close();
	 		if(!CollectionUtils.isEmpty(listOfZoneWise)){
	 			//System.out.println("inside if ");
	 			for (Object[] row : listOfZoneWise){
	 				
	 				ZoneWiseDetailed zwd=new ZoneWiseDetailed();
	 				zwd.setPhase(row[0].toString());
	 				zwd.setZoneName(row[1].toString());
	 				zwd.setCircleName(row[2].toString());
	 				zwd.setCircleCode(row[3].toString());
	 				zwd.setLocation(row[4].toString());
	 				zwd.setSSACode(row[5].toString());
	 				zwd.setBNGType(row[6].toString());
	 				zwd.setExistNewTrain(row[7].toString());
	 				zwd.setBNGID(row[8].toString());
	 				zwd.setSiteSurvey(row[9].toString());
	 				zwd.setSiteReady(row[10].toString());
	 				zwd.setMaterialDelivery(row[11].toString());
	 				zwd.setPowerOn(row[12].toString());
	 				zwd.setNWIntegration(row[13].toString());
	 				zwd.setAT(row[14].toString());
	 				zwd.setCommissioning(row[15].toString());
	 				zwd.setATC(row[16].toString());
	 				zwd.setERPPO(row[17].toString());
	 				zwd.setMIGO(row[18].toString());
	 				zwd.setMIRO(row[19].toString());
	 				zwd.setPaymentStatus(row[20].toString());
	 				zoneWiseDetailedList.add(zwd);
	 				//System.out.println( "row :  "+ zwd.toString());
	 				
	 			}
			return zoneWiseDetailedList;
	 		}
			
		}
		catch(Exception e){
			e.printStackTrace();
			System.out.println("BngMasterDaoImpl.getZoneWiseDetailedReportDAO() : Catch : Exception : "+ e.getMessage());
		}
		return zoneWiseDetailedList;
		//return null;
		
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public List getCircleWiseDetailedReportDAO() {
		
		// TODO Auto-generated method stub
		Session session;
		String hqlFetch;
		List<Object[]> listOfCircleWise = null;
		List<ZoneWiseDetailed> circleWiseDetailedList=new ArrayList<>();
		System.out.println("Inside getCircleWiseDetailedReportDAO()");
		try{
			session = getSession(); 
	 		hqlFetch = BSNLConstans.sqlCircleWiseDetailed; 
	 		System.out.println("hqlFetch :  "+ hqlFetch);
	 		listOfCircleWise = session.createSQLQuery(hqlFetch).list(); 
	 		//System.out.println(listOfCircleWise.get(0));
	 		//System.out.println("Size "+ listOfCircleWise.size());
			//session.close();
	 		if(!CollectionUtils.isEmpty(listOfCircleWise)){
	 		//	System.out.println("inside if ");
	 			for (Object[] row : listOfCircleWise){
	 			
	 				ZoneWiseDetailed cwd=new ZoneWiseDetailed();
	 				cwd.setPhase(row[0].toString());
	 				//cwd.setZoneName(row[1].toString());
	 				cwd.setCircleName(row[1].toString());
	 				cwd.setCircleCode(row[2].toString());
	 				cwd.setLocation(row[3].toString());
	 				cwd.setSSACode(row[4].toString());
	 				cwd.setBNGType(row[5].toString());
	 				cwd.setExistNewTrain(row[6].toString());
	 				cwd.setBNGID(row[7].toString());
	 				cwd.setSiteSurvey(row[8].toString());
	 				cwd.setSiteReady(row[9].toString());
	 				cwd.setMaterialDelivery(row[10].toString());
	 				cwd.setPowerOn(row[11].toString());
	 				cwd.setNWIntegration(row[12].toString());
	 				cwd.setAT(row[13].toString());
	 				cwd.setCommissioning(row[14].toString());
	 				cwd.setATC(row[15].toString());
	 				cwd.setERPPO(row[16].toString());
	 				cwd.setMIGO(row[17].toString());
	 				cwd.setMIRO(row[18].toString());
	 				cwd.setPaymentStatus(row[19].toString());
	 				circleWiseDetailedList.add(cwd);
	 			//	System.out.println( "row :  "+ cwd.toString());
	 				
	 			}
			return circleWiseDetailedList;
	 		}
			
		}
		catch(Exception e){
			e.printStackTrace();
			System.out.println("BngMasterDaoImpl.getCircleWiseDetailedReportDAO() : Catch : Exception : "+ e.getMessage());
		}
		return circleWiseDetailedList;
		//return null;
		
	}

	@Override
	public List<SummaryModel> getZoneWiseSummaryReportDAO() {
		// TODO Auto-generated method stub
		Session session;
		String hqlFetch;
		List<Object[]> listOfZoneWiseS = null;
		List<SummaryModel> zoneWiseSummaryList=new ArrayList<>();
		System.out.println("Inside getZoneWiseSummaryReportDAO()");
		try{
			session = getSession(); 
	 		hqlFetch = BSNLConstans.sqlZoneWiseSummary; 
	 		System.out.println("hqlFetch :  "+ hqlFetch);
	 		listOfZoneWiseS = session.createSQLQuery(hqlFetch).list(); 
	 		//System.out.println(listOfCircleWise.get(0));
	 		//System.out.println("Size "+ listOfCircleWise.size());
			//session.close();
	 		if(!CollectionUtils.isEmpty(listOfZoneWiseS)){
	 		//	System.out.println("inside if ");
	 			for (Object[] row : listOfZoneWiseS){
	 			
	 				SummaryModel cwd=new SummaryModel();
	 				cwd.setPhase(row[0].toString());
	 				//cwd.setZoneName(row[1].toString());
	 				cwd.setCircleName(row[1].toString());
	 				cwd.setCircleCode(row[2].toString());
	 				cwd.setTotalBng(row[3].toString());
	 				/*cwd.setCircleName(row[3].toString());
	 				cwd.setCircleCode(row[4].toString());*/
	 				cwd.setSiteSurvey(row[4].toString());
	 				cwd.setSiteReady(row[5].toString());
	 				cwd.setMaterialDelivery(row[6].toString());
	 				cwd.setPowerOn(row[7].toString());
	 				cwd.setNWIntegration(row[8].toString());
	 				cwd.setAT(row[9].toString());
	 				cwd.setCommissioning(row[10].toString());
	 				cwd.setATC(row[11].toString());
	 				cwd.setERPPO(row[12].toString());
	 				cwd.setMIGO(row[13].toString());
	 				cwd.setMIRO(row[14].toString());
	 				cwd.setPaymentStatus(row[15].toString());
	 				zoneWiseSummaryList.add(cwd);
	 			//	System.out.println( "row :  "+ cwd.toString());
	 				
	 			}
			return zoneWiseSummaryList;
	 		}
			
		}
		catch(Exception e){
			e.printStackTrace();
			System.out.println("BngMasterDaoImpl.getZoneWiseSummaryReportDAO() : Catch : Exception : "+ e.getMessage());
		}
		return zoneWiseSummaryList;
		//return null;
	}

	@Override
	public List<SummaryModel> getCircleWiseSummaryReportDAO() {
		// TODO Auto-generated method stub
		Session session;
		String hqlFetch;
		List<Object[]> listOfCircleWiseS = null;
		List<SummaryModel> circleWiseSummaryList=new ArrayList<>();
		System.out.println("Inside getCircleWiseSummaryReportDAO()");
		try{
			session = getSession(); 
	 		hqlFetch = BSNLConstans.sqlCircleWiseSummary; 
	 		System.out.println("hqlFetch :  "+ hqlFetch);
	 		listOfCircleWiseS = session.createSQLQuery(hqlFetch).list(); 
	 		//System.out.println(listOfCircleWise.get(0));
	 		//System.out.println("Size "+ listOfCircleWise.size());
			//session.close();
	 		if(!CollectionUtils.isEmpty(listOfCircleWiseS)){
	 		//	System.out.println("inside if ");
	 			for (Object[] row : listOfCircleWiseS){
	 			
	 				SummaryModel cwd=new SummaryModel();
	 				cwd.setPhase(row[0].toString());
	 				//cwd.setZoneName(row[1].toString());
	 				//cwd.setZoneName(row[1].toString());
	 				cwd.setCircleName(row[1].toString());
	 				cwd.setCircleCode(row[2].toString());
	 				cwd.setTotalBng(row[3].toString());
	 				
	 				cwd.setSiteSurvey(row[4].toString());
	 				cwd.setSiteReady(row[5].toString());
	 				cwd.setMaterialDelivery(row[6].toString());
	 				cwd.setPowerOn(row[7].toString());
	 				cwd.setNWIntegration(row[8].toString());
	 				cwd.setAT(row[9].toString());
	 				cwd.setCommissioning(row[10].toString());
	 				cwd.setATC(row[11].toString());
	 				cwd.setERPPO(row[12].toString());
	 				cwd.setMIGO(row[13].toString());
	 				cwd.setMIRO(row[14].toString());
	 				cwd.setPaymentStatus(row[15].toString());
	 				circleWiseSummaryList.add(cwd);
	 			//	System.out.println( "row :  "+ cwd.toString());
	 				
	 			}
			return circleWiseSummaryList;
	 		}
			
		}
		catch(Exception e){
			e.printStackTrace();
			System.out.println("BngMasterDaoImpl.getZoneWiseSummaryReportDAO() : Catch : Exception : "+ e.getMessage());
		}
		return circleWiseSummaryList;
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public Map<String,SingleBNGInstAndCmsnModel> getSingleBNGIAndCStatusDAO(String bngId,int currentOrderId) {
		
		Session session;
		String hqlFetch;
		List<Object[]> listOfSingleBNG = null;
		Map<String, SingleBNGInstAndCmsnModel> map= new LinkedHashMap<>();
		System.out.println("Inside getSingleBNGIAndCStatusDAO()");
		try{
			session = getSession(); 
	 		hqlFetch = BSNLConstans.sqlSingleBNGIAndCStatus; 
	 		System.out.println("hqlFetch :  "+ hqlFetch);
	 		//int i=0;
	 		listOfSingleBNG= session.createSQLQuery(hqlFetch).setParameter("bngid", bngId).list();
	 		System.out.println(listOfSingleBNG.size());
	 		if(!CollectionUtils.isEmpty(listOfSingleBNG)) {
	 			for (Object[] row : listOfSingleBNG){
	 				 //map= new HashMap<>();
	 				if(BSNLConstans.SITE_SURVEY.equals(row[0].toString())) {
	 					SingleBNGInstAndCmsnModel singleBNGInstAndCmsnModel=new SingleBNGInstAndCmsnModel();
	 					singleBNGInstAndCmsnModel.setCurrentBNGOrderId(currentOrderId);
	 					singleBNGInstAndCmsnModel.setStatus(row[1].toString());
	 					if(null !=row[2]){
	 						singleBNGInstAndCmsnModel.setCloseDate((Date) row[2]);
	 				//	singleBNGInstAndCmsnModel.setCloseDate(new SimpleDateFormat("yyyy-mm-dd").parse(row[2].toString()));
	 					}
	 					if(null !=row[3]){
	 						singleBNGInstAndCmsnModel.setTargetDate((Date) row[3]);
	 				//	singleBNGInstAndCmsnModel.setCloseDate(new SimpleDateFormat("yyyy-mm-dd").parse(row[3].toString()));
	 					}
	 					singleBNGInstAndCmsnModel.setOrderId((int) row[4]);
	 					singleBNGInstAndCmsnModel.setBngid(row[5].toString());
	 					if(row[6] != null) {
	 						singleBNGInstAndCmsnModel.setRemark(row[6].toString());
	 					}
	 					map.put(row[0].toString(),singleBNGInstAndCmsnModel);
	 					System.out.println(map);
	 				}
	 				else if(BSNLConstans.SITE_READY.equals(row[0].toString())) {
	 					SingleBNGInstAndCmsnModel singleBNGInstAndCmsnModel=new SingleBNGInstAndCmsnModel();
	 					singleBNGInstAndCmsnModel.setCurrentBNGOrderId(currentOrderId);
	 					singleBNGInstAndCmsnModel.setStatus(row[1].toString());
	 					if(null !=row[2]){
	 						singleBNGInstAndCmsnModel.setCloseDate((Date) row[2]);
	 				//	singleBNGInstAndCmsnModel.setCloseDate(new SimpleDateFormat("yyyy-mm-dd").parse(row[2].toString()));
	 					}
	 					if(null !=row[3]){
	 						singleBNGInstAndCmsnModel.setTargetDate((Date) row[3]);
	 				//	singleBNGInstAndCmsnModel.setCloseDate(new SimpleDateFormat("yyyy-mm-dd").parse(row[3].toString()));
	 					}
	 					singleBNGInstAndCmsnModel.setOrderId((int) row[4]);
	 					singleBNGInstAndCmsnModel.setBngid(row[5].toString());
	 					if(row[6] != null) {
	 						singleBNGInstAndCmsnModel.setRemark(row[6].toString());
	 					}
	 					
	 					map.put(row[0].toString(),singleBNGInstAndCmsnModel);
	 					System.out.println(map);
	 				}
	 				else if(BSNLConstans.MATERIAL_DELIVERY.equals(row[0].toString())) {
	 					SingleBNGInstAndCmsnModel singleBNGInstAndCmsnModel=new SingleBNGInstAndCmsnModel();
	 					singleBNGInstAndCmsnModel.setCurrentBNGOrderId(currentOrderId);
	 					singleBNGInstAndCmsnModel.setStatus(row[1].toString());
	 					if(null !=row[2]){
	 						singleBNGInstAndCmsnModel.setCloseDate((Date) row[2]);
	 				//	singleBNGInstAndCmsnModel.setCloseDate(new SimpleDateFormat("yyyy-mm-dd").parse(row[2].toString()));
	 					}
	 					if(null !=row[3]){
	 						singleBNGInstAndCmsnModel.setTargetDate((Date) row[3]);
	 				//	singleBNGInstAndCmsnModel.setCloseDate(new SimpleDateFormat("yyyy-mm-dd").parse(row[3].toString()));
	 					}
	 					singleBNGInstAndCmsnModel.setOrderId((int) row[4]);
	 					singleBNGInstAndCmsnModel.setBngid(row[5].toString());
	 					if(row[6] != null) {
	 						singleBNGInstAndCmsnModel.setRemark(row[6].toString());
	 					}
	 					
	 					map.put(row[0].toString(),singleBNGInstAndCmsnModel);
	 					System.out.println(map);
	 				}
	 				else if(BSNLConstans.POWER_ON.equals(row[0].toString())) {
	 					SingleBNGInstAndCmsnModel singleBNGInstAndCmsnModel=new SingleBNGInstAndCmsnModel();
	 					singleBNGInstAndCmsnModel.setCurrentBNGOrderId(currentOrderId);
	 					singleBNGInstAndCmsnModel.setStatus(row[1].toString());
	 					if(null !=row[2]){
	 						singleBNGInstAndCmsnModel.setCloseDate((Date) row[2]);
	 				//	singleBNGInstAndCmsnModel.setCloseDate(new SimpleDateFormat("yyyy-mm-dd").parse(row[2].toString()));
	 					}
	 					if(null !=row[3]){
	 						singleBNGInstAndCmsnModel.setTargetDate((Date) row[3]);
	 				//	singleBNGInstAndCmsnModel.setCloseDate(new SimpleDateFormat("yyyy-mm-dd").parse(row[3].toString()));
	 					}
	 					singleBNGInstAndCmsnModel.setOrderId((int) row[4]);
	 					singleBNGInstAndCmsnModel.setBngid(row[5].toString());
	 					if(row[6] != null) {
	 						singleBNGInstAndCmsnModel.setRemark(row[6].toString());
	 					}
	 					
	 					map.put(row[0].toString(),singleBNGInstAndCmsnModel);
	 					System.out.println(map);
	 				}
	 				else if(BSNLConstans.NW_INTEGRATION.equals(row[0].toString())) {
	 					SingleBNGInstAndCmsnModel singleBNGInstAndCmsnModel=new SingleBNGInstAndCmsnModel();
	 					singleBNGInstAndCmsnModel.setCurrentBNGOrderId(currentOrderId);
	 					singleBNGInstAndCmsnModel.setStatus(row[1].toString());
	 					if(null !=row[2]){
	 						singleBNGInstAndCmsnModel.setCloseDate((Date) row[2]);
	 				//	singleBNGInstAndCmsnModel.setCloseDate(new SimpleDateFormat("yyyy-mm-dd").parse(row[2].toString()));
	 					}
	 					if(null !=row[3]){
	 						singleBNGInstAndCmsnModel.setTargetDate((Date) row[3]);
	 				//	singleBNGInstAndCmsnModel.setCloseDate(new SimpleDateFormat("yyyy-mm-dd").parse(row[3].toString()));
	 					}
	 					singleBNGInstAndCmsnModel.setOrderId((int) row[4]);
	 					singleBNGInstAndCmsnModel.setBngid(row[5].toString());
	 					if(row[6] != null) {
	 						singleBNGInstAndCmsnModel.setRemark(row[6].toString());
	 					}
	 					
	 					map.put(row[0].toString(),singleBNGInstAndCmsnModel);
	 					System.out.println(map);
	 				}
	 				else if(BSNLConstans.AT.equals(row[0].toString())) {
	 					SingleBNGInstAndCmsnModel singleBNGInstAndCmsnModel=new SingleBNGInstAndCmsnModel();
	 					singleBNGInstAndCmsnModel.setCurrentBNGOrderId(currentOrderId);
	 					singleBNGInstAndCmsnModel.setStatus(row[1].toString());
	 					if(null !=row[2]){
	 						singleBNGInstAndCmsnModel.setCloseDate((Date) row[2]);
	 				//	singleBNGInstAndCmsnModel.setCloseDate(new SimpleDateFormat("yyyy-mm-dd").parse(row[2].toString()));
	 					}
	 					if(null !=row[3]){
	 						singleBNGInstAndCmsnModel.setTargetDate((Date) row[3]);
	 				//	singleBNGInstAndCmsnModel.setCloseDate(new SimpleDateFormat("yyyy-mm-dd").parse(row[3].toString()));
	 					}
	 					singleBNGInstAndCmsnModel.setOrderId((int) row[4]);
	 					singleBNGInstAndCmsnModel.setBngid(row[5].toString());
	 					if(row[6] != null) {
	 						singleBNGInstAndCmsnModel.setRemark(row[6].toString());
	 					}
	 					
	 					map.put(row[0].toString(),singleBNGInstAndCmsnModel);
	 					System.out.println(map);
	 				}
	 				else if(BSNLConstans.COMMISIONING.equals(row[0].toString())) {
	 					SingleBNGInstAndCmsnModel singleBNGInstAndCmsnModel=new SingleBNGInstAndCmsnModel();
	 					singleBNGInstAndCmsnModel.setCurrentBNGOrderId(currentOrderId);
	 					singleBNGInstAndCmsnModel.setStatus(row[1].toString());
	 					if(null !=row[2]){
	 						singleBNGInstAndCmsnModel.setCloseDate((Date) row[2]);
	 				//	singleBNGInstAndCmsnModel.setCloseDate(new SimpleDateFormat("yyyy-mm-dd").parse(row[2].toString()));
	 					}
	 					if(null !=row[3]){
	 						singleBNGInstAndCmsnModel.setTargetDate((Date) row[3]);
	 				//	singleBNGInstAndCmsnModel.setCloseDate(new SimpleDateFormat("yyyy-mm-dd").parse(row[3].toString()));
	 					}
	 					singleBNGInstAndCmsnModel.setOrderId((int) row[4]);
	 					singleBNGInstAndCmsnModel.setBngid(row[5].toString());
	 					if(row[6] != null) {
	 						singleBNGInstAndCmsnModel.setRemark(row[6].toString());
	 					}
	 					
	 					map.put(row[0].toString(),singleBNGInstAndCmsnModel);
	 					System.out.println(map);
	 				}
	 				else if(BSNLConstans.ATC.equals(row[0].toString())) {
	 					SingleBNGInstAndCmsnModel singleBNGInstAndCmsnModel=new SingleBNGInstAndCmsnModel();
	 					singleBNGInstAndCmsnModel.setCurrentBNGOrderId(currentOrderId);
	 					singleBNGInstAndCmsnModel.setStatus(row[1].toString());
	 					if(null !=row[2]){
	 						singleBNGInstAndCmsnModel.setCloseDate((Date) row[2]);
	 				//	singleBNGInstAndCmsnModel.setCloseDate(new SimpleDateFormat("yyyy-mm-dd").parse(row[2].toString()));
	 					}
	 					if(null !=row[3]){
	 						singleBNGInstAndCmsnModel.setTargetDate((Date) row[3]);
	 				//	singleBNGInstAndCmsnModel.setCloseDate(new SimpleDateFormat("yyyy-mm-dd").parse(row[3].toString()));
	 					}
	 					singleBNGInstAndCmsnModel.setOrderId((int) row[4]);
	 					singleBNGInstAndCmsnModel.setBngid(row[5].toString());
	 					if(row[6] != null) {
	 						singleBNGInstAndCmsnModel.setRemark(row[6].toString());
	 					}
	 					
	 					map.put(row[0].toString(),singleBNGInstAndCmsnModel);
	 					System.out.println(map);
	 				}
	 			}
	 			
	 		}
		}catch(Exception e) {
			
			e.printStackTrace();
		}
		System.out.println("DAO : "+map.size());
		return map;
	}
	@Override
	public Map<String, SingleBNGInvModel> getSingleBNGInvDAO(String bngId) {
		Session session;
		String hqlFetch;
		List<Object[]> listOfSingleBNG = null;
		Map<String, SingleBNGInvModel> map= new HashMap<>();
		System.out.println("Inside getSingleBNGInvDAO()");
		try{
			session = getSession(); 
	 		hqlFetch = BSNLConstans.sqlSingleBNGInvStatus; 
	 		System.out.println("hqlFetch :  "+ hqlFetch);
	 		//int i=0;
	 		listOfSingleBNG= session.createSQLQuery(hqlFetch).setParameter("bngid", bngId).list();
	 		System.out.println(listOfSingleBNG.size());
	 		if(!CollectionUtils.isEmpty(listOfSingleBNG)) {
	 			for (Object[] row : listOfSingleBNG){
	 				 //map= new HashMap<>();
	 				if(BSNLConstans.ERP_PO.equals(row[0].toString())) {
	 					SingleBNGInvModel singleBNGInvModel=new SingleBNGInvModel();
	 					singleBNGInvModel.setStatus(row[1].toString());
	 					if(null !=row[2]){
	 						singleBNGInvModel.setCloseDate(new SimpleDateFormat("yyyy-mm-dd").parse(row[2].toString()));
	 					}
	 					if(null !=row[3]){
	 						singleBNGInvModel.setCloseDate(new SimpleDateFormat("yyyy-mm-dd").parse(row[3].toString()));
	 					}
	 					singleBNGInvModel.setOrderId((int) row[4]);
	 					singleBNGInvModel.setBngid(row[5].toString());
	 					map.put(row[0].toString(),singleBNGInvModel);
	 					System.out.println(map);
	 				}
	 				else if(BSNLConstans.MIGO.equals(row[0].toString())) {
	 					SingleBNGInvModel singleBNGInvModel=new SingleBNGInvModel();
	 					singleBNGInvModel.setStatus(row[1].toString());
	 					if(null !=row[2]){
	 						singleBNGInvModel.setCloseDate(new SimpleDateFormat("yyyy-mm-dd").parse(row[2].toString()));
	 					}
	 					if(null !=row[3]){
	 						singleBNGInvModel.setCloseDate(new SimpleDateFormat("yyyy-mm-dd").parse(row[3].toString()));
	 					}
	 					singleBNGInvModel.setOrderId((int) row[4]);
	 					singleBNGInvModel.setBngid(row[5].toString());
	 					map.put(row[0].toString(),singleBNGInvModel);
	 					System.out.println(map);
	 				}
	 				else if(BSNLConstans.MIRO.equals(row[0].toString())) {
	 					SingleBNGInvModel singleBNGInvModel=new SingleBNGInvModel();
	 					singleBNGInvModel.setStatus(row[1].toString());
	 					if(null !=row[2]){
	 						singleBNGInvModel.setCloseDate(new SimpleDateFormat("yyyy-mm-dd").parse(row[2].toString()));
	 					}
	 					if(null !=row[3]){
	 						singleBNGInvModel.setCloseDate(new SimpleDateFormat("yyyy-mm-dd").parse(row[3].toString()));
	 					}
	 					singleBNGInvModel.setOrderId((int) row[4]);
	 					singleBNGInvModel.setBngid(row[5].toString());
	 					map.put(row[0].toString(),singleBNGInvModel);
	 					System.out.println(map);
	 				}
	 				else if(BSNLConstans.PAYMENT_STATUS.equals(row[0].toString())) {
	 					SingleBNGInvModel singleBNGInvModel=new SingleBNGInvModel();
	 					singleBNGInvModel.setStatus(row[1].toString());
	 					if(null !=row[2]){
	 						singleBNGInvModel.setCloseDate(new SimpleDateFormat("yyyy-mm-dd").parse(row[2].toString()));
	 					}
	 					if(null !=row[3]){
	 						singleBNGInvModel.setCloseDate(new SimpleDateFormat("yyyy-mm-dd").parse(row[3].toString()));
	 					}
	 					singleBNGInvModel.setOrderId((int) row[4]);
	 					singleBNGInvModel.setBngid(row[5].toString());
	 					map.put(row[0].toString(),singleBNGInvModel);
	 					System.out.println(map);
	 				}
	 				
	 			}
	 			
	 		}
		}catch(Exception e) {
			
			e.printStackTrace();
		}
		System.out.println("DAO : "+map.size());
		return map;
	}
	
	@Override
	public int updateBngINSStage(SingleBNGInstAndCmsnModel singleModel) {
		// update BNG stage info
		//update TBLBNGINSTANDCOMMISTAGE A set A.TARGETDATE =:TDATE, A.CLOSEDATE=:CLDATE, 
		//A.STATUS=:STATUS ,A.LASTMODIFIEDDATE=SYSDATE(), A.LATMODIFIEDBY=1 where BNGID=:bngId and  A.STAGEID=:stageId";
		
		Session session;
		String updateQuery;
		
		try{
			updateQuery = BSNLConstans.updateBNGInsStageDetail;
			session = getSession(); 
	 		System.out.println("hqlFetch >> :  "+ updateQuery);
	 		//int i=0;
	 		int queryStatus = session.createSQLQuery(updateQuery).setParameter("TDATE", singleModel.getTargetDate()).setParameter("CLDATE", singleModel.getCloseDate()).
	 		setParameter("STATUS",singleModel.getStatus()).setParameter("REMARK", singleModel.getRemark()).
	 		setParameter("bngId", singleModel.getBngid()).setParameter("stageId", singleModel.getOrderId()).executeUpdate();
	 		
	 		if(queryStatus > 0) {
	 			System.out.println("Executed");
	 		}
	 		
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return 0;
	}

	@Override
	public String getBngICStageStatusByStageId(String bngId,int stageId) {

		Session session;
		String query;
		String status = null;
		
		try{
			query = BSNLConstans.getBngICStageStatusByStageId;
			session = getSession(); 
	 		System.out.println("hqlFetch >> :  "+ query);
	 		
	 		Object result = session.createSQLQuery(query).setParameter("bngId", bngId).setParameter("stageId", stageId).getSingleResult();
	 		if(result != null) {
	 			status = result.toString();
	 			System.out.println("Result >>"+status);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return status;
		
	}


}
