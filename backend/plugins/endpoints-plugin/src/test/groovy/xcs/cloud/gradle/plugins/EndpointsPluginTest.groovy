package xcs.cloud.gradle.plugins

import org.gradle.api.Project
import org.gradle.api.plugins.WarPlugin
import org.gradle.testfixtures.ProjectBuilder
import org.testng.annotations.BeforeMethod
import org.testng.annotations.Test

import static org.hamcrest.CoreMatchers.is
import static org.hamcrest.MatcherAssert.assertThat

class EndpointsPluginTest {
    private Project project

    @BeforeMethod
    void setup() {
        project = ProjectBuilder.builder().build()
        project.plugins.apply(EndpointsPlugin.class)
        project.plugins.apply(WarPlugin.class)

        project.extensions.endpoints.webflux = true
    }

    @Test
    void testPluginAppliesItself() {
        assertThat(project.plugins.hasPlugin(EndpointsPlugin.class), is(true))
    }

}