package br.com.inatel.stockquotesmanager.model;

public class Manager {
	
	private String host;
	private Integer port;
	
	public Manager(String host, Integer port) {
		super();
		this.host = host;
		this.port = port;
	}
	
	public String getHost() {
		return host;
	}
	
	public void setHost(String host) {
		this.host = host;
	}
	
	public Integer getPort() {
		return port;
	}
	
	public void setPort(Integer port) {
		this.port = port;
	}
	
}
