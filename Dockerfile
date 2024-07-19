FROM openjdk:17-slim

#RUN apt-get update && \
#    apt-get install -y maven && \
#    rm -rf /var/lib/apt/list/*
#
#ENV MAVEN_HOME /usr/share/maven
#ENV PATH $MAVEN_HOME/bin:$PATH 

WORKDIR /app

#COPY pom.xml .

#RUN mvn dependency:go-offline

#COPY src ./src

#RUN mvn clean install

#WORKDIR /app/target

COPY target/app-invoice-0.0.1-SNAPSHOT.jar /app/app-invoice-0.0.1-SNAPSHOT.jar 

EXPOSE 8080

ENTRYPOINT [ "java","-jar","/app/app-invoice-0.0.1-SNAPSHOT.jar"]


