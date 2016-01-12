package dk.cngroup.hakka;

import dk.cngroup.hakka.controller.routes.ErrorRoutes;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.ErrorPage;
import org.springframework.context.annotation.Bean;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.http.HttpStatus;

@SpringBootApplication
@EnableNeo4jRepositories
public class Application {

    @Bean
    public EmbeddedServletContainerCustomizer containerCustomizer() {

        return (container -> {
            ErrorPage error401Page = new ErrorPage(HttpStatus.UNAUTHORIZED, ErrorRoutes.NOT_AUTHORIZED);
            ErrorPage error404Page = new ErrorPage(HttpStatus.NOT_FOUND, ErrorRoutes.NOT_FOUND);
            ErrorPage error500Page = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, ErrorRoutes.INTERNAL_ERROR);

            container.addErrorPages(error401Page, error404Page, error500Page);
        });
    }


    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

    }
}