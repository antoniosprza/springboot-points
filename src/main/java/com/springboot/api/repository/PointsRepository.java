package com.springboot.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.api.model.Points;

@Repository
public interface PointsRepository extends JpaRepository<Points, Long>{

}
