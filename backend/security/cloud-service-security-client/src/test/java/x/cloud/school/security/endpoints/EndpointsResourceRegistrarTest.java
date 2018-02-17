package x.cloud.school.security.endpoints;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import x.cloud.school.security.CloudSecurityApplication;


@DisplayName("Cloud School Profile Service Application")
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = CloudSecurityApplication.class)
public class EndpointsResourceRegistrarTest {

    @Autowired
    private EndpointsResourceRegistrar endpointsResourceRegistrar;

    @Test
    public void givenPolicyRepresentation_whenPost_thenRegisterPolicy() {
        endpointsResourceRegistrar.register();
    }

}