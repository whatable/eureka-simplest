package rx.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class EurekaClientOfAuthen {

	public static void main(String[] args) {
		SpringApplication.run(EurekaClientOfAuthen.class, args);
	}
}
