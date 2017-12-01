package x.cloud.school.profile;


import org.keycloak.adapters.springboot.KeycloakAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration(exclude = KeycloakAutoConfiguration.class)
public class CloudSchoolProfileServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudSchoolProfileServiceApplication.class, args);
    }

}
