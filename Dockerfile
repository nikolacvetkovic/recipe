FROM centos

RUN yum install -y java

VOLUME /tmp
ADD /target/recipe-0.0.1-SNAPSHOT.jar recipe.jar
RUN sh -c 'touch /myapp.jar'
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/recipe.jar"]