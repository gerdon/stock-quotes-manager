package br.com.inatel.stockquotesmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.inatel.stockquotesmanager.model.Quote;

public interface QuoteRepository extends JpaRepository<Quote, String>{

}
