package com.brisaserena.apibrisaserena.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProdutosDTO implements Serializable{


	private static final long serialVersionUID = 1L;

	private Integer id;
	private String nome;
	private Double preco;
	private int quantidade;
	private Integer idCategoria;
		
	
}
