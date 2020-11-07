package com.prime.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.prime.model.Cliente;
import com.prime.repository.Clientes;
import com.prime.util.Transacional;

public class CadastroClienteService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Clientes clientes;
	
	@Transacional
	public void salvar(Cliente cliente) {
		clientes.guardar(cliente);
	}
	
	@Transacional
	public void excluir(Cliente cliente) {
		clientes.remover(cliente);
	}

}