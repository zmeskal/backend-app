package dk.cngroup.hakka.repository;

import dk.cngroup.hakka.entity.Customer;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource(collectionResourceRel = "customers", path = "customers")
public interface CustomerRepository extends GraphRepository<Customer> {
}