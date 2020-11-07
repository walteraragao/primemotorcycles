package com.prime.model;

public enum MarcaMotocicleta {

	HONDA("Honda"), 
	YAMAHA("Yamaha"),
	SUZUKI("Suzuki"),
	KAWASAKI("Kawasaki"),
	BMW("BMW");
	
	private String descricao;

	MarcaMotocicleta(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
}