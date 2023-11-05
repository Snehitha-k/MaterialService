package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.business.bean.UnitBean;
import com.app.service.UnitService;

@RestController
public class UnitController {
	
	@Autowired
	private UnitService unitService;
	
	@RequestMapping(value= "/unit/controller/getUnits", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<UnitBean>> getUnits(){
		List<UnitBean> unitBeans = unitService.getUnits();
		return new ResponseEntity<List<UnitBean>> (unitBeans,HttpStatus.OK);
	}
	
	@RequestMapping(value= "/unit/controller/getUnitsByCategoryId/{categoryId}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<UnitBean>> getUnitsByCategoryId(@PathVariable String categoryId){
		List<UnitBean> unitBeans=unitService.getUnits(categoryId);
		return new ResponseEntity<List<UnitBean>> (unitBeans,HttpStatus.OK);	
	}

}
