package com.prime.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.prime.model.Cliente;
import com.prime.model.Motocicleta;
import com.prime.model.Venda;
import com.prime.repository.Clientes;
import com.prime.repository.Motocicletas;
import com.prime.repository.Vendas;
import com.prime.service.CadastroVendaService;
import com.prime.util.FacesMessages;

@Named
@ViewScoped
public class GestaoVendasBean implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Inject
	private Vendas vendas;
	
	@Inject
	private CadastroVendaService cadastroVenda;
	
	@Inject
	private Clientes clientes;
	
	@Inject
	private Motocicletas motocicletas;
	
	@Inject
	private FacesMessages messages;
	
	
	private List<Venda> todasVendas;
	
	private List<Venda> listaVendas;
	
	private Venda vendaEdicao = new Venda();
	
	private List<Cliente> todosClientes;
	private List<Motocicleta> todasMotocicletas;
	
	private double preco;
	
	public void prepararNovoCadastro() {
		this.todosClientes = clientes.todos();
		this.todasMotocicletas = motocicletas.todas();
		this.vendaEdicao = new Venda();
		this.vendaEdicao.setCliente(new Cliente());
		this.vendaEdicao.setMotocicleta(new Motocicleta());
		this.preco = 0;		
	}
	
	public void salvar() {
		cadastroVenda.salvar(vendaEdicao);
		consultar();
		
		messages.info("Venda realizada com sucesso!");
	}
	
	public void consultar() {
		List<Venda> todas = vendas.todas();
		
		List<Venda> lstAux = new ArrayList<>();
		
		todas.forEach(l -> {
			Long clienteId = l.getCliente().getId();
			Long motoId = l.getMotocicleta().getId();
			
			Cliente c = clientes.porId(clienteId);
			Motocicleta m = motocicletas.porId(motoId);
			
			lstAux.add(new Venda(c, m));
			
		});
		
		this.listaVendas = lstAux;
				
	}
	
	public void alteraPreco() {
        System.out.println("mudouu");
        this.preco = 1000;
    }

	public List<Venda> getTodasVendas() {
		return todasVendas;
	}

	public void setTodasVendas(List<Venda> todasVendas) {
		this.todasVendas = todasVendas;
	}

	public Venda getVendaEdicao() {
		return vendaEdicao;
	}

	public void setVendaEdicao(Venda vendaEdicao) {
		this.vendaEdicao = vendaEdicao;
	}

	public List<Cliente> getTodosClientes() {
		return todosClientes;
	}

	public void setTodosClientes(List<Cliente> todosClientes) {
		this.todosClientes = todosClientes;
	}

	public List<Motocicleta> getTodasMotocicletas() {
		return todasMotocicletas;
	}

	public void setTodasMotocicletas(List<Motocicleta> todasMotocicletas) {
		this.todasMotocicletas = todasMotocicletas;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public List<Venda> getListaVendas() {
		return listaVendas;
	}

	public void setListaVendas(List<Venda> listaVendas) {
		this.listaVendas = listaVendas;
	}
	
}
