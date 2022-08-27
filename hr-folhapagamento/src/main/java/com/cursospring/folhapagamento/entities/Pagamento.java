package com.cursospring.folhapagamento.entities;

import java.io.Serializable;

public class Pagamento implements Serializable{

	private static final long serialVersionUID = -1075455618212830602L;
	
	private String nome;
	private Double quantidadePorDia;
	private Integer diasTrabalhados;
	
	public Pagamento() {
	}

	public Pagamento(String nome, Double quantidadePorDia, Integer diasTrabalhados) {
		super();
		this.nome = nome;
		this.quantidadePorDia = quantidadePorDia;
		this.diasTrabalhados = diasTrabalhados;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Double getQuantidadePorDia() {
		return quantidadePorDia;
	}
	public void setQuantidadePorDia(Double quantidadePorDia) {
		this.quantidadePorDia = quantidadePorDia;
	}
	public Integer getDiasTrabalhados() {
		return diasTrabalhados;
	}
	public void setDiasTrabalhados(Integer diasTrabalhados) {
		this.diasTrabalhados = diasTrabalhados;
	}
	
	public double getTotal() {
		return quantidadePorDia * diasTrabalhados;
	}
}
