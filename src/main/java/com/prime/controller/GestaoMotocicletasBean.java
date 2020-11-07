package com.prime.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.prime.model.Cliente;
import com.prime.model.MarcaMotocicleta;
import com.prime.model.Motocicleta;
import com.prime.repository.Motocicletas;
import com.prime.service.CadastroMotocicletaService;
import com.prime.util.FacesMessages;

@Named
@ViewScoped
public class GestaoMotocicletasBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Motocicletas motocicletas;
	
	@Inject
	private CadastroMotocicletaService cadastroMotocicleta;
	
	@Inject
	private FacesMessages messages;
	
	private List<Motocicleta> todasMotocicletas;
	private Motocicleta motocicletaEdicao = new Motocicleta();
	
	public void prepararNovoCadastro() {
		motocicletaEdicao = new Motocicleta();
	}
	
	public void salvar() {
		cadastroMotocicleta.salvar(motocicletaEdicao);
		consultar();
		
		messages.info("Motocicleta cadastrada com sucesso!");
	}
	
	public void consultar() {
		todasMotocicletas = motocicletas.todas();
	}
	
	public void prepararEdicao(long id) {
		this.motocicletaEdicao = motocicletas.porId(id);
	}
	
	public void deletar(Motocicleta motocicleta) {
		motocicletas.remover(motocicleta);
		messages.info("Motocicleta removida com sucesso!");
	}

	public List<Motocicleta> getTodasMotocicletas() {
		return todasMotocicletas;
	}
	
	public MarcaMotocicleta[] getMarcasMotocicletas() {
		return MarcaMotocicleta.values();
	}

	public Motocicleta getMotocicletaEdicao() {
		return motocicletaEdicao;
	}

	public void setMotocicletaEdicao(Motocicleta motocicletaEdicao) {
		this.motocicletaEdicao = motocicletaEdicao;
	}
	
}