package br.edu.ifsudestemg.ssad.loja.rmi;

import java.io.Serializable;

public class Livro implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//private static final long 
	private String nome,ispn;
	private float preco;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getIspn() {
		return ispn;
	}
	public void setIspn(String ispn) {
		this.ispn = ispn;
	}
	public float getPreco() {
		return preco;
	}
	public void setPreco(float preco) {
		this.preco = preco;
	}

}
