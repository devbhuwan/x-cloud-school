package x.cloud.school.security;

import lombok.Getter;
import lombok.Setter;
import org.keycloak.OAuth2Constants;
import org.keycloak.representations.idm.ClientRepresentation;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import java.util.Collections;
import java.util.List;

import static x.cloud.school.security.CloudSecurityProperties.CLOUD_SECURITY_PREFIX;

@ConfigurationProperties(prefix = CLOUD_SECURITY_PREFIX)
@Validated
@Getter
@Setter
public class CloudSecurityProperties {

    public static final String CLOUD_SECURITY_PREFIX = "cloud.service.security";
    public static final String CLOUD_SECURITY_ENABLE_KEY = CLOUD_SECURITY_PREFIX + ".enable";
    public static final String CLOUD_SECURITY_ENABLE_VALUE = "true";
    private boolean enable = true;
    private KeycloakProperties keycloak;

    @Getter
    @Setter
    public static class KeycloakProperties {
        private KeycloakServerProperties server;
        private ClientRepresentation clientRepresentation;
    }

    @Getter
    @Setter
    public static class KeycloakServerProperties {
        private String serverUrl = "http://localhost:8080/auth";
        private String realm;
        private String grantType = OAuth2Constants.CLIENT_CREDENTIALS;
        private String clientId;
        private String clientSecret;
        private String username;
        private String password;

    }
}
