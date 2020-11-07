package com.prime.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.prime.model.Cliente;


public class Clientes implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	public Cliente porId(Long id) {
		return manager.find(Cliente.class, id);
	}
	
	public List<Cliente> todos() {
		return manager.createQuery("from Cliente", Cliente.class).getResultList();
	}
	
	public Cliente guardar(Cliente cliente) {
		return manager.merge(cliente);
	}
	
	public void remover(Cliente cliente) {
		cliente = porId(cliente.getId());
		manager.remove(cliente);
	}

}