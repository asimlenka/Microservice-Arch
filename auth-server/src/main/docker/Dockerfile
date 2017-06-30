FROM java:8
VOLUME /tmp
ADD auth-server-0.0.1-SNAPSHOT.jar auth-server.jar
RUN bash -c 'touch /auth-server.jar'
EXPOSE 5000
ENTRYPOINT ["nohup","java","-jar","/auth-server.jar","&"]