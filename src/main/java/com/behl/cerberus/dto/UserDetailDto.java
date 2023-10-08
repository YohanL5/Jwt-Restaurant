package com.behl.cerberus.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Builder;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;

@Getter
@Builder
@Jacksonized
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(value = PropertyNamingStrategies.UpperCamelCaseStrategy.class)
public class UserDetailDto {

	private String firstName;
	private String lastName;
	private String emailId;
	private String status;
	private LocalDate dateOfBirth;
	private LocalDateTime createdAt;

}
