package com.prime.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Motocicleta implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;

	@NotEmpty
	@Column(name = "modelo", nullable = false, length = 80)
	private String modelo;

	@NotEmpty
	@Column(name = "cor", nullable = false, length = 120)
	private String cor;

	@NotEmpty
	@Column(name = "placa", nullable = false, length = 18)
	private String placa;

	@NotNull
	@Column(name = "ano")
	private String ano;

	@NotNull
	@Enumerated(EnumType.STRING)
	private MarcaMotocicleta marca;
	
	@NotNull
	@Column(name = "valor")
	private Double valor;
	
	public Motocicleta() {}
	
	public Motocicleta(Long id, String modelo, String cor, String placa, String ano, MarcaMotocicleta marca,
			Double valor) {
		this.id = id;
		this.modelo = modelo;
		this.cor = cor;
		this.placa = placa;
		this.ano = ano;
		this.marca = marca;
		this.valor = valor;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public MarcaMotocicleta getMarca() {
		return marca;
	}

	public void setMarca(MarcaMotocicleta marca) {
		this.marca = marca;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Motocicleta other = (Motocicleta) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}