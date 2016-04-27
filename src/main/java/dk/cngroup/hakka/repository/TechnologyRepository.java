package dk.cngroup.hakka.repository;

import dk.cngroup.hakka.entity.Technology;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TechnologyRepository extends GraphRepository<Technology> {
}
