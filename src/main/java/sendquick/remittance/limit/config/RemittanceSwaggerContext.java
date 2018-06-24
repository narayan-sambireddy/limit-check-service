package sendquick.remittance.limit.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author narayana
 */
@Configuration
@EnableSwagger2
public class RemittanceSwaggerContext {

    @Value("${API_TITLE}")
    private String API_TITLE;
    @Value("${API_DESCRIPTION}")
    private String API_DESCRIPTION;
    @Value("${API_VERSION}")
    private String API_VERSION;
    @Value("${API_BASEPACKAGE}")
    private String API_BASEPACKAGE;
    @Value("${API_CONTACT_NAME}")
    private String API_CONTACT_NAME;
    @Value("${API_CONTACT_URL}")
    private String API_CONTACT_URL;
    @Value("${API_CONTACT_EMAIL}")
    private String API_CONTACT_EMAIL;


    @Bean
    public Docket swaggerApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title(API_TITLE)
                .version(API_VERSION)
                .description(API_DESCRIPTION)
                .contact(new Contact(API_CONTACT_NAME, API_CONTACT_URL, API_CONTACT_EMAIL))
                .build();
    }
}
