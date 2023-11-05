package com.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.business.bean.UnitBean;
import com.app.dao.UnitDAO;
import com.app.entity.UnitEntity;

@Service
public class UnitServiceImpl implements UnitService {

	@Autowired
	private UnitDAO unitDAO;
	
	public UnitServiceImpl() {
		super();
	}

	@Override
	public List<UnitBean> getUnits(String categoryId) {
		List<UnitBean> unitBeans = new ArrayList<UnitBean>();
		List<UnitEntity> unitEntities = unitDAO.findByCategoryId(categoryId);
		unitEntities.forEach(unitEntity -> {
			UnitBean unitBean= new UnitBean();
			unitBean.setCategoryId(unitEntity.getCategoryEntity().getCategoryId());
			BeanUtils.copyProperties(unitEntity, unitBean);
			unitBeans.add(unitBean);
		});
		return unitBeans;
		
	}

	@Override
	public List<UnitBean> getUnits() {
		List<UnitBean> unitBeans = new ArrayList<UnitBean>();
		List<UnitEntity> unitEntities = unitDAO.findAll();
		unitEntities.forEach(unitEntity -> {
			UnitBean unitBean= new UnitBean();
			unitBean.setCategoryId(unitEntity.getCategoryEntity().getCategoryId());
			BeanUtils.copyProperties(unitEntity, unitBean);
			unitBeans.add(unitBean);
		});
		return unitBeans;
		
	}

}
