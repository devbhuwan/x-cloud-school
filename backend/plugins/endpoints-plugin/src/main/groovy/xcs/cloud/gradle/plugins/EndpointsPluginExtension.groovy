package xcs.cloud.gradle.plugins

class EndpointsPluginExtension {

    static String ENDPOINT_PROC = "x.cloud.archx.endpoints.apt.WebFluxEndpointAnnotationProcessor"

    static final String NAME = "endpoints"
    static final String DEFAULT_ENDPOINTS_SOURCES_DIR = "src/endpoints/java"
    static final String DEFAULT_LIBRARY = "io.github.devbhuwan:endpoints-archx-codegen:1.0-SNAPSHOT"

    String endpointsSourcesDir = DEFAULT_ENDPOINTS_SOURCES_DIR
    String library = DEFAULT_LIBRARY

    boolean webflux = false

    String processors() {

        List processors = []

        if (webflux) {
            processors << ENDPOINT_PROC
        }

        return processors.join(",")
    }
}
