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

import com.app.business.bean.MaterialTypeBean;
import com.app.service.MaterialTypeService;

@RestController
public class MaterialTypeController {
	
	@Autowired
	private MaterialTypeService materialTypeService;
	
	@RequestMapping(value= "/materialType/controller/getTypeDetails", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<MaterialTypeBean>> getTypeDetails(){
		List<MaterialTypeBean> mTbeans = materialTypeService.getMaterialTypes();
		return new ResponseEntity<List<MaterialTypeBean>>(mTbeans,HttpStatus.OK);
	}
	
	@RequestMapping(value= "/materialType/controller/getTypeBasedOnCategoryId/{categoryId}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<MaterialTypeBean>> getTypeBasedOnCategoryId(@PathVariable String categoryId){
		List<MaterialTypeBean> mTbeans=materialTypeService.getMaterialTypes(categoryId);
		return new ResponseEntity<List<MaterialTypeBean>> (mTbeans,HttpStatus.OK);	
	}
}
