FROM openjdk:8
VOLUME /tmp/target
ADD target/swagger-spring.jar swagger-spring.jar
RUN ls
EXPOSE 8080
RUN chmod 7777 swagger-spring.jar
ENTRYPOINT ["java","-cp",".","io.swagger.BootServer"]