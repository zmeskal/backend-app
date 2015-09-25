# HakkaStack backend app

### Neo4j set up:

1) Neo4j Spring Data need latest spring-data-common
2) Install Neo4j to your environment and set up url in application.yml ( localhost:7474 by default )
Use data.script from Martin to seed database, just put it in resources
3) set dbms.security.auth_enabled=false in neo4j-server.properties file ( or pass credentials to 3 params constructor of `Neo4jServer` )
4) `neo4j start` - to start neo4j server
5) run application