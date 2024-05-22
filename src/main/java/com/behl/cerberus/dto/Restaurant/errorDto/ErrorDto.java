package com.behl.cerberus.dto.Restaurant.errorDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ErrorDto {
  private String uuid;
  private String timeStamp;
  private String message;
}
