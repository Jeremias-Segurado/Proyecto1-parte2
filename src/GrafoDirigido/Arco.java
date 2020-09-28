package GrafoDirigido;

public class Arco<E> {
	private Nodo<E> sucesor, predecesor;
	
	
	public Arco( Nodo<E> predecesor, Nodo<E> sucesor ) { 
		this.predecesor=predecesor;
		this.sucesor=sucesor;
	}
	public Nodo<E> getPredecesor() { return predecesor;}
	public Nodo<E> getSucesor() { return sucesor; }		
}
