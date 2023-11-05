package com.app.test.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.app.dao.MaterialTypeDAO;
import com.app.entity.MaterialTypeEntity;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MaterialTypeDAOTest {
	
	@Autowired
	private MaterialTypeDAO materialTypeDAO;
	
	@Test
	public void notNullMaterialTypeDAOTest() {
		assertNotNull(materialTypeDAO);
		
	}
	
	@Test
	public void findByIdMaterialTypeTest() {
		MaterialTypeEntity materialTypeEntity = materialTypeDAO.findOne("T001");
		assertNotNull(materialTypeEntity);	
	}
	
	@Test
	public void findByCategoryIdTest() {
		List<MaterialTypeEntity> materialTypeEntity=materialTypeDAO.findByCategoryId("C001");
		assertNotNull(materialTypeEntity);
		assertEquals(materialTypeEntity.size(),2);
	}
	

}
