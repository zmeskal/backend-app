package dk.cngroup.hakka.entity;

import lombok.Data;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.Index;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.HashSet;
import java.util.Set;

@NodeEntity
@Data
public class Customer {

    @GraphId
    private Long id;

    @Index(unique = true)
    private String name;

    @Relationship(type = "CONTRACTS", direction = Relationship.OUTGOING)
    private Set<Project> projects = new HashSet<>();
}
