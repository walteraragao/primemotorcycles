package com.prime.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.prime.model.Venda;
import com.prime.repository.Vendas;
import com.prime.util.Transacional;

public class CadastroVendaService implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private Vendas vendas;
	
	@Transacional
	public void salvar(Venda venda) {
		vendas.guardar(venda);
	}
	
	@Transacional
	public void excluir(Venda venda) {
		vendas.remover(venda);
	}

}
