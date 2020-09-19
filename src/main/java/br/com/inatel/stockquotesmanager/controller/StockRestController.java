package br.com.inatel.stockquotesmanager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.inatel.stockquotesmanager.model.Stock;
import br.com.inatel.stockquotesmanager.repository.StockRepository;

@RestController
@RequestMapping("stock")
public class StockRestController {

	@Autowired
	private StockRepository stockRepository;
	
	@GetMapping
	public List<Stock> findAll(){
		return stockRepository.findAll();
	}
	
	@PostMapping
	public Stock save(@RequestBody Stock stock) {
//		RestTemplate rt = new RestTemplate();
//		
//		ResponseEntity<Object> stocks = rt.getForEntity("http://localhost:8080/stock", Object.class);
//		System.out.println(stocks.getBody());
		
		return stockRepository.save(stock);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Stock> getById(@PathVariable Integer id){
		Stock stock = stockRepository.findById(id).get();
		
		return ResponseEntity.ok().body(stock);
	}
}
