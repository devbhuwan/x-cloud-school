package x.cloud.school.security;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

@ConfigurationProperties(prefix = "cloud.service.security")
@Validated
@Getter
@Setter
public class CloudServiceSecurityProperties {

    private boolean enable = Boolean.TRUE;
}
