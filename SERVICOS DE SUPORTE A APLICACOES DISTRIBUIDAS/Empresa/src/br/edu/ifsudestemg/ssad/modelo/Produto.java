package br.edu.ifsudestemg.ssad.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="produto")
public class Produto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String nome;
	private double valor;
	private List<ItemNota> itens = new ArrayList<ItemNota>();
	
	@Id
	@GeneratedValue
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

	public double getValor() {
		return valor;
	}
	public void setValor(double d) {
		this.valor = d;
	}
	
	@OneToMany(cascade=CascadeType.ALL)
	public List<ItemNota> getItens() {
		return itens;
	}
	public void setItens(List<ItemNota> itens) {
		this.itens = itens;
	}
	
}
