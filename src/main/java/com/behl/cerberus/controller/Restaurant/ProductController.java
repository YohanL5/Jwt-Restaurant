package com.behl.cerberus.controller.Restaurant;

import com.behl.cerberus.dto.Restaurant.ProductDTO;
import com.behl.cerberus.service.Restaurant.products.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/products")
@PreAuthorize("hasAuthority('fullaccessAdmin')")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping(path = "/{uuid}")
    public ResponseEntity<?> getProductByUuid (@PathVariable String uuid) {
        return ResponseEntity.ok(productService.getProductByUuid(uuid));
    }
    @PostMapping
    public ResponseEntity<ProductDTO> createProduct(@Valid @RequestBody ProductDTO productDTO){
            ProductDTO product=productService.createProduct(productDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(product);
    }
    @PutMapping(path = "/{uuid}")
    public ResponseEntity<?> updateProduct(@PathVariable String uuid, @Valid @RequestBody ProductDTO productDTO){
        productDTO.setUuid(uuid);
        productService.updateProduct(productDTO);
        return ResponseEntity.status(204).body("");
    }
    @DeleteMapping(path = "/{uuid}")
    public ResponseEntity<?> deleteProduct(@PathVariable String uuid){
        productService.deleteProduct(uuid);
        return ResponseEntity.status(204).body("");
    }





}
