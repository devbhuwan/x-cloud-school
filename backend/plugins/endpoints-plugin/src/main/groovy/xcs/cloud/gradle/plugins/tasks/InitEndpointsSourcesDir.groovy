package xcs.cloud.gradle.plugins.tasks

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction
import xcs.cloud.gradle.plugins.EndpointsPlugin

class InitEndpointsSourcesDir extends DefaultTask {

    static final String DESCRIPTION = "Creates the Endpoints sources dir."

    InitEndpointsSourcesDir() {
        this.group = EndpointsPlugin.TASK_GROUP
        this.description = DESCRIPTION
    }

    @SuppressWarnings("GroovyUnusedDeclaration")
    @TaskAction
    createSourceFolders() {
        project.file(project.endpoints.endpointsSourcesDir).mkdirs()
    }
}
