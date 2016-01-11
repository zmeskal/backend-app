package dk.cngroup.hakka.repository;

import dk.cngroup.hakka.entity.Project;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource(collectionResourceRel = "projects", path = "projects")
public interface ProjectRepository extends GraphRepository<Project> {
}
