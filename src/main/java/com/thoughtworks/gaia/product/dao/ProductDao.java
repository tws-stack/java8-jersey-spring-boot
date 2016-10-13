package com.thoughtworks.gaia.product.dao;

import com.thoughtworks.gaia.common.jpa.BaseDaoWrapper;
import com.thoughtworks.gaia.product.model.ProductModel;
import org.springframework.stereotype.Component;

@Component
public class ProductDao extends BaseDaoWrapper<ProductModel> {
    public ProductDao() {
        super(ProductModel.class);
    }
}
