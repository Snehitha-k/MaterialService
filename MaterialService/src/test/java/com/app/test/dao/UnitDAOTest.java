package com.app.test.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.app.business.bean.UnitBean;
import com.app.service.UnitService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UnitDAOTest {
	
	@Autowired 
	private UnitService unitService;
	
	@Test
	public void notNullUnitServiceTest() {
		assertNotNull(unitService);
	}	
	
	@Test
	public void getUnitByCategoryIdTest() {
		List<UnitBean> unitBeans=unitService.getUnits("C001");
		assertNotNull(unitBeans);
		assertEquals(unitBeans.size(),2);
		
	}	
	@Test
	public void getUnitsTest() {
		List<UnitBean> unitBeans=unitService.getUnits("C001");
		assertNotNull(unitBeans);
		assertEquals(unitBeans.size(),2);
		
	}	
}
