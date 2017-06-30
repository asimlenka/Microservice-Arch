FROM java:8
VOLUME /tmp
ADD hystrix-monitoring-0.0.1-SNAPSHOT.jar hystrix-monitoring.jar
RUN bash -c 'touch /hystrix-monitoring.jar'
EXPOSE 8990
ENTRYPOINT ["nohup","java","-jar","/hystrix-monitoring.jar","&"]