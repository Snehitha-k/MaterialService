package com.app.service;

import java.util.List;

import com.app.business.bean.MaterialCategoryBean;

public interface MaterialService {
	MaterialCategoryBean getMaterialCategoryById(String categoryId);
	List<MaterialCategoryBean> getMaterialCategories();
}
