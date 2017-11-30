package x.cloud.school.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(CloudServiceSecurityProperties.class)
@Slf4j
public class CloudServiceSecurityAutoConfiguration {

}
