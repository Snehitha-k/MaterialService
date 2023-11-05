package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entity.MaterialCategoryEntity;


public interface MaterialCategoryDAO extends JpaRepository<MaterialCategoryEntity, String>{}