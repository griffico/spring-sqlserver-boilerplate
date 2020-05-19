# spring-sqlserver-boilerplate
A Spring Boot App that connects to a local SQL server docker image

# Setup
1. Install [Docker](https://www.docker.com/products/docker-desktop) if you don't have it already 
2. `cd` into the repository and use the command `docker-compose up`. This will start the docker image, complete with SQL Server.
3. Run integration tests from the `integrationTest` directory (Presently the CLI does not appear to work. Will be improving this)
4. Run tests from `test` directory
5. Start the application locally by using `./gradlew build`
