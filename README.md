# microservices_architecture
# sequence for starting microservices -
1.service registry

2.cloud-config #u can set own git url address to fetch eureka configuration in application.yml file 

3.department-service

4.user-service

5.ribbon-server.jar 3 times using cmd in different port 
eg.one by one paste in 3 cmd

java -jar -Dserver.port=9090 C:\Users\Percy\Downloads\project\ribbon-server\ribbon-server\target\ribbon-server-0.0.1-SNAPSHOT.jar
java -jar -Dserver.port=9091 C:\Users\Percy\Downloads\project\ribbon-server\ribbon-server\target\ribbon-server-0.0.1-SNAPSHOT.jar
java -jar -Dserver.port=9092 C:\Users\Percy\Downloads\project\ribbon-server\ribbon-server\target\ribbon-server-0.0.1-SNAPSHOT.jar

6.start zipkin server using zipkin.jar file via cmd
eg.java -jar zipkin.jar

7.then at last start api-gateway
