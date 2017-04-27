package test.functional.product;

import com.thoughtworks.gaia.GaiaApplication;
import com.thoughtworks.gaia.common.constant.EnvProfile;
import com.thoughtworks.gaia.common.exception.NotFoundException;
import com.thoughtworks.gaia.product.entity.Product;
import com.thoughtworks.gaia.product.model.ProductModel;
import com.thoughtworks.gaia.product.repository.ProductRepository;
import com.thoughtworks.gaia.product.service.ProductService;
import org.joda.time.DateTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(GaiaApplication.class)
@Rollback
@Transactional
@ActiveProfiles({EnvProfile.TEST})
public class ProductServiceFunctionalTest {
    @Autowired
    private ProductService productService;

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void should_get_product_with_id() throws Exception {
        ProductModel productModel = dummyProductModel();
        productRepository.save(productModel);
        Long productId = productModel.getId();

        Product product = productService.getProduct(productId);

        assertThat(product.getId()).isEqualTo(productId);
    }

    @Test
    public void should_get_product_with_name() throws Exception {
        ProductModel productModel = dummyProductModel();
        productRepository.save(productModel);
        String productName = productModel.getName();
        Long productId = productModel.getId();

        List<Product> products = productService.getProductsByName(productName);

        assertThat(products.size()).isEqualTo(1);
        assertThat(products.get(0).getId()).isEqualTo(productId);
    }

    @Test
    public void should_get_latest_product_with_name() throws Exception {
        ProductModel firstProductModel = dummyProductModel();
        ProductModel secondProductModel = dummyProductModel();
        delayCreateTime(secondProductModel);

        productRepository.save(firstProductModel);
        productRepository.save(secondProductModel);

        String latestProductName = secondProductModel.getName();
        Long latestProductId = secondProductModel.getId();

        Product product = productService.getLatestProductByName(latestProductName);
        assertThat(product.getId()).isEqualTo(latestProductId);

    }

    private void delayCreateTime(ProductModel secondProductModel) {
        secondProductModel.setTimeCreated(new Date(new Date().getTime() + 5 * 60 * 1000));
    }

    private ProductModel dummyProductModel() {
        ProductModel productModel = new ProductModel();
        productModel.setName("name");
        productModel.setTimeCreated(DateTime.now().toDate());
        return productModel;
    }

    @Test(expected = NotFoundException.class)
    public void should_throw_exception_when_not_found() {
        productService.getProduct(-1L);
    }
}
