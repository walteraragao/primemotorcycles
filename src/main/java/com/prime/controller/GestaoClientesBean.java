package com.prime.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.prime.model.Cliente;
import com.prime.repository.Clientes;
import com.prime.service.CadastroClienteService;
import com.prime.util.FacesMessages;

@Named
@ViewScoped
public class GestaoClientesBean implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Inject
	private Clientes clientes;
	
	@Inject
	private CadastroClienteService cadastroCliente;
	
	@Inject
	private FacesMessages messages;
	
	private List<Cliente> todosClientes;
	private Cliente clienteEdicao = new Cliente();
	
	public void prepararNovoCadastro() {
		clienteEdicao = new Cliente();
	}
	
	public void salvar() {
		cadastroCliente.salvar(clienteEdicao);
		consultar();
		
		messages.info("Cliente cadastrado com sucesso!");
	}
	
	public void consultar() {
		todosClientes = clientes.todos();
	}
	
	public void prepararEdicao(long id) {
		this.clienteEdicao = clientes.porId(id);
		System.out.println("prepararEdicao...." + id);
	}
	
	public void deletar(Cliente cliente) {
		clientes.remover(cliente);
		messages.info("Cliente removido com sucesso!");
	}

	public List<Cliente> getTodosClientes() {
		return todosClientes;
	}

	public void setTodosClientes(List<Cliente> todosClientes) {
		this.todosClientes = todosClientes;
	}

	public Cliente getClienteEdicao() {
		return clienteEdicao;
	}

	public void setClienteEdicao(Cliente clienteEdicao) {
		this.clienteEdicao = clienteEdicao;
	}
	
}
