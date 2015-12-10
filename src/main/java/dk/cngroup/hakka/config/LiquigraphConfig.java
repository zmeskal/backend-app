package dk.cngroup.hakka.config;

import org.liquigraph.core.api.Liquigraph;
import org.liquigraph.core.configuration.Configuration;
import org.liquigraph.core.configuration.ConfigurationBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.net.MalformedURLException;
import java.net.URL;

@Component
public class LiquigraphConfig implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    Environment environment;

    @Value("${neo4j.database.url:'localhost:7474'}")
    String databaseUrl;

    @Override
    public void onApplicationEvent(final ContextRefreshedEvent event) {
        try {
            String[] activeProfiles = environment.getActiveProfiles();
            if (activeProfiles.length == 0) {
                activeProfiles = new String[]{"no_profile_set"}; // To prevent Liquigraph from running all changes regardless their context. Which it unfortunately does if you specify empty execution context.
            }
            ConfigurationBuilder configurationBuilder = new ConfigurationBuilder()
                    .withMasterChangelogLocation("changelog.xml")
                    .withExecutionContexts(activeProfiles)
                    .withRunMode();

            URL e = new URL(databaseUrl);
            String uri = "jdbc:neo4j://" + e.getHost() + ":" + e.getPort();
            String userInfo = e.getUserInfo();
            if (userInfo != null) {
                String username = userInfo.split(":")[0];
                String password = userInfo.split(":")[1];
                uri = uri + "?user=" + username + ",password=" + password;
                //TODO use the following instead after liquigraph authentication is fixed. See https://github.com/fbiville/liquigraph/commit/919d54116c937386914affa58f7b9aca0e888ba2
                //configurationBuilder = configurationBuilder.withUsername(username);
                //configurationBuilder = configurationBuilder.withPassword(password);
            }
            configurationBuilder = configurationBuilder.withUri(uri);
            Configuration configuration = configurationBuilder.build();
            Liquigraph liquigraph = new Liquigraph();
            liquigraph.runMigrations(configuration);
        } catch (MalformedURLException e) {
            throw new IllegalArgumentException("Invalid URL " + databaseUrl, e);
        }
    }

}
