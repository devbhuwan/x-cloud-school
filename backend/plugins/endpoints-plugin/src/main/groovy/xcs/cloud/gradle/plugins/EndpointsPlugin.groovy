package xcs.cloud.gradle.plugins

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.logging.Logger
import org.gradle.api.logging.Logging
import org.gradle.api.plugins.JavaPlugin
import xcs.cloud.gradle.plugins.tasks.CleanEndpointsSourcesDir
import xcs.cloud.gradle.plugins.tasks.EndpointsCompile
import xcs.cloud.gradle.plugins.tasks.InitEndpointsSourcesDir

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


        LOG.info("Applying endpoints plugin")

        // apply core 'java' plugin if not present to make 'sourceSets' available
        if (!project.plugins.hasPlugin(JavaPlugin.class)) {
            project.plugins.apply(JavaPlugin.class)
        }

        // add 'Endpoints' DSL extension
        project.extensions.create(EndpointsPluginExtension.NAME, EndpointsPluginExtension)

        // add new tasks for creating/cleaning the auto-value sources dir
        project.task(type: CleanEndpointsSourcesDir, "cleanEndpointsSourcesDir")
        project.task(type: InitEndpointsSourcesDir, "initEndpointsSourcesDir")

        // make 'clean' depend clean ing endpoints sources
        project.tasks.clean.dependsOn project.tasks.cleanEndpointsSourcesDir

        project.task(type: EndpointsCompile, "compileEndpoints")
        project.tasks.compileEndpoints.dependsOn project.tasks.initEndpointsSourcesDir
        project.tasks.compileJava.dependsOn project.tasks.compileEndpoints

        project.afterEvaluate {
            File endpointsSourcesDir = endpointsSourcesDir(project)
            addLibrary(project)
            addSourceSet(project, endpointsSourcesDir)
            registerSourceAtCompileJava(project, endpointsSourcesDir)
            applyCompilerOptions(project)
        }

    }


    private static void applyCompilerOptions(Project project) {
        project.tasks.compileEndpoints.options.compilerArgs += [
                "-proc:only",
                "-processor", project.endpoints.processors()
        ]
    }

    private void registerSourceAtCompileJava(Project project, File endpointsSourcesDir) {
        project.compileJava {
            source endpointsSourcesDir
        }
    }

    private void addLibrary(Project project) {
        def library = project.extensions.endpoints.library
        LOG.info("Endpoints library: {}", library)
        project.dependencies {
            compile library
        }
    }

    private void addSourceSet(Project project, File sourcesDir) {
        LOG.info("Create source set 'endpoints'.")

        project.sourceSets {
            endpoints {
                java.srcDirs = [sourcesDir]
            }
        }
    }

    private static File endpointsSourcesDir(Project project) {
        String path = project.extensions.endpoints.endpointsSourcesDir
        File endpointsSourcesDir = project.file(path)
        LOG.info("Endpoints sources dir: {}", endpointsSourcesDir.absolutePath)
        return endpointsSourcesDir
    }
}
