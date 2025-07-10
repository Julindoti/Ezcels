package com.managenament_sys.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.managenament_sys.modules.Produto;

public interface ProductRepository extends JpaRepository <Produto , Long>{}