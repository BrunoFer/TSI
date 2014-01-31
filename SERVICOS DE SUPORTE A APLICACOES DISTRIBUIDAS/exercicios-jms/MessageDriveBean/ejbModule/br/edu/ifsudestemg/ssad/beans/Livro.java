package br.edu.ifsudestemg.ssad.beans;

import java.io.Serializable;

public class Livro implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String nome;
	private float preco;
	
	public Livro(){}
	
	public Livro(int id, String nome, float preco){
		this.id=id;
		this.nome=nome;
		this.preco=preco;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public float getPreco() {
		return preco;
	}
	public void setPreco(float preco) {
		this.preco = preco;
	}

}
