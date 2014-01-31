package br.edu.ifsudestemg.ssad.loja.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class LivrariaBean extends UnicastRemoteObject implements Livraria {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Livro> livros = new ArrayList<Livro>();
	private float total = 0;
	
	protected LivrariaBean() throws RemoteException {
		super();
	}

	@Override
	public void adiciona(Livro livro) throws RemoteException {
		livros.add(livro);
		this.total+=livro.getPreco();
	}

	@Override
	public float getTotal() throws RemoteException {
		return this.total;
	}

	@Override
	public List<Livro> getLivros() throws RemoteException {
		return livros;
	}

}
