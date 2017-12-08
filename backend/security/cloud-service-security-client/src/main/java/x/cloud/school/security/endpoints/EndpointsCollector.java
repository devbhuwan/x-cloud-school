package x.cloud.school.security.endpoints;

import org.keycloak.representations.idm.authorization.ResourceOwnerRepresentation;
import org.keycloak.representations.idm.authorization.ResourceRepresentation;
import x.cloud.school.security.CloudSecurityProperties;
import x.cloud.school.security.endpoints.dto.EndpointDTO;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class EndpointsCollector {

    public static List<ResourceRepresentation> toResources(List<EndpointDTO> endpoints,
                                                           CloudSecurityProperties.KeycloakProperties keycloakProperties) {
        final ResourceOwnerRepresentation resourceOwnerRepresentation = new ResourceOwnerRepresentation();
        resourceOwnerRepresentation.setName(keycloakProperties.getClientRepresentation().getClientId());
        return endpoints.stream().map(endpointDTO -> {
            ResourceRepresentation resourceRepresentation = new ResourceRepresentation();
            resourceRepresentation.setName(endpointDTO.getName());
            resourceRepresentation.setOwner(resourceOwnerRepresentation);
            resourceRepresentation.setUri(endpointDTO.getUri());
            resourceRepresentation.setType("");
            return resourceRepresentation;
        }).collect(Collectors.toList());
    }

    public List<EndpointDTO> collectEndpoints() {
        return IntStream.range(0, 2)
                .mapToObj(operand -> EndpointDTO.builder()
                        .name("test" + operand)
                        .uri("uri" + operand)
                        .build())
                .collect(Collectors.toList());
    }
}
