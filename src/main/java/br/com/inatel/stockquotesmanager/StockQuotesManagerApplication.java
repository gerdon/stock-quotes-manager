package br.com.inatel.stockquotesmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StockQuotesManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(StockQuotesManagerApplication.class, args);
	}
	
//	@PostConstruct
//	void conectionStart() {
//		RestTemplate rt = new RestTemplate();
//		
//		ResponseEntity<Manager> manager = rt.postForEntity("http://localhost:8080/notification", new Manager("localhost", 8081), Manager.class);
//		
//		System.out.println(manager.toString());
//	}

}
