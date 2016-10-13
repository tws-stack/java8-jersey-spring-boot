package com.thoughtworks.gaia;

import com.google.common.base.Joiner;
import io.swagger.jaxrs.config.BeanConfig;
import io.swagger.jaxrs.listing.ApiListingResource;
import io.swagger.jaxrs.listing.SwaggerSerializers;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.message.filtering.EntityFilteringFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JerseyConfig extends ResourceConfig {
    private static final String[] MODULE_PACKAGES = new String[]{
        "com.thoughtworks.gaia.product.endpoint",
    };

    public JerseyConfig() {
        // common packages
        this.packages(
            "com.thoughtworks.gaia.common.exception.handler"
        );

        // module packages
        this.packages(
            MODULE_PACKAGES
        );

        this.registerClasses(
            ApiListingResource.class,
            SwaggerSerializers.class,
            EntityFilteringFeature.class,
            JacksonFeature.class
        );

        initSwaggerBeanConfig();
    }

    protected void initSwaggerBeanConfig() {
        BeanConfig beanConfig = new BeanConfig();
        beanConfig.setVersion("1.0.0");
        beanConfig.setSchemes(new String[]{"http"});
        beanConfig.setHost("localhost:8080");
        beanConfig.setBasePath("/gaia/rest");
        beanConfig.setResourcePackage(Joiner.on(",").join(MODULE_PACKAGES));
        beanConfig.setScan(true);
    }
}
