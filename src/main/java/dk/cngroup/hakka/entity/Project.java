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
public class Project {

    @GraphId
    private Long id;

    @Index(unique = true)
    private String name;

    @Relationship(type = "CONSISTS", direction = Relationship.OUTGOING)
    private Set<Project> subProjects = new HashSet<>();
}
