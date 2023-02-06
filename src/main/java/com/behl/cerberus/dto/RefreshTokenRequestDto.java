package com.behl.cerberus.dto;

import java.io.Serializable;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;

@Getter
@Builder
@Jacksonized
public class RefreshTokenRequestDto implements Serializable {

	private static final long serialVersionUID = 7278113015247374755L;

	@NotBlank(message = "Refresh token must not be empty")
	@Schema(requiredMode = RequiredMode.REQUIRED, description = "refresh-token received during successfull login")
	private final String refreshToken;

}
