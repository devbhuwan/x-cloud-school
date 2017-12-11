package x.cloud.school.profile.features;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "x.cloud.school.profile.glue"
)
public class CloudSchoolProfileFeaturesTest extends AbstractFeaturesTest {

}