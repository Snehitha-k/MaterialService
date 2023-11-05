package com.app.service;

import java.util.List;

import com.app.business.bean.UnitBean;

public interface UnitService {
	
	List<UnitBean> getUnits(String categoryId);
	List<UnitBean> getUnits();

}
