package com.app.test.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.app.business.bean.MaterialTypeBean;
import com.app.service.MaterialTypeService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MaterialTypeServiceTest {
	
	@Autowired
	private MaterialTypeService materialTypeService;

	@Test
	public void notNullMaterialTypeServiceTest() {
		assertNotNull(materialTypeService);	
	}
	
	@Test
	public void getMaterialTypeByCategoryIdTest() {
		List<MaterialTypeBean> materialTypeBeans = materialTypeService.getMaterialTypes("C001");
		assertNotNull(materialTypeBeans);
		assertEquals(materialTypeBeans.size(),2);
	}
	
	@Test
	public void getMaterialTypesTest() {
		List<MaterialTypeBean> materialTypeBeans = materialTypeService.getMaterialTypes();
		assertNotNull(materialTypeBeans);
		assertEquals(materialTypeBeans.size(),6);
	}
	
}
