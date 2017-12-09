package x.cloud.school.security.endpoints;

import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.keycloak.admin.client.resource.AuthorizationResource;
import org.keycloak.admin.client.resource.ClientsResource;
import org.keycloak.representations.idm.ClientRepresentation;
import org.keycloak.representations.idm.authorization.ResourceRepresentation;
import org.keycloak.representations.idm.authorization.ResourceServerRepresentation;
import x.cloud.school.security.CloudSecurityProperties;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static x.cloud.school.security.endpoints.EndpointsCollector.toResources;

public class EndpointsResourceRegistrar {

    private final CloudSecurityProperties.KeycloakProperties keycloakProperties;
    private final EndpointsCollector endpointsCollector;

    public EndpointsResourceRegistrar(CloudSecurityProperties.KeycloakProperties keycloak, EndpointsCollector endpointsCollector) {
        this.keycloakProperties = keycloak;
        this.endpointsCollector = endpointsCollector;
    }

    public void register() {
        Keycloak keycloak = KeycloakBuilder.builder()
                .serverUrl(keycloakProperties.getServer().getServerUrl())
                .username(keycloakProperties.getServer().getUsername())
                .password(keycloakProperties.getServer().getPassword())
                .realm(keycloakProperties.getServer().getRealm())
                .grantType(keycloakProperties.getServer().getGrantType())
                .clientId(keycloakProperties.getServer().getClientId())
                //.clientSecret(keycloakProperties.getClientSecret())
                .build();

        List<ClientRepresentation> clientRepresentations = clientsResource(keycloak).findByClientId(client().getClientId());
        if (clientRepresentations.isEmpty()) {
            ClientRepresentation clientRepresentation = client();
            ResourceServerRepresentation authorizationSettings = notNullAuthorizationSettings(Collections.singletonList(clientRepresentation));
            addEndpointAuthorizations(authorizationSettings);
            clientRepresentation.setAuthorizationSettings(authorizationSettings);
            clientsResource(keycloak).create(clientRepresentation);
        } else {
            ResourceServerRepresentation authorizationSettings = notNullAuthorizationSettings(clientRepresentations);
            addEndpointAuthorizations(authorizationSettings);
            authorizationResource(keycloak).update(authorizationSettings);
        }
    }

    private void addEndpointAuthorizations(ResourceServerRepresentation authorizationSettings) {
        List<ResourceRepresentation> resourceRepresentations = toNotNullList(authorizationSettings.getResources());
        resourceRepresentations.addAll(toResources(endpointsCollector.collectEndpoints(), keycloakProperties));
        authorizationSettings.setResources(resourceRepresentations);
    }

    private <T> List<T> toNotNullList(List<T> list) {
        return list == null || list.isEmpty() ? new ArrayList<>() : list;
    }

    private ResourceServerRepresentation notNullAuthorizationSettings(List<ClientRepresentation> clientRepresentations) {
        ResourceServerRepresentation authorizationSettings = first(clientRepresentations).getAuthorizationSettings();
        return authorizationSettings == null ? buildDefaultResourceServerRepresentation() : authorizationSettings;
    }

    private ResourceServerRepresentation buildDefaultResourceServerRepresentation() {
        ResourceServerRepresentation resourceServerRepresentation = new ResourceServerRepresentation();
        resourceServerRepresentation.setAllowRemoteResourceManagement(true);
        resourceServerRepresentation.setName(keycloakProperties.getClientRepresentation().getAuthorizationSettings().getName());
        resourceServerRepresentation.setClientId(keycloakProperties.getClientRepresentation().getClientId());
        return resourceServerRepresentation;
    }

    private ClientRepresentation first(List<ClientRepresentation> clientRepresentations) {
        return clientRepresentations.stream().findFirst().orElse(client());
    }

    private ClientRepresentation client() {
        return keycloakProperties.getClientRepresentation();
    }

    private ClientsResource clientsResource(Keycloak keycloak) {
        return keycloak.realm(keycloakProperties.getServer().getRealm()).clients();
    }

    private AuthorizationResource authorizationResource(Keycloak keycloak) {
        return clientsResource(keycloak).get(client().getClientId()).authorization();
    }

}
