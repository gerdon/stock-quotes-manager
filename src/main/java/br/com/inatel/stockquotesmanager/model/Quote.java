package br.com.inatel.stockquotesmanager.model;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.MapKeyColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table
public class Quote {
	
	@Id
	private String id;
	
	@JsonIgnore
	private String description;
	
	@ElementCollection
    @MapKeyColumn(name="quote_date")
    @Column(name="quote_value")
    @CollectionTable(name="quotes_map")
	Map<String, String> quotes = new HashMap<String, String>();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Map<String, String> getQuotes() {
		return quotes;
	}

	public void setQuotes(Map<String, String> quotes) {
		this.quotes = quotes;
	}
	
}
