package com.managenament_sys.repository;

import org.springframework.stereotype.Repository;
import com.managenament_sys.modules.*;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository 
public interface UserRepository extends JpaRepository <Usuario , Long>{}