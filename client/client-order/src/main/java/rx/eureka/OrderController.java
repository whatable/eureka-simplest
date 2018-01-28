package rx.eureka;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

	@RequestMapping("/")
	public String index() {
		return "index of order";
	}

	@RequestMapping("/order")
	String order() {
		return "order";
	}
}
