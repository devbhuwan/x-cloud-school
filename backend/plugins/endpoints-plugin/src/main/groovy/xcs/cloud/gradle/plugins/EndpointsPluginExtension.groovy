package xcs.cloud.gradle.plugins

class EndpointsPluginExtension {

    static String HIBERNATE_PROC = "hibernate.HibernateAnnotationProcessor"

    static final String NAME = "endpoints"
    static final String DEFAULT_ENDPOINTS_SOURCES_DIR = "src/endpoints/java"
    static final String DEFAULT_LIBRARY = "com.:-apt:4.1.3"

    String endpointsSourcesDir = DEFAULT_ENDPOINTS_SOURCES_DIR
    String library = DEFAULT_LIBRARY

    boolean webflux = false

    String processors() {

        List processors = []

        if (webflux) {
            processors << HIBERNATE_PROC
        }

        return processors.join(",")
    }
}
