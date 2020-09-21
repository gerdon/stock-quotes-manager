package br.com.inatel.stockquotesmanager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import br.com.inatel.stockquotesmanager.model.Quote;
import br.com.inatel.stockquotesmanager.model.Stock;
import br.com.inatel.stockquotesmanager.repository.QuoteRepository;

@RestController
@RequestMapping("quote")
public class QuoteRestController {

	@Autowired
	private QuoteRepository quoteRepository;
	
	@GetMapping
	public List<Quote> findAll(){
		
		return quoteRepository.findAll();
	}
	
	@PostMapping
	public ResponseEntity<Quote> save(@RequestBody Quote quote) {
		RestTemplate rt = new RestTemplate();
		
		ResponseEntity<Stock[]> response = rt.getForEntity("http://localhost:8080/stock", Stock[].class);
		Stock[] stocks = response.getBody();
		
		for(Stock stock : stocks) {
			if(stock.getId().equals(quote.getId())) {
				quote.setDescription(stock.getDescription());
				Quote created = quoteRepository.save(quote);
				
				return new ResponseEntity<Quote>(created, HttpStatus.CREATED);
			}
		}
		
		return new ResponseEntity<Quote>(HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Quote> getById(@PathVariable String id){
		Quote quote = quoteRepository.findById(id).get();
		
		return new ResponseEntity<>(quote, HttpStatus.OK);
	}
}
