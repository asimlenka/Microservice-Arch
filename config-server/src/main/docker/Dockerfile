FROM java:8
VOLUME /tmp
ADD config-server-0.0.1-SNAPSHOT.jar config-server.jar
RUN bash -c 'touch /config-server.jar'
EXPOSE 8889
ENTRYPOINT ["nohup","java","-jar","/config-server.jar","&"]