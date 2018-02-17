package xcs.cloud.gradle.plugins.tasks

import org.gradle.api.DefaultTask
import org.gradle.api.logging.Logger
import org.gradle.api.logging.Logging
import org.gradle.api.tasks.TaskAction
import xcs.cloud.gradle.plugins.EndpointsPlugin

class CleanEndpointsSourcesDir extends DefaultTask {

    private static final Logger LOG = Logging.getLogger(CleanEndpointsSourcesDir.class)

    static final String DESCRIPTION = "Cleans the Endpoints sources dir."

    CleanEndpointsSourcesDir() {
        this.group = EndpointsPlugin.TASK_GROUP
        this.description = DESCRIPTION
    }

    @SuppressWarnings("GroovyUnusedDeclaration")
    @TaskAction
    cleanSourceFolders() {
        LOG.info("Clean Endpoints source dir")

        project.sourceSets.endpoints.java.srcDirs.each { dir ->
            if (dir.exists()) {
                dir.deleteDir()
            }
        }
    }

}
