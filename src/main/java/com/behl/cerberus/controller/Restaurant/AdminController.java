package com.behl.cerberus.controller.Restaurant;

import com.behl.cerberus.service.Restaurant.admin.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@PreAuthorize("hasAuthority('fullaccess')")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/{document}")
    public ResponseEntity<String> UpdateStatusAdmin(@PathVariable String document){
        adminService.UpdateStatusAdmin(document);
        return ResponseEntity.status(204).body("");
    }
}
