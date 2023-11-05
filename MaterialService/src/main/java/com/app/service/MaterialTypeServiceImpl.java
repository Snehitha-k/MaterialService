package com.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.business.bean.MaterialTypeBean;
import com.app.dao.MaterialTypeDAO;
import com.app.entity.MaterialTypeEntity;


@Service
public class MaterialTypeServiceImpl implements MaterialTypeService {

	@Autowired
	private MaterialTypeDAO materialTypeDAO;
	
	
	public MaterialTypeServiceImpl() {
		super();
	}

	@Override
	public List<MaterialTypeBean> getMaterialTypes(String categoryId) {
		List<MaterialTypeBean> materialTypeBeans = new ArrayList<MaterialTypeBean>();
		List<MaterialTypeEntity> materialTypeEntities = materialTypeDAO.findByCategoryId(categoryId);
		materialTypeEntities.forEach(materialTypeEntity -> {
			MaterialTypeBean materialTypeBean= new MaterialTypeBean();
			materialTypeBean.setCategoryId(materialTypeEntity.getCategoryEntity().getCategoryId());
			BeanUtils.copyProperties(materialTypeEntity, materialTypeBean);
			materialTypeBeans.add(materialTypeBean);
		});
		return materialTypeBeans;
	}

	@Override
	public List<MaterialTypeBean> getMaterialTypes() {
		List<MaterialTypeBean> materialTypeBeans = new ArrayList<MaterialTypeBean>();
		List<MaterialTypeEntity> materialTypeEntities = materialTypeDAO.findAll();
		materialTypeEntities.forEach(materialTypeEntity -> {
			MaterialTypeBean materialTypeBean= new MaterialTypeBean();
			materialTypeBean.setCategoryId(materialTypeEntity.getCategoryEntity().getCategoryId());
			BeanUtils.copyProperties(materialTypeEntity, materialTypeBean);
			materialTypeBeans.add(materialTypeBean);
		});
		return materialTypeBeans;
	}

}
