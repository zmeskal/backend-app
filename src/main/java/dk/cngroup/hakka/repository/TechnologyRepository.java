package dk.cngroup.hakka.repository;

import dk.cngroup.hakka.entity.Technology;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource(collectionResourceRel = "technologies", path = "technologies")
public interface TechnologyRepository extends GraphRepository<Technology> {
}
