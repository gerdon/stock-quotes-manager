package br.com.inatel.stockquotesmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.inatel.stockquotesmanager.model.Stock;

public interface StockRepository extends JpaRepository<Stock, Integer>{

}
