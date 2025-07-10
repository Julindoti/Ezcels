package com.managenament_sys.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.managenament_sys.modules.Vendas;

public interface SellsRepository extends JpaRepository <Vendas , Long>{}