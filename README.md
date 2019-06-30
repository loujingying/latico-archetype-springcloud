一、springcloud是以注册中心为核心，想连接springcloud的注册中心就是使用注册中心客户端，其余的各个组件都是按需使用
======================================================================
======================================================================
二、项目模块的命名规则
    如果是以server-开头，那么就是springcloud的服务器端，跟业务无关，比如注册中心、配置中心等
    如果是以service-开头，那么就是业务服务提供者或者服务调用者，比如：rest接口服务提供者，rest接口服务调用者，配置服务调用者；
======================================================================
======================================================================
三、springcloud的角色分类（角色只是作用，一个项目模块可以使用所有角色）：
1、注册中心：所有服务提供者的接口都可以把接口挂靠在这里，支持集群的高可用，当有客户端连接进来，注册中心会根据服务名称提供所有的接口，客户端根据服务名称加接口名称去拿所有的接口，然后可以根据负载均衡选择其中一个服务提供者去连接；
    实现组件：
    可以使用包括：Eureka、Consul、zookeeper组件实现，目前建议Eureka,
    如果是zookeeper方式，网上下载zookeeper程序启动即可。

2、服务提供者：注册接口到注册中心，让服务消费者使用，也可以不注册到注册中心（如果这样就失去了springcloud的核心意义）；
    实现组件：
        1、eureka；
        2、zookeeper；

3、服务调用者：从注册中心那里调用接口，也可以直接从服务提供者那里调用接口（如果这样就失去了springcloud的核心意义）；
    实现组件：
        1、eureka；
        2、zookeeper；

4、配置中心：存放和管理配置文件，目前支持：本地存储、git、svn，三种存放文件读取方式，注册到注册中心，也可以不注册到注册中心（如果这样就失去了springcloud的核心意义）；
    实现组件：
    Spring Cloud 配置中心的主流实现方式
    1、Spring cloud config
    2、Spring cloud zookeeper config
   
    以下是这两者的简介
    Srping Cloud Config
    Spring cloud config就是和git（svn）集成来实现配置中心。Spring cloud config分服务端、客户端和git(svn)三部分，服务端负责将Git（SVN）中存储的配置文件发布成REST接口，客户端可以从服务端REST接口获取配置（但客户端并不能主动感知到配置的变化，从而主动去获取新的配置，这需要每个客户端通过POST方法触发各自的/refresh）。其中通过git本身的属性可以达到配置版本控制的目的。有缓存形式，先把config下载到服务端本地再提供给客户端，提高可靠性。
    Srping Cloud Zookeeper Config
    该项目通过自动配置并绑定到Spring环境，为Spring Boot应用程序提供Zookeeper集成。Zookeeper提供了一个分层命名空间，允许客户端存储任意数据，如配置数据。Spring Cloud Zookeeper Config是Config Server和Client的替代方案。
   
    两者的比较 
    Spring Cloud Config 通过文件系统，git/svn仓库来管理配置文件。包含客户端、服务端和git/svn仓库。通过git/svn特性可以达到版本控制
    
5、配置调用者：根据配置服务名称和指定要获取的配置文件，连接到注册中心拿配置文件，就跟拿本地配置文件一样，也可以连接配置中心拿（如果这样就失去了springcloud的核心意义）；
    实现组件：
        1、eureka；
        2、zookeeper；
6、API网关：API统一入口
    作用，使用注册中心管理的服务接口，调用的时候，需要传递服务名称，正常是需要使用注册中心的客户端工具，
    但是大部分外部项目，并不是springboot项目，也不想集成注册中心客户端工具，所以需要一个API网关进行代理转发，
    这样的话，调用者并不关心调用时是怎么样连接注册中心里面的服务接口，这样变得跟连接普通的HTTP接口一样的效果，就像使用springmvc提供的rest接口。
    
    实现组件：
    springcloud 1.0一般使用zuul，而2.0版本以上，建议使用Spring Cloud Gateway；

7、反向代理nginx，由于springcloud后台程序都是内网程序，包括API网关，这里我们可以使用nginx代理访问API网关，外界公网通过访问nginx来访问接口，同时，nginx也支持负载均衡等高级配置功能；
======================================================================
======================================================================
四、各组件配置使用运行流程：
    1、请求统一通过API网关（Zuul）来访问内部服务.
    2、网关接收到请求后，从注册中心（Eureka）获取可用服务
    3、由Ribbon进行均衡负载后，分发到后端具体实例
    4、微服务之间通过Feign进行通信处理业务
    5、Hystrix负责处理服务超时熔断
    6、Turbine监控服务间的调用和熔断相关指标
======================================================================
======================================================================
Spring Cloud共集成了19个子项目，里面都包含一个或者多个第三方的组件或者框架！

Spring Cloud 工具框架

1、Spring Cloud Config 配置中心，利用git集中管理程序的配置。
2、Spring Cloud Netflix 集成众多Netflix的开源软件
3、Spring Cloud Bus 消息总线，利用分布式消息将服务和服务实例连接在一起，用于在一个集群中传播状态的变化
4、Spring Cloud for Cloud Foundry 利用Pivotal Cloudfoundry集成你的应用程序
5、Spring Cloud Cloud Foundry Service Broker 为建立管理云托管服务的服务代理提供了一个起点。
6、Spring Cloud Cluster 基于Zookeeper, Redis, Hazelcast, Consul实现的领导选举和平民状态模式的抽象和实现。
7、Spring Cloud Consul 基于Hashicorp Consul实现的服务发现和配置管理。
8、Spring Cloud Security 在Zuul代理中为OAuth2 rest客户端和认证头转发提供负载均衡
9、Spring Cloud Sleuth SpringCloud应用的分布式追踪系统，和Zipkin，HTrace，ELK兼容。
10、Spring Cloud Data Flow 一个云本地程序和操作模型，组成数据微服务在一个结构化的平台上。
11、Spring Cloud Stream 基于Redis,Rabbit,Kafka实现的消息微服务，简单声明模型用以在Spring Cloud应用中收发消息。
12、Spring Cloud Stream App Starters 基于Spring Boot为外部系统提供spring的集成
13、Spring Cloud Task 短生命周期的微服务，为SpringBooot应用简单声明添加功能和非功能特性。
14、Spring Cloud Task App Starters
15、Spring Cloud Zookeeper 服务发现和配置管理基于Apache Zookeeper。
16、Spring Cloud for Amazon Web Services 快速和亚马逊网络服务集成。
17、Spring Cloud Connectors 便于PaaS应用在各种平台上连接到后端像数据库和消息经纪服务。
18、Spring Cloud Starters （项目已经终止并且在Angel.SR2后的版本和其他项目合并）
19、Spring Cloud CLI 插件用Groovy快速的创建Spring Cloud组件应用。


Spring Cloud Gateway 作为API 网关（不是使用zuul作为网关），关于Spring Cloud Gateway和zuul的性能比较本文不再赘述，基本可以肯定Spring Cloud Finchley版本的gateway比zuul 1.x系列的性能和功能整体要好。

特别提醒：Spring Cloud Finchley版本中，即使你引入了spring-cloud-starter-netflix-zuul，也不是2.0版本的zuul