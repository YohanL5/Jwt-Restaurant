package com.behl.cerberus.service.Restaurant.products;

import com.behl.cerberus.UtilsRestaurant.exception.impl.FantasyNameExistsException;
import com.behl.cerberus.UtilsRestaurant.exception.impl.ProductNotFoundException;
import com.behl.cerberus.UtilsRestaurant.mapper.ProductMapper;
import com.behl.cerberus.UtilsRestaurant.validator.ProductValidator;
import com.behl.cerberus.dto.Restaurant.ProductDTO;
import com.behl.cerberus.entity.Restaurant.ProductEntity;
import com.behl.cerberus.repository.Restaurant.IProductRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class ProductService {

    @Autowired
    private final IProductRepositoryJPA productRepository;
    @Autowired
    private final ProductMapper mapper;
    @Autowired
    private final ProductValidator validator;
    public ProductService(IProductRepositoryJPA productRepository, ProductMapper mapper, ProductValidator validator) {
        this.productRepository = productRepository;
        this.mapper = mapper;
        this.validator = validator;
    }

    public ProductDTO getProductByUuid(String uuid) {
        validator.validateUuid(uuid);
        ProductEntity productResponse= productRepository.findByUuid(uuid);
        if (productResponse!=null) return  mapper.EntityToDTO(productResponse);
        throw new ProductNotFoundException("Producto no encontrado");

    }
    public ProductDTO createProduct(ProductDTO product){
        validator.validateProductDto(product);
        ProductEntity productEntity= mapper.DTOToEntity(product);
        if (productRepository.existsByfantasyName(productEntity.getFantasyName())){
            throw new FantasyNameExistsException("Producto con nombre fantasia ya existe");
        }
        return mapper.EntityToDTO(productRepository.save(productEntity));

    }
    public void updateProduct(ProductDTO product) {
        validator.validateUuid(product.getUuid());
        validator.validateProductDto(product);
        ProductEntity productExist= productRepository.findByUuid(product.getUuid());
        validator.validateProductExist(product,productExist);
        validator.productCompare(product,mapper.EntityToDTO(productExist));
        boolean exist= productRepository.existsByfantasyName(product.getFantasyName());
        validator.productExistFantasyName(productExist.getFantasyName(),product.getFantasyName(),exist);
        productExist.setFantasyName(product.getFantasyName().toUpperCase());
        productExist.setCategory(product.getCategory());
        productExist.setPrice(product.getPrice());
        productExist.setDescription(product.getDescription());
        productExist.setAvailable(product.getAvailable());
        productRepository.save(productExist);

    }

    public void deleteProduct(String uuid){
        validator.validateUuid(uuid);
        ProductEntity productExist= productRepository.findByUuid(uuid);
        if (productExist==null){
            throw  new ProductNotFoundException("Product with Uuid " + uuid + " not found");
        }
        productRepository.delete(productExist);

    }
}
