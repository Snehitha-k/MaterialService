package com.app.test.controller;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.app.business.bean.UnitBean;
import com.app.controller.UnitController;
import com.app.service.UnitService;

@RunWith(SpringRunner.class)
@WebMvcTest(UnitController.class)
public class UnitControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private UnitService unitServiceMock;
	
	/*
	 * 
	 * Uncomment the below test for testing the 'unit/controller/getUnitDetails' mapping and it should fail
	 * After implementing the handler method in UnitController execute the test again
	 * The below test case should pass once the UnitController handler method is implemented properly
	 * 
	 * */
	@Test
	public void getUnitTypesTest() throws Exception {
		List<UnitBean> unitBeans = new ArrayList<>();
		UnitBean bean = null;
		bean = new UnitBean("U001","Meters", "C001");
		unitBeans.add(bean);
		bean = new UnitBean("U002","Meters", "C002");
		unitBeans.add(bean);
		bean = new UnitBean("U003","Centi Meters", "C001");
		unitBeans.add(bean);
		bean = new UnitBean("U004","Centi Meters", "C002");
		unitBeans.add(bean);
		bean = new UnitBean("U005","Kilo Grams", "C003");
		unitBeans.add(bean);

		/*
		 * Write your code
		 */
		when(unitServiceMock.getUnits()).thenReturn(unitBeans);
		
		mockMvc.perform(MockMvcRequestBuilders.get("/unit/controller/getUnits"))
		.andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
		
		//check size of json object
		.andExpect(jsonPath("$", hasSize(5)))
		
		//check if the json node exists
		.andExpect(jsonPath("$[0].unitId").exists())
		.andExpect(jsonPath("$[0].unitName").exists())
		.andExpect(jsonPath("$[0].categoryId").exists())
		
		
		//check if the type of json node
		.andExpect(jsonPath("$[0].unitId").isString())
		.andExpect(jsonPath("$[0].unitName").isString())
		.andExpect(jsonPath("$[0].categoryId").isString())
	
		
		//check the return value
		.andExpect(jsonPath("$[0].unitId").value("U001"))
		.andExpect(jsonPath("$[0].unitName").value("Meters"))
		.andExpect(jsonPath("$[0].categoryId").value("C001"));
	}
	/*
	 * 
	 * Uncomment the below test for testing the 'unit/controller/getUnitsByCategoryId/{categoryId}' mapping and it should fail
	 * After implementing the handler method in UnitController execute the test again
	 * The below test case should pass once the UnitController handler method is implemented properly
	 * 
	 * */
	@Test
	public void getUnitTypeByCategoryIdTest() throws Exception {
		String categoryId="C001";
		List<UnitBean> unitBeans = new ArrayList<>();
		UnitBean bean = null;
		bean = new UnitBean("U001","Meters", "C001");
		unitBeans.add(bean);
		bean = new UnitBean("U003","Centi Meters", "C001");
		unitBeans.add(bean);
		
		/*
		 * Write your code
		 */
		when(unitServiceMock.getUnits(categoryId)).thenReturn(unitBeans);
		
		mockMvc.perform(MockMvcRequestBuilders.get("/unit/controller/getUnitsByCategoryId/"+categoryId))
		.andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
		
		//check size of json object
		.andExpect(jsonPath("$", hasSize(2)))
		
		//check if the json node exists
		.andExpect(jsonPath("$[0].unitId").exists())
		.andExpect(jsonPath("$[0].unitName").exists())
		.andExpect(jsonPath("$[0].categoryId").exists())
		
		
		//check if the type of json node
		.andExpect(jsonPath("$[0].unitId").isString())
		.andExpect(jsonPath("$[0].unitName").isString())
		.andExpect(jsonPath("$[0].categoryId").isString())
	
		
		//check the return value
		.andExpect(jsonPath("$[0].unitId").value("U001"))
		.andExpect(jsonPath("$[0].unitName").value("Meters"))
		.andExpect(jsonPath("$[0].categoryId").value("C001"));
		
	}
}
