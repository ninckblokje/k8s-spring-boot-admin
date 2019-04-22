package ninckblokje.spring.admin;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableAdminServer
@EnableDiscoveryClient
@EnableScheduling
public class K8SSpringBootAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(K8SSpringBootAdminApplication.class, args);
    }

}
