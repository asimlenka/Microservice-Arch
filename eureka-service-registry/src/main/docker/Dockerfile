FROM java:8
VOLUME /tmp
ADD service-registry-0.0.1-SNAPSHOT.jar service-registry.jar
RUN bash -c 'touch /service-registry.jar'
EXPOSE 8762
ENTRYPOINT ["nohup","java","-jar","/service-registry.jar","&"]