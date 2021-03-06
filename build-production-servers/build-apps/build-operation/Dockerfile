# Dockerfile for wedding operation service using embedded tomcat server

FROM       docker.io/debugroom/wedding:centos7
MAINTAINER debugroom

RUN yum install -y \
       java-1.8.0-openjdk \
       java-1.8.0-openjdk-devel \
       wget tar iproute

RUN wget http://repos.fedorapeople.org/repos/dchen/apache-maven/epel-apache-maven.repo -O /etc/yum.repos.d/epel-apache-maven.repo
RUN sed -i s/\$releasever/6/g /etc/yum.repos.d/epel-apache-maven.repo
RUN yum install -y apache-maven
ENV JAVA_HOME /etc/alternatives/jre
RUN git clone -b feature/framework-spring https://github.com/debugroom/framework.git /var/local/framework
RUN mvn install -f /var/local/framework/pom.xml

RUN git clone -b develop https://github.com/debugroom/wedding.git /var/local/wedding

ENV DBSERVER_APP_USERNAME=app
ENV DBSERVER_APP_PASSWORD=app
ARG DBSERVER_PORT_5432_TCP_ADDR
ARG DBSERVER_PORT_5432_TCP_PORT
ARG DBSERVER_PORT_9042_TCP_ADDR
ARG DBSERVER_PORT_9042_TCP_PORT
ARG FRONTEND_PORT_8080_TCP_PORT
ARG FRONTEND_PORT_8080_TCP_ADDR
ARG LOGIN_PORT_8080_TCP_PORT
ARG LOGIN_PORT_8080_TCP_ADDR
ENV DBSERVER_PORT_5432_TCP_ADDR ${DBSERVER_PORT_5432_TCP_ADDR:-localhost}
ENV DBSERVER_PORT_5432_TCP_PORT ${DBSERVER_PORT_5432_TCP_PORT:-localhost}
ENV DBSERVER_PORT_9042_TCP_ADDR ${DBSERVER_PORT_9042_TCP_ADDR:-localhost}
ENV DBSERVER_PORT_9042_TCP_PORT ${DBSERVER_PORT_9042_TCP_PORT:-localhost}
ENV FRONTEND_PORT_8080_TCP_ADDR ${LOGIN_PORT_8080_TCP_ADDR:-localhost}
ENV FRONTEND_PORT_8080_TCP_PORT ${LOGIN_PORT_8080_TCP_PORT:-localhost}
ENV LOGIN_PORT_8080_TCP_ADDR ${LOGIN_PORT_8080_TCP_ADDR:-localhost}
ENV LOGIN_PORT_8080_TCP_PORT ${LOGIN_PORT_8080_TCP_PORT:-localhost}}

RUN mvn install -Dmaven.test.skip=true -f /var/local/wedding/wedding-microservice/wedding-infra-cassandra/pom.xml
RUN mvn install -f /var/local/wedding/wedding-microservice/wedding-infra-common/pom.xml
RUN mvn install -f /var/local/wedding/wedding-microservice/wedding-boot-parent/pom.xml
RUN mvn install -f /var/local/wedding/wedding-microservice/wedding-domain-common/pom.xml
RUN mvn install -f /var/local/wedding/wedding-microservice/wedding-web-common/pom.xml
RUN mvn install -f /var/local/wedding/wedding-microservice/wedding-batch-common/pom.xml
RUN mvn install -f /var/local/wedding/wedding-microservice/wedding-operation/pom.xml

EXPOSE 8080

RUN cp /etc/localtime /etc/localtime.org
RUN ln -sf  /usr/share/zoneinfo/Asia/Tokyo /etc/localtime

CMD java -jar -Dspring.profiles.active=production,jpa,cassandra,cluster,operation-cluster /var/local/wedding/wedding-microservice/wedding-operation/wedding-web-operation/target/wedding-web-operation-1.0-SNAPSHOT.jar
