package x.cloud.school.profile;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@DisplayName("Cloud School Profile Service Application")
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = CloudSchoolProfileServiceApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CloudSchoolProfileServiceApplicationTest {

    @Test
    @DisplayName("")
    public void name() {
    }

}