package com.behl.cerberus.repository.Restaurant;

import com.behl.cerberus.entity.Restaurant.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository< ClientEntity,Long> {

    ClientEntity findByDocument(String document);
}
