package com.example.light.feature.supervisiors.service;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.light.feature.supervisiors.dto.SupervisorDto;

@Service
public class SuperVisorService {

	private final String uri = "https://o3m5qixdng.execute-api.us-east-1.amazonaws.com/api/managers";
	@Autowired
	private RestTemplate restTemplate;
	
	public List<SupervisorDto> getSupervisors() {
	  ResponseEntity<SupervisorDto[]> responseEntity = restTemplate.getForEntity(uri, SupervisorDto[].class);
	  SupervisorDto[] supervisorObjects = responseEntity.getBody();
	  Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");
	  
	  List<SupervisorDto> list = Arrays.asList(supervisorObjects).stream()
			 .filter(s -> !pattern.matcher(s.getJurisdiction()).matches()).collect(Collectors.toList());
	  
	  list.sort(Comparator.comparing(SupervisorDto::getJurisdiction)
			  .thenComparing(SupervisorDto::getLastName)
			  .thenComparing(SupervisorDto::getFirstName));
	  
	  return list;
	}
}
