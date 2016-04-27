package dk.cngroup.hakka.repository;

import dk.cngroup.hakka.entity.Customer;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends GraphRepository<Customer> {
}
