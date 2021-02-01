package com.springboot.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.api.exception.ResourceNotFoundException;
import com.springboot.api.model.Points;
import com.springboot.api.repository.PointsRepository;

@RestController
@RequestMapping("/api/")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
public class PointsController{
	
	@Autowired
	private PointsRepository pointRepository;
	
	@GetMapping("points")
	public List<Points> getAll(){
		return this.pointRepository.findAll();
	}
	
	@GetMapping("points/{id}")
	public ResponseEntity<Points> getPointById(@PathVariable(value = "id") Long cartodbId)throws ResourceNotFoundException{
		Points points = pointRepository.findById(cartodbId).orElseThrow(() -> new ResourceNotFoundException("Id: " + cartodbId + " cartográfico no encontrado "));
		
		return ResponseEntity.ok().body(points);
	}
		

}
