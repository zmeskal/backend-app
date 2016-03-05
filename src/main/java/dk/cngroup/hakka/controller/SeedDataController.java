package dk.cngroup.hakka.controller;

import dk.cngroup.hakka.controller.routes.Routes;
import org.liquigraph.core.api.Liquigraph;
import org.liquigraph.core.configuration.Configuration;
import org.liquigraph.core.configuration.ConfigurationBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.function.Consumer;
import java.util.function.Function;

@RestController
@ConditionalOnExpression("${seed.enabled:false}")
@RequestMapping(value = Routes.SEED, produces = MediaType.APPLICATION_JSON_VALUE)
public class SeedDataController {

    @Value("${neo4j.database.jdbc:'localhost:7474'}")
    private String databaseUrl;
    @Value("${neo4j.database.username:'neo4j'}")
    private String username;
    @Value("${neo4j.database.password:'admin'}")
    private String password;

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void seedData() {
        createConfiguration.andThen(runMigration).apply("seed-data.xml");
    }

    @RequestMapping(method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteAllData() {
        createConfiguration.andThen(runMigration).apply("clear-data.xml");
    }

    private Function<Configuration, Void> runMigration = (Configuration configuration) -> {
        Liquigraph liquigraph = new Liquigraph();
        liquigraph.runMigrations(configuration);
        return null;
    };

    private Function<String, Configuration> createConfiguration = (String from) -> new ConfigurationBuilder()
            .withMasterChangelogLocation(from)
            .withUri(databaseUrl)
            .withUsername(username)
            .withPassword(password)
            .withRunMode()
            .build();
}
