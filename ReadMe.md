## spring cloud demo
```text
discoveryService:
    使用Eureka作为注册中心，其他服务均注册到该注册中心
configService：
    使用spring cloud config 作为配置管理中心，默认使用native本地文件系统
zuul:
    统一网关
server:
    提供服务方，数据库使用H2，MQ，Redis等中间件
client:
    服务调用方，使用ribbon做客户端负载均衡
全链路跟踪：使用 zipkin，sleuth zipkin 
        zipkin 部署 docker run -d -p 9411:9411 openzipkin/zipkin

```

### todo
    * 日志中心：使用elk
    * 监控：zabbix
    * 熔断与限流：hystrix
    * 安全：oauth2
    * 数据库分库分表：
    * 部署：docker