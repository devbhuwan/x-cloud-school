package xcs.cloud.gradle.plugins

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.logging.Logger
import org.gradle.api.logging.Logging

class EndpointsPlugin implements Plugin<Project> {

    public static final String TASK_GROUP = "Endpoints"

    private static final Logger LOG = Logging.getLogger(EndpointsPlugin.class)

    @Override
    void apply(Project project) {
        LOG.info("Applying Endpoints plugin")

        // do nothing if plugin is already applied
        if (project.plugins.hasPlugin(EndpointsPlugin.class)) {
            return
        }
    }
}
