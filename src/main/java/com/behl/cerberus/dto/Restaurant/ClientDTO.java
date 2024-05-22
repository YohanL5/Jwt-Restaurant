package com.behl.cerberus.dto.Restaurant;

import com.behl.cerberus.entity.UserStatus;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClientDTO {
    public String document;
    public String name;
    public String email;
    public String phone;
    public String deliveryAddress;

}