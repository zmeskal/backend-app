package dk.cngroup.hakka.config;

import dk.cngroup.hakka.service.SeedService;
import org.neo4j.ogm.session.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.neo4j.config.Neo4jConfiguration;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.server.Neo4jServer;
import org.springframework.data.neo4j.server.RemoteServer;

@Configuration
@EnableNeo4jRepositories(Neo4jConfig.REPOSITORIES)
public class Neo4jConfig extends Neo4jConfiguration implements CommandLineRunner {

    public static final String REPOSITORIES = "dk.cngroup.hakka.repository";
    public static final String ENTITIES = "dk.cngroup.hakka.entity";

    @Autowired
    private Environment environment;

    @Autowired
    private SeedService seedService;

    @Override
    @Bean
    public Neo4jServer neo4jServer() {
        return new RemoteServer(environment.getProperty("neo4j.database.url"));
    }

    @Override
    @Bean
    public SessionFactory getSessionFactory() {
        return new SessionFactory(Neo4jConfig.ENTITIES);
    }


    @Override
    public void run(String... strings) throws Exception {
        seedService.seedData();
    }
}
