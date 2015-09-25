package dk.cngroup.hakka;

import org.neo4j.ogm.session.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.config.Neo4jConfiguration;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.server.InProcessServer;
import org.springframework.data.neo4j.server.Neo4jServer;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableNeo4jRepositories
@EnableTransactionManagement
@ComponentScan("dk.cngroup.hakka")
public class TestNeo4jContext extends Neo4jConfiguration {

    @Override
    @Bean
    public Neo4jServer neo4jServer() {
        return new InProcessServer();
    }

    @Override
    @Bean
    public SessionFactory getSessionFactory() {
        return new SessionFactory("dk.cngroup.hakka");
    }

}
