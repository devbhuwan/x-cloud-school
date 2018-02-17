package x.cloud.school.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import x.cloud.school.security.endpoints.EndpointsCollector;
import x.cloud.school.security.endpoints.EndpointsResourceRegistrar;

import static x.cloud.school.security.CloudSecurityProperties.CLOUD_SECURITY_ENABLE_KEY;
import static x.cloud.school.security.CloudSecurityProperties.CLOUD_SECURITY_ENABLE_VALUE;

@Configuration
@EnableConfigurationProperties(CloudSecurityProperties.class)
@Slf4j
public class CloudSecurityAutoConfiguration {

    @Autowired
    private CloudSecurityProperties cloudSecurityProperties;

    @Bean
    @ConditionalOnProperty(value = CLOUD_SECURITY_ENABLE_KEY, havingValue = CLOUD_SECURITY_ENABLE_VALUE)
    @Autowired
    public EndpointsResourceRegistrar endpointsResourceRegistrar(CloudSecurityProperties cloudSecurityProperties,
                                                                 EndpointsCollector endpointsCollector) {
        return new EndpointsResourceRegistrar(cloudSecurityProperties.getKeycloak(), endpointsCollector);
    }

    @Bean
    @ConditionalOnProperty(value = CLOUD_SECURITY_ENABLE_KEY, havingValue = CLOUD_SECURITY_ENABLE_VALUE)
    public EndpointsCollector endpointsCollector() {
        return new EndpointsCollector();
    }

}
