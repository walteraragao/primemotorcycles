package com.prime.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Venda implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;
	
	//@NotEmpty
	@Column(name = "id_cliente", nullable = false, length = 1000)
	private Cliente cliente;

	//@NotEmpty
	@Column(name = "id_motocicleta", nullable = false, length = 1000)
	private Motocicleta motocicleta;
	
	public Venda() {}

	public Venda(Cliente cliente, Motocicleta motocicleta) {
		this.cliente = cliente;
		this.motocicleta = motocicleta;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Motocicleta getMotocicleta() {
		return motocicleta;
	}

	public void setMotocicleta(Motocicleta motocicleta) {
		this.motocicleta = motocicleta;
	}
	
}
