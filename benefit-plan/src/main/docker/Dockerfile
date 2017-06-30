FROM java:8
VOLUME /tmp
ADD benefit-plan-0.0.1-SNAPSHOT.jar benefit-plan.jar
RUN bash -c 'touch /benefit-plan.jar'
EXPOSE 7003
ENTRYPOINT ["nohup","java","-Dserver.port=7003","-jar","/benefitcoding-service.jar","&"]