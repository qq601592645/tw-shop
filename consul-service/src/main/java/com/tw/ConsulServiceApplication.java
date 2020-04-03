package com.tw; /**
 * Created by aisiA on 2019/3/15.
 */
import com.spring4all.swagger.EnableSwagger2Doc;
import com.tw.filter.AccessFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

import java.util.ArrayList;
import java.util.List;


@EnableSwagger2Doc
@EnableZuulProxy
@SpringCloudApplication
public class ConsulServiceApplication {
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(ConsulServiceApplication.class, args);
    }
//    @Bean
//	public AccessFilter accessFilter() {
//		return new AccessFilter();
//	}


    @Component
    @Primary
    class DocumentationConfig implements SwaggerResourcesProvider {
        @Override
        public List<SwaggerResource> get() {
            List resources = new ArrayList<>();
            resources.add(swaggerResource("商品", "/goods-api/v2/api-docs", "2.0"));
            resources.add(swaggerResource("用户", "/crm-api/v2/api-docs", "2.0"));
            resources.add(swaggerResource("订单", "/order-api/v2/api-docs", "2.0"));
            return resources;
        }

        private SwaggerResource swaggerResource(String name, String location, String version) {
            SwaggerResource swaggerResource = new SwaggerResource();
            swaggerResource.setName(name);
            swaggerResource.setLocation(location);
            swaggerResource.setSwaggerVersion(version);
            return swaggerResource;
        }
    }
}
