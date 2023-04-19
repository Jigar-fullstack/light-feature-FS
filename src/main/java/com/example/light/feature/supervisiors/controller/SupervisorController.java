package com.example.light.feature.supervisiors.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.light.feature.supervisiors.dto.SupervisorDto;
import com.example.light.feature.supervisiors.service.SuperVisorService;


@RestController
@RequestMapping("/api")
public class SupervisorController {

	@Autowired
	private SuperVisorService superVisorService;
	
	@GetMapping("/supervisors")
	public ResponseEntity<List<SupervisorDto>> getSupervisor() {
		return ResponseEntity.ok(superVisorService.getSupervisors());
	}
}
