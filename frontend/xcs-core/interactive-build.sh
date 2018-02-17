#!/usr/bin/env bash
# Bash Menu Script Example

PS3='Please enter your choice: '
options=("Normal Build" "Normal build and publish" "Run App" "Quit")
select opt in "${options[@]}"
do
    case $opt in
        "Normal Build")
            echo "you chose 'Normal Build'"
            npm run build
            ;;
        "Normal build and publish")
            echo "you chose 'Normal build and publish'"
            printf 'New Version [] : '
            read newVersion
            sed -i -E "s/\"version\":.*[^,]/\"version\":\"${newVersion}\"/g" package.json
            npm run build && cd dist/ && yarn publish
            ;;
        "Run App")
            echo "you chose 'Run App'"
            npm run start
            ;;
        "Quit")
            break
            ;;
        *) echo invalid option;;
    esac
done
