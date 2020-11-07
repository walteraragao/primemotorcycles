package com.prime.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.prime.model.Motocicleta;
import com.prime.repository.Motocicletas;
import com.prime.util.Transacional;

public class CadastroMotocicletaService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Motocicletas motocicletas;
	
	@Transacional
	public void salvar(Motocicleta motocicleta) {
		motocicletas.guardar(motocicleta);
	}
	
	@Transacional
	public void excluir(Motocicleta motocicleta) {
		motocicletas.remover(motocicleta);
	}

}