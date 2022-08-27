package com.cursospring.folhapagamento.entities;

import java.io.Serializable;

public class Worker implements Serializable{

	private static final long serialVersionUID = -8953867528296600685L;

	private Long id;
	private String nome;
	private Double quantidadeDia;
	
	public Worker() {
	}
	
	public Worker(Long id, String nome, Double quantidadeDia) {
		super();
		this.id = id;
		this.nome = nome;
		this.quantidadeDia = quantidadeDia;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getQuantidadeDia() {
		return quantidadeDia;
	}

	public void setQuantidadeDia(Double quantidadeDia) {
		this.quantidadeDia = quantidadeDia;
	}
	
}
