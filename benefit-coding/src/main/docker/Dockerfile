FROM java:8
VOLUME /tmp
ADD benefitcoding-service-0.0.1-SNAPSHOT.jar benefitcoding-service.jar
RUN bash -c 'touch /benefitcoding-service.jar'
EXPOSE 6003
ENTRYPOINT ["nohup","java","-Dserver.port=7003","-jar","/benefitcoding-service.jar","&"]