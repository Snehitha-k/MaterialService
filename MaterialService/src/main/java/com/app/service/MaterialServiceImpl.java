package com.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.business.bean.MaterialCategoryBean;
import com.app.dao.MaterialCategoryDAO;
import com.app.entity.MaterialCategoryEntity;

@Service
public class MaterialServiceImpl implements MaterialService {
	
	/*
	 * Autowire MaterialCategoryDAO object
	 * 
	 * */
	// Your Code Here
	@Autowired
	private MaterialCategoryDAO materialCategoryDAO;
	

	/*
	 * Method - getMaterialCategoryById()
	 * Use MaterialCategoryDAO object findById method to fetch the entity by --> categoryId
	 * Check if the entity is present
	 * 		initialized the materialCategoryBean object
	 * 		copy the properties value from entity to materialCategoryBean object
	 * */
	
	@Override
	public MaterialCategoryBean getMaterialCategoryById(String categoryId) {
		
		MaterialCategoryBean materialCategoryBean = null;
		MaterialCategoryEntity materialCategoryEntity = materialCategoryDAO.getOne(categoryId);
		materialCategoryBean= new MaterialCategoryBean();
		BeanUtils.copyProperties(materialCategoryEntity, materialCategoryBean);
		return materialCategoryBean;
	}

	
	/*
	 * Method - getMaterialCategories()
	 * Use the MaterialCategoryDAO to get all the MaterialCategoryEntity objects
	 * Check if list is not empty then 
	 * 		Declare a MaterialCategoryBean object with null value
	 * 		Loop through all the material categories
	 * 			Initialize a new MaterialCategoryBean object 
	 * 			Copy each property value of entity object to bean object
	 * 			Add the bean object to the materialCategoryBeans list
	 * */

	
	@Override
	public List<MaterialCategoryBean> getMaterialCategories() {
		
		List<MaterialCategoryBean> materialCategoryBeans = new ArrayList<MaterialCategoryBean>();
		List<MaterialCategoryEntity> materialCategoryEntities=materialCategoryDAO.findAll();
		materialCategoryEntities.forEach(materialCategoryEntity -> {
			MaterialCategoryBean materialCategoryBean = new MaterialCategoryBean();
			BeanUtils.copyProperties(materialCategoryEntity, materialCategoryBean);
			materialCategoryBeans.add(materialCategoryBean);
			
		});
		return materialCategoryBeans;
	}

}
