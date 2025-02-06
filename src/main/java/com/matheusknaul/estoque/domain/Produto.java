package com.matheusknaul.estoque.domain;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Produto implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String descricao;
	
	private int quantidade;

	private double precoCompra;
	
	private double precoVenda;
	
	private LocalDate dataCadastro = LocalDate.now();
	
	public Produto(Integer id, String descricao, int quantidade, double precoCompra, double precoVenda) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.quantidade = quantidade;
		this.precoCompra = precoCompra;
		this.precoVenda = precoVenda;
	}
	
	public Integer getId() {
		return this.id;
	}
	
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	public double getPrecoCompra() {
		return precoCompra;
	}
	
	public void setPrecoCompra(double preco) {
		this.precoCompra = preco;
	}
	
	public double getPrecoVenda() {
		return precoVenda;
	}
	
	public void setPrecoVenda(double preco) {
		this.precoVenda = preco;
	}
	
	
}
