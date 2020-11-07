package com.prime.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.prime.model.Venda;

public class Vendas implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;
	
	public Venda porId(Long id) {
		return manager.find(Venda.class, id);
	}
	
	public List<Venda> todas() {
		return manager.createQuery("from Venda", Venda.class).getResultList();
	}
	
	public Venda guardar(Venda venda) {
		return manager.merge(venda);
	}
	
	public void remover(Venda venda) {
		venda = porId(venda.getId());
		manager.remove(venda);
	}
	
}
