# micro-memories  --Memories项目的分布式实践
### 1.	设计概述
搭建基本的SpringCloud微服务架构，每个微服务应用使用SpringBoot创建，使用Eureka作为服务的注册中心，使用SpringConfig搭建配置中心，将每个微服务的配置交给配置中心，并上管到GitHub上。设计了memory服务和user服务作为两个微服务的提供者，利用Zuul设置了统一的网关来访问每一个微服务，但实际并没有利用到此网关，因为在最初的设计中每个微服务其实只提供了对数据的CRUD操作，返回值是JSON格式的数据，并没有进行页面的数据装载和渲染，所以在此设计了一个memories-consumer应用作为这个系统应用的统一入口，提供了统一的访问接口，consumer应用通过从注册中心中拉取服务列表，并通过Feign技术对HTTP的请求进行了封装，暴露了统一的接口，在每个具体的请求中，以接口的形式进行远程调用每一个具体的微服务，Feign默认封装了Ribbon进行负载均衡，在此额外使用了Hystrix来做服务的熔断和降级处理，并设置了Hystrix-Dashboard来监控每个微服务的健康状态，最后将调用的结果使用Thymleaf来装载数据解析页面，将最终的页面显示给用户。
### 2.	系统架构
![memories的系统架构图](https://github.com/zzh5233/pictures/blob/master/memories-%E7%B3%BB%E7%BB%9F%E6%9E%B6%E6%9E%84.png)
### 3.	Memory微服务架构
![memories中单个微服务的结构图](https://github.com/zzh5233/pictures/blob/master/ssm%E7%BB%93%E6%9E%84.png)
### 4.运行结果展示 
![memories运行结果图](https://github.com/zzh5233/pictures/blob/master/memories-consumer.png)
![memories运行结果图](https://github.com/zzh5233/pictures/blob/master/Memories%E8%BF%90%E8%A1%8C%E7%BB%93%E6%9E%9C%E5%9B%BE.png)
### 5.总结 
Memories整个应用迄今实现的功能不多，只是基本实现了最初的设想，即可以分享信息，获取信息，不过借此应用着重学习了微服务架构的搭建和使用，在系统的搭建过程中遇到过很多疑惑，但是在解决每一个问题的时候都为自己带来了全新的认识，无论是对微服务系统的理解，还是对功能的划分，每一项新技术的引用，以及其为了解决的问题，都较之前有了更加深刻的认识和理解。
当然至此Memories还是个很小的应用，其实现的具体功能很有限，若仅仅如此完全没有必要引入微服务的架构，如我们所知，微服务架构设计往往是为了处理具有极高的访问量，并发量，具有大量的计算和庞大的数据的应用的。但是秉着学习的宗旨，这样一个很小的应用却能很好的学习和理解微服务架构，做到一个基本的入门，在这个意义上来说收获还是很大的。
