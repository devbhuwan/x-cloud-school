#!/usr/bin/env bash
# Bash Menu Script Example

PS3='Please enter your choice: '
options=("Normal Build" "Normal Build with skip tests" "Build with docker images" "Quit")
select opt in "${options[@]}"
do
    case $opt in
        "Normal Build")
            echo "you chose 'Normal Build'"
            gradle clean build
            ;;
        "Normal Build with skip tests")
            echo "you chose 'Normal Build with skip tests'"
            gradle clean build -x test
            ;;
        "Build with docker images")
            echo "you chose 'Build with docker images'"
            gradle clean build copyDockerfile docker
            ;;
        "Quit")
            break
            ;;
        *) echo invalid option;;
    esac
done