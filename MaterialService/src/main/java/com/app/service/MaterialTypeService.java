package com.app.service;

import java.util.List;

import com.app.business.bean.MaterialTypeBean;

public interface MaterialTypeService {
	
	List<MaterialTypeBean> getMaterialTypes(String categoryId);
	List<MaterialTypeBean> getMaterialTypes();
}
