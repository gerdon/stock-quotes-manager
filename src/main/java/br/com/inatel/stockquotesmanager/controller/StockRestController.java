package br.com.inatel.stockquotesmanager.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class StockRestController {
	
	@DeleteMapping("/stockcache")
	public void cleanCache() {
		System.err.println("LIMPANDO O CACHE DOS STOCKS");
	}

}
