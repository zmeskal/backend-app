package dk.cngroup.hakka.entity;

import lombok.Data;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.Index;
import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity
@Data
public class Customer {

    @GraphId
    private Long id;

    @Index(unique = true)
    private String name;
}
