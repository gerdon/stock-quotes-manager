package br.com.inatel.stockquotesmanager;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import br.com.inatel.stockquotesmanager.model.Manager;

@SpringBootApplication
public class StockQuotesManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(StockQuotesManagerApplication.class, args);
	}
	
	@PostConstruct
	void conectionRegisterStart() {
		RestTemplate rt = new RestTemplate();
		Manager manager =  new Manager("localhost", 8081);
		
		ResponseEntity<Object> response = rt.postForEntity("http://localhost:8080/notification", manager, Object.class);
		System.out.println(response.getStatusCodeValue() +" - "+ response.getBody());
	}

}
