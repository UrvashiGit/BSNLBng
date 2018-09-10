package com.sterlite.bsnl.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sterlite.bsnl.entity.CircularMaster;
import com.sterlite.bsnl.services.IBngService;
import com.sterlite.bsnl.utill.BSNLConstans;

@Controller
public class CircularController {

	@Autowired
	private IBngService bngMasterService;
	
	private static final String APPLICATION_PDF = "application/pdf";
	
	@RequestMapping("/circular")
	public ModelAndView circular() {
		
		List<CircularMaster> CircularMasterList = bngMasterService.getCircularMasterList();
		System.out.println(CircularMasterList.size());
		ModelAndView map = new ModelAndView("Circular2");
	    map.addObject("CircularMasterList", CircularMasterList);

	    return map;
	}
	
	/*@RequestMapping("/dowloadPDF")
	public ModelAndView downloadPDF(@RequestParam("getFileName") String getFileName) {
		
		System.out.println(getFileName);
		ModelAndView map = new ModelAndView("Circular2");
	    //map.addObject("CircularMasterList", CircularMasterList);
	    return map;
	}*/
	
	@RequestMapping(method = { RequestMethod.GET }, value = { "/dowloadPDF"})
    public void downloadPdf(HttpServletResponse response,@RequestParam("getFileName") String getFileName) throws IOException
    {
		if(!StringUtils.isEmpty(getFileName)){
		String fileP=BSNLConstans.circularPath+getFileName;
		System.out.println("File : "+ fileP);
		
		File file = new File(fileP);
		if(file.exists()){
        InputStream in = new FileInputStream(file);
        System.out.println("File exists");
        response.setContentType(APPLICATION_PDF);
        response.setHeader("Content-Disposition", "attachment; filename=" + file.getName());
        response.setHeader("Content-Length", String.valueOf(file.length()));
        System.out.println("inside");
        FileCopyUtils.copy(in, response.getOutputStream());
        
		   }else{
			   System.out.println("File does not  exists");
		   }
		
		}
       
    }	
}
