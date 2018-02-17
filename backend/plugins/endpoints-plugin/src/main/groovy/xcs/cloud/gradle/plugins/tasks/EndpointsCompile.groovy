package xcs.cloud.gradle.plugins.tasks

import org.gradle.api.plugins.WarPlugin
import org.gradle.api.tasks.compile.JavaCompile

class EndpointsCompile extends JavaCompile {

    EndpointsCompile() {
        setSource(project.sourceSets.main.java)

        if (project.plugins.hasPlugin(WarPlugin.class)) {
            project.configurations {
                endpoints.extendsFrom compile, providedRuntime, providedCompile
            }
        } else {
            project.configurations {
                endpoints.extendsFrom compile
            }
        }

        project.afterEvaluate {
            setClasspath(project.configurations.endpoints)
            File file = project.file(project.endpoints.endpointsSourcesDir)
            setDestinationDir(file)
        }
    }
}
