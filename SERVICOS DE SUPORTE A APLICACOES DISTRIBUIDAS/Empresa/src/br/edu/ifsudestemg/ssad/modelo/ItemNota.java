package br.edu.ifsudestemg.ssad.modelo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="itemNota")
public class ItemNota implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private int qtde;
	private Produto produto = new Produto();
	private NotaFiscal nota = new NotaFiscal();
	
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getQtde() {
		return qtde;
	}
	public void setQtde(int qtde) {
		this.qtde = qtde;
	}
	
	@ManyToOne
	public Produto getProduto() {
		return produto;
	}
	
	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	@ManyToOne
	public NotaFiscal getNota() {
		return nota;
	}
	
	public void setNota(NotaFiscal nota) {
		this.nota = nota;
	}
	
}
