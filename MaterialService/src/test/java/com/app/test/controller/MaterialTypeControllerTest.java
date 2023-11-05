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

import com.app.business.bean.MaterialTypeBean;
import com.app.controller.MaterialTypeController;
import com.app.service.MaterialTypeService;

@RunWith(SpringRunner.class)
@WebMvcTest(MaterialTypeController.class)
public class MaterialTypeControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private MaterialTypeService materialTypeServiceMock;
	
	/*
	 * 
	 * Uncomment the below test for testing the 'materialType/controller/getMaterialTypes' mapping and it should fail
	 * After implementing the handler method in MaterialTypeController execute the test again
	 * The below test case should pass once the MaterialTypeController handler method is implemented properly
	 * 
	 * */
	@Test
	public void getMaterialTypesTest() throws Exception {

		List<MaterialTypeBean> materialTypeBeans = new ArrayList<>();
		
		MaterialTypeBean bean = null;
		bean = new MaterialTypeBean("T001","Silk-Thread", "C001");
		materialTypeBeans.add(bean);
		bean = new MaterialTypeBean("T002","Silk-Cloth", "C002");
		materialTypeBeans.add(bean);		
		bean = new MaterialTypeBean("T003","Linen-Thread", "C001");
		materialTypeBeans.add(bean);	
		bean = new MaterialTypeBean("T004","Linen-Cloth", "C002");
		materialTypeBeans.add(bean);
		bean = new MaterialTypeBean("T005","Silk-Button", "C003");
		materialTypeBeans.add(bean);		
		bean = new MaterialTypeBean("T006","Suit-Button", "C003");
		materialTypeBeans.add(bean);

		when(materialTypeServiceMock.getMaterialTypes()).thenReturn(materialTypeBeans);
		
		mockMvc.perform(MockMvcRequestBuilders.get("/materialType/controller/getTypeDetails"))
		.andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
		
		//check size of json object
		.andExpect(jsonPath("$", hasSize(6)))
		
		//check if the json node exists
		.andExpect(jsonPath("$[0].typeId").exists())
		.andExpect(jsonPath("$[0].typeName").exists())
		.andExpect(jsonPath("$[0].categoryId").exists())
		
		//check if the type of json node
		.andExpect(jsonPath("$[0].typeId").isString())
		.andExpect(jsonPath("$[0].typeName").isString())
		.andExpect(jsonPath("$[0].categoryId").isString())
		
		//check the return value
		.andExpect(jsonPath("$[0].typeId").value("T001"))
		.andExpect(jsonPath("$[0].typeName").value("Silk-Thread"))
		.andExpect(jsonPath("$[0].categoryId").value("C001"));

	}
	/*
	 * 
	 * Uncomment the below test for testing the 'materialType/controller/getMaterialTypeCategoryById/{categoryId}' mapping and it should fail
	 * After implementing the handler method in MaterialTypeController execute the test again
	 * The below test case should pass once the MaterialTypeController handler method is implemented properly
	 * 
	 * */
	@Test
	public void getMaterialTypesByCategoryIdTest() throws Exception {
		String categoryId = "C001";
		List<MaterialTypeBean> materialTypeBeans = new ArrayList<>();
		
		MaterialTypeBean bean = null;
		bean = new MaterialTypeBean("T001","Silk-Thread", "C001");
		materialTypeBeans.add(bean);
		bean = new MaterialTypeBean("T003","Linen-Thread", "C001");
		materialTypeBeans.add(bean);	
		
		/*
		 * Write your code
		 */
		when(materialTypeServiceMock.getMaterialTypes(categoryId)).thenReturn(materialTypeBeans);
		
		mockMvc.perform(MockMvcRequestBuilders.get("/materialType/controller/getTypeBasedOnCategoryId/"+categoryId))
		.andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
		
		//check size of json object
		.andExpect(jsonPath("$", hasSize(2)))
		
		//check if the json node exists
		.andExpect(jsonPath("$[0].typeId").exists())
		.andExpect(jsonPath("$[0].typeName").exists())
		.andExpect(jsonPath("$[0].categoryId").exists())
		
		//check if the type of json node
		.andExpect(jsonPath("$[0].typeId").isString())
		.andExpect(jsonPath("$[0].typeName").isString())
		.andExpect(jsonPath("$[0].categoryId").isString())
		
		//check the return value
		.andExpect(jsonPath("$[0].typeId").value("T001"))
		.andExpect(jsonPath("$[0].typeName").value("Silk-Thread"))
		.andExpect(jsonPath("$[0].categoryId").value("C001"));	
	}
}
