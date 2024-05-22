
package com.behl.cerberus.repository.Restaurant;


import com.behl.cerberus.entity.Restaurant.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<ClientEntity, Long> {
    ClientEntity findByDocument(String document);
    void deleteByDocument(String document);
    boolean existsByDocument(String document);

}
