package com.prime.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.prime.model.Motocicleta;

public class Motocicletas implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	public Motocicleta porId(Long id) {
		return manager.find(Motocicleta.class, id);
	}
	
	public List<Motocicleta> todas() {
		return manager.createQuery("from Motocicleta", Motocicleta.class).getResultList();
	}
	
	public Motocicleta guardar(Motocicleta motocicleta) {
		return manager.merge(motocicleta);
	}
	
	public void remover(Motocicleta motocicleta) {
		motocicleta = porId(motocicleta.getId());
		manager.remove(motocicleta);
	}

}