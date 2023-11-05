package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.entity.MaterialTypeEntity;


public interface MaterialTypeDAO extends JpaRepository<MaterialTypeEntity, String>{
	@Query("SELECT E FROM MaterialTypeEntity E WHERE E.categoryEntity.categoryId=?1")
	List<MaterialTypeEntity> findByCategoryId(String categoryId);
}
