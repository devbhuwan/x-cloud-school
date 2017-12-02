package x.cloud.api.gateway;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
public class CloudApiGatewayServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudApiGatewayServiceApplication.class, args);
    }

}
