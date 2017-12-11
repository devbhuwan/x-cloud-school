package x.cloud.school.profile.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;
import x.cloud.archx.endpoints.CloudEndpoint;

import java.util.UUID;

@CloudEndpoint
@Table("schools")
@Setter
@Getter
public class School {

    @PrimaryKey("id")
    private UUID id;
    private String name;

}
