package com.example.light.feature.supervisiors.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SupervisorDto {
	private String jurisdiction;
	private String lastName;
	private String firstName;
	@Override
	public String toString() {
		return jurisdiction + " - " + lastName + ", " + firstName;
	}
	
}
