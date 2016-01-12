package dk.cngroup.hakka.config;

import org.neo4j.ogm.session.SessionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.config.Neo4jConfiguration;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.server.Neo4jServer;
import org.springframework.data.neo4j.server.RemoteServer;

@Configuration
@EnableNeo4jRepositories(Neo4jConfig.REPOSITORIES)
public class Neo4jConfig extends Neo4jConfiguration {

    public static final String REPOSITORIES = "dk.cngroup.hakka.repository";
    public static final String ENTITIES = "dk.cngroup.hakka.entity";

    @Value("${neo4j.database.url:'localhost:7474'}")
    private String databaseUrl;
    @Value("${neo4j.database.username:'neo4j'}")
    private String username;
    @Value("${neo4j.database.password:'admin'}")
    private String password;

    @Override
    @Bean
    public Neo4jServer neo4jServer() {
        return new RemoteServer(databaseUrl, username, password);
    }

    @Override
    @Bean
    public SessionFactory getSessionFactory() {
        return new SessionFactory(Neo4jConfig.ENTITIES);
    }

}
