package com.thoughtworks.gaia.product.repository;

import com.thoughtworks.gaia.product.model.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductModel, Long> {

    List<ProductModel> findByNameAndIsDeleted(String name, boolean isDeleted);

    @Query(nativeQuery = true,
            value = "select p.* from PRODUCT p where name=:product_name and is_deleted=false order by time_created desc limit 1")
    ProductModel findLatestProductByName(@Param("product_name") String productName);
}
