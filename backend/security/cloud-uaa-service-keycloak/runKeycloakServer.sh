#!/usr/bin/env bash
mvn clean install
cd target
java -jar cloud-uaa-service-keycloak-1.0-SNAPSHOT.jar