package com.tw; /**
 * Created by aisiA on 2019/3/15.
 */
import com.spring4all.swagger.EnableSwagger2Doc;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
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

@MapperScan("com.tw.mapper")
@EnableSwagger2Doc
@EnableZuulProxy
@SpringCloudApplication
public class GoodsApiApplication {
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }



    public static void main(String[] args) {
        SpringApplication.run(GoodsApiApplication.class, args);
    }
    //	@Bean
//	public AccessFilter accessFilter() {
//		return new AccessFilter();
//	}


//    @Component
//    @Primary
//    class DocumentationConfig implements SwaggerResourcesProvider {
//        @Override
//        public List<SwaggerResource> get() {
//            List resources = new ArrayList<>();
//            resources.add(swaggerResource("商品", "/goods-api/v2/api-docs", "2.0"));
//            return resources;
//        }
//        private SwaggerResource swaggerResource(String name, String location, String version) {
//            SwaggerResource swaggerResource = new SwaggerResource();
//            swaggerResource.setName(name);
//            swaggerResource.setLocation(location);
//            swaggerResource.setSwaggerVersion(version);
//            return swaggerResource;
//        }
//    }
}
