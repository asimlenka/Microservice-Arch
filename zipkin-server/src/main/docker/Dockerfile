FROM java:8
VOLUME /tmp
ADD zipkin-server-0.0.1-SNAPSHOT.jar zipkin-server.jar
RUN bash -c 'touch /zipkin-server.jar'
EXPOSE 3333
ENTRYPOINT ["nohup","java","-jar","/zipkin-server.jar","&"]