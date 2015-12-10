package dk.cngroup.hakka.repository;

import dk.cngroup.hakka.entity.Developer;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "developers", path = "developers")
public interface DeveloperRepository extends GraphRepository<Developer> {
}
