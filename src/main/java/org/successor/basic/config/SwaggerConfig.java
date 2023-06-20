package org.successor.basic.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@WebAppConfiguration
@EnableSwagger2
@EnableWebMvc
@ComponentScan(basePackages="org.successor.controller")
public class SwaggerConfig {

        @Bean
        public Docket defaultApi() {
            return new Docket(DocumentationType.SWAGGER_2)
                    .apiInfo(groupApiInfo())
                    .groupName("新华书店")
                    .select()
                    .apis(RequestHandlerSelectors.basePackage("org.successor.controller"))
                    .paths(PathSelectors.any())
                    .build();
        }


        private ApiInfo groupApiInfo(){
            return new ApiInfoBuilder()
                    .title("swagger-bootstrap-ui很棒~~~！！！")
                    .description("swagger-bootstrap-ui RESTful APIs")
                    .termsOfServiceUrl("http://www.group.com/")
                    .version("1.0")
                    .build();
        }

}
