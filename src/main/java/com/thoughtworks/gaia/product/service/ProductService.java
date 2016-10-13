package com.thoughtworks.gaia.product.service;

import com.thoughtworks.gaia.common.Loggable;
import com.thoughtworks.gaia.common.exception.NotFoundException;
import com.thoughtworks.gaia.product.ProductMapper;
import com.thoughtworks.gaia.product.dao.ProductDao;
import com.thoughtworks.gaia.product.entity.Product;
import com.thoughtworks.gaia.product.model.ProductModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class ProductService implements Loggable {
    @Autowired
    private ProductMapper mapper;

    @Autowired
    private ProductDao productDao;

    public Product getProduct(Long productId) {
        ProductModel productModel = productDao.idEquals(productId).querySingle();
        if (productModel == null) {
            error("Product not found with id: " + productId);
            throw new NotFoundException();
        }

        return mapper.map(productModel, Product.class);
    }
}
