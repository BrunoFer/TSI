package br.edu.ifsudestemg.ssad.loja.rmi;

import java.util.List;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Livraria extends Remote {
	void adiciona(Livro livro) throws RemoteException;
	float getTotal() throws RemoteException;
	List<Livro>  getLivros() throws RemoteException;
	
}
