#!/bin/bash

git pull
docker build -t vdubois/primobox-event-driven-architecture:latest .
docker rm -v -f event-driven-architecture | true
docker run -d --name event-driven-architecture -p 8080:8080 -e SPRING_SECURITY_USER_NAME=$SPRING_SECURITY_USER_NAME -e SPRING_SECURITY_USER_PASSWORD=$SPRING_SECURITY_USER_PASSWORD vdubois/primobox-event-driven-architecture:latest
