package br.com.inatel.stockquotesmanager.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table
public class Quote {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_quote")
	private Integer id;
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date dataQuotation;
	
	private BigDecimal value;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDataQuotation() {
		return dataQuotation;
	}

	public void setDataQuotation(Date dataQuotation) {
		this.dataQuotation = dataQuotation;
	}

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}
	
}
