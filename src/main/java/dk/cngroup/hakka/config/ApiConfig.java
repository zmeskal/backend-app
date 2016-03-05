package dk.cngroup.hakka.config;

import dk.cngroup.hakka.controller.routes.ErrorRoutes;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.ErrorPage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

@Configuration
public class ApiConfig {
    @Bean
    public EmbeddedServletContainerCustomizer containerCustomizer() {
        return (container -> {
            ErrorPage error401Page = new ErrorPage(HttpStatus.UNAUTHORIZED, ErrorRoutes.NOT_AUTHORIZED);
            ErrorPage error404Page = new ErrorPage(HttpStatus.NOT_FOUND, ErrorRoutes.NOT_FOUND);
            ErrorPage error500Page = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, ErrorRoutes.INTERNAL_ERROR);

            container.addErrorPages(error401Page, error404Page, error500Page);
        });
    }
}
