package com.behl.cerberus.dto.Restaurant;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class OrderDTO {
    private String uuid;
    private LocalDateTime creationDateTime;
    private String clientDocument;
    private String productUuid;
    private Integer quantity;
    private String extraInformation;
    private Double subTotal;
    private Double tax;
    private Double grandTotal;
    private Boolean delivered;
    private LocalDateTime deliveredDate;
}
