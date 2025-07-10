package com.managenament_sys.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.managenament_sys.modules.Gastos;

public interface CostsRepository extends JpaRepository <Gastos , Long>{}