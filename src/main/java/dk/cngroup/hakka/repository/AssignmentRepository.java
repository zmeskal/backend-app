package dk.cngroup.hakka.repository;

import dk.cngroup.hakka.entity.Assignment;
import dk.cngroup.hakka.entity.Person;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "assignments", path = "assignments")
public interface AssignmentRepository extends GraphRepository<Assignment> {
}
