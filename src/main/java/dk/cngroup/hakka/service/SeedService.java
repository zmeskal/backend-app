package dk.cngroup.hakka.service;

import org.neo4j.ogm.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

@Service
public class SeedService {

    private final Session session;

    @Autowired
    public SeedService(Session session) {
        this.session = session;
    }

    public void seedData() {
        session.purgeDatabase();
        session.query(loadScript(), new HashMap<>());
    }

    private String loadScript() {
        try (Stream<String> lines = Files.lines(Paths.get(new ClassPathResource("data.cql").getURI()))) {
            return lines.collect(joining(" "));
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
}
