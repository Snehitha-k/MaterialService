package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.entity.UnitEntity;

public interface UnitDAO extends JpaRepository<UnitEntity, String>{
	@Query("SELECT E FROM UnitEntity E WHERE E.categoryEntity.categoryId=?1")
	List<UnitEntity> findByCategoryId(String categoryId);

}
