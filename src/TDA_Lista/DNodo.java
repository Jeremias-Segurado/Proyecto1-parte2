package TDA_Lista;


/**
 * Nodo doblemente enlazado.
 * @author 
 * @param <E> Tipo de dato genórico 
 */

public class DNodo<E> implements Position<E> {
	protected DNodo<E> prev, next; //Referencias a los nodos anterior y siguiente
	protected E elemento;
	
	// CONSTRUCTOR
	/**
	 * Constructor
	 * @param prev DNodo anterior al DNodo actual
	 * @param next DNodo siguiente al DNodo actual
	 * @param elem Elemento a almacenarse en el DNodo actual
	 */
	public DNodo(DNodo<E> prev, DNodo<E> next, E elem) {
		this.prev = prev;
		this.next = next;
		this.elemento = elem;
	}
	
	// CONSULTAS
	@Override
	public E element() {
		return this.elemento;
	}
	
	/**
	 * Devuelve el nodo siguiente al nodo actual
	 * @return El nodo siguiente al nodo actual
	 */
	public DNodo<E> getNext(){
		return this.next;
	}
	
	/**
	 * Devuelve el nodo anterior al nodo actual
	 * @return El nodo anterior al nodo actual
	 */
	public DNodo<E> getPrev(){
		return this.prev;
	}
	
	// COMANDOS
	/**
	 * Asigna el nodo siguiente al nodo actual
	 * @param next El nodo siguiente al nodo actual
	 */
	public void setNext(DNodo<E> next) {
		this.next = next;
	}
	
	/**
	 * Asigna el nodo anterior al nodo actual
	 * @param prev El nodo anterior al nodo actual
	 */
	public void setPrev(DNodo<E> prev) {
		this.prev = prev;
	}
	
	/**
	 * Le asigna el valor al nodo actual 
	 * @param elem El elemento a almacenarse en el nodo actual
	 */
	public void setElement(E elem) {
		this.elemento = elem;
	}
}
