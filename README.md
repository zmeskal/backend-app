# HakkaStack backend app

### Project set up:

* install Java 8
* clone https://github.com/HakkaStack/backend-app.git
* import to IDEA as a maven project
* install Lombok plugin for IDEA
* install Neo4J locally or use Docker image. Also you could use actual Rancher's Neo4J images
* run Application.java as main method (with -Dspring.profiles.active=dev)
* seed data: POST http://localhost:8080/api/v1/seed (or DELETE to get rid of data) or seed with mvn clean install -PSeedData

