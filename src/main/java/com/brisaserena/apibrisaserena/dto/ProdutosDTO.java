package com.brisaserena.apibrisaserena.dto;

import java.io.Serializable;

public class ProdutosDTO implements Serializable{


	private static final long serialVersionUID = 1L;

	private Integer id;
	private String nome;
	private Double preco;
	private int quantidade;
	
	
	
	
	
	public ProdutosDTO(Integer id, String nome, Double preco, int quantidade) {
		super();
		this.id = id;
		this.nome = nome;
		this.preco = preco;
		this.quantidade = quantidade;
	}
	public ProdutosDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Double getPreco() {
		return preco;
	}
	public void setPreco(Double preco) {
		this.preco = preco;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	
	
	
}
