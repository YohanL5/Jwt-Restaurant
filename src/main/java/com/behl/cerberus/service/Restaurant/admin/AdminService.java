package com.behl.cerberus.service.Restaurant.admin;

import com.behl.cerberus.entity.Restaurant.ClientEntity;
import com.behl.cerberus.entity.UserStatus;
import com.behl.cerberus.repository.Restaurant.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService implements IAdminService{

    @Autowired
    private AdminRepository adminRepository;

    @Override
    public void UpdateStatusAdmin(String document) {
        //Add validations
        ClientEntity clientEntity= adminRepository.findByDocument(document);
        adminRepository.save(clientEntity);
    }
}
