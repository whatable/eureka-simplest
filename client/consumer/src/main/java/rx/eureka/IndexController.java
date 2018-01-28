package rx.eureka;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class IndexController {

	@Autowired
	private DiscoveryClient discoveryClient;

	@Autowired
	RestTemplate rest;

	@RequestMapping("/")
	String index() {
		return "API_NUL";
	}

	@RequestMapping("/{service}")
	String index(@PathVariable(value = "service", required = true) String service) {
		String url = "http://" + service + "/";
		ResponseEntity<String> entity = rest.getForEntity(url, String.class);
		return entity.getBody();
	}

	@RequestMapping("/{service}/{api}")
	String index(@PathVariable(value = "service", required = true) String service,
			@PathVariable(value = "api", required = true) String api) {
		String url = "http://" + service + "/" + api;
		ResponseEntity<String> entity = rest.getForEntity(url, String.class);
		return entity.getBody();
	}

	@RequestMapping("/service-instances/{applicationName}")
	public List<ServiceInstance> serviceInstancesByApplicationName(@PathVariable String applicationName) {
		List<ServiceInstance> list = discoveryClient.getInstances(applicationName);
		return list;
	}

	@Bean
	@LoadBalanced
	RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
}
