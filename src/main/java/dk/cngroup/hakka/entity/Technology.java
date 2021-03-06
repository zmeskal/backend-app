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
public class Technology {

    @GraphId
    private Long id;

    @Index(unique = true)
    private String name;

    @Relationship(type = "IS_A", direction = Relationship.OUTGOING)
    private Set<Technology> partsOf = new HashSet<>();

    @Relationship(type = "RELATES", direction = Relationship.OUTGOING)
    private Set<Technology> includes = new HashSet<>();

    @Relationship(type = "HAS_A", direction = Relationship.INCOMING)
    private Set<Assignment> assignments = new HashSet<>();
}
