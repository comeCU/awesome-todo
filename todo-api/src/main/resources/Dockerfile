#jar包的Dockerfile
FROM java:8
#镜像创建者
MAINTAINER comeCU

#对外暴露的端口
EXPOSE 8081

ADD todo-api.jar todo-api.jar
#容器对应参数
CMD java -jar todo-api.jar