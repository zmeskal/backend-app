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
        Configuration configuration = new ConfigurationBuilder()
                .withMasterChangelogLocation("seed-data.xml")
                .withUri(databaseUrl)
                .withUsername(username)
                .withPassword(password)
                .withRunMode()
                .build();

        Liquigraph liquigraph = new Liquigraph();
        liquigraph.runMigrations(configuration);
    }

    @RequestMapping(method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteAllData() {
        Configuration configuration = new ConfigurationBuilder()
                .withMasterChangelogLocation("clear-data.xml")
                .withUri(databaseUrl)
                .withUsername(username)
                .withPassword(password)
                .withRunMode()
                .build();

        Liquigraph liquigraph = new Liquigraph();
        liquigraph.runMigrations(configuration);
    }
}
