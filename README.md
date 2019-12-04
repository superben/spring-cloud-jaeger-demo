# The original opentracing-microservices-example

Example application for [A minimalistic guide to distributed tracing with OpenTracing and Jaeger](https://shekhargulati.com/2019/04/08/a-minimalistic-guide-to-distributed-tracing-with-opentracing-and-jaeger/) post.

# Opentracing-microservices-example for Spring cloud 

1. Added two dependencies in name-generator-service, and only opentracing-spring-jaeger-web-starter for animal-name-service and scientist-name-service.

```
        <dependency>
            <groupId>io.opentracing.contrib</groupId>
            <artifactId>opentracing-spring-jaeger-web-starter</artifactId>
            <version>2.0.3</version>
        </dependency>
        <dependency>
            <groupId>io.opentracing.contrib</groupId>
            <artifactId>opentracing-spring-jaeger-cloud-starter</artifactId>
            <version>2.0.3</version>
        </dependency>

```
2. Use OpenFeign client to call servises

```
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-openfeign</artifactId>
        </dependency>

    <dependencyManagement>
        <dependencies>
            <dependency>
                <groupId>org.springframework.cloud</groupId>
                <artifactId>spring-cloud-dependencies</artifactId>
                <version>${spring-cloud.version}</version>
                <type>pom</type>
                <scope>import</scope>
            </dependency>
        </dependencies>
    </dependencyManagement>

```

# Verify with Jaeger
 
```
http://localhost:16686/search
```