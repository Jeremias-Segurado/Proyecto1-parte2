package GrafoDirigido;

import TDA_Lista.*;

public class Nodo<E> implements Position<E>{
	private E rotulo;
	private PositionList<Arco<E>> Arcos;
	
	
	public Nodo(E rotulo) {
		this.rotulo=rotulo;
		Arcos=new ListaDoblementeEnlazada<Arco<E>>();
	}
	public void crearArco(Nodo<E> sucesor) {
		boolean existe=false; //Podria haber creado una exception para esto.
		for (Arco<E> arr: Arcos) {
			if (arr.getSucesor().equals(sucesor))
				existe=true;
		}
		if (!existe) {
			Arcos.addLast(new Arco<E>(this, sucesor));
		}
	}
	public void eliminarArco(Arco<E> arco) {
		
		try {
		Arcos.remove(new DNodo<Arco<E>>(null, null, arco));
		}catch(InvalidPositionException e) { System.out.println(e.getMessage()); }
		
	}
	public void setRotulo(E rotulo) {
		this.rotulo=rotulo;
	}
	public PositionList<Arco<E>> obtenerArcos(){
		return Arcos;
	}
	
	@Override
	public E element() {		
		return rotulo;
	}
}
