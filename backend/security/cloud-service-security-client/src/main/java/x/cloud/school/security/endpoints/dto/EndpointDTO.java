package x.cloud.school.security.endpoints.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class EndpointDTO {

    private String name;
    private String uri;
}
