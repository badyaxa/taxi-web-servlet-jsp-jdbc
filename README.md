# for deploy to Heroku

add
Procfile
    web:    java $JAVA_OPTS -jar target/dependency/webapp-runner.jar --port $PORT target/*.war

add
system.properties
    java.runtime.version=11

add in pom.xml
heroku-maven-plugin