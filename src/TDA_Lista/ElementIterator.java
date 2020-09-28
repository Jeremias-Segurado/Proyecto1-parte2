package TDA_Lista;

import java.util.*;

/**
 * Clase ElementIterator diseñada exclusivamente para ser utilizada por la clase ListaDoblementeEnlazada
 * @author 
 * @param <E> Tipo de dato genérico
 */

public class ElementIterator<E> implements Iterator<E> {
	protected PositionList<E> lista; //Lista a iterar
	protected Position<E> cursor; //Posición del elemento corriente
	
	// CONSTRUCTOR
	/**
	 * Contructor de ElementIterator
	 * @param l Referencia a la lista a iterar
	 */
	public ElementIterator(PositionList<E> l) {
		lista = l; //Guardo la referencia a la lista a iterar
		try {
			cursor = lista.first(); //Si la lista no está vacía, la posición corriente es la primera de la lista
		}catch(EmptyListException e) {
			cursor = null; //Si la lista está vacía, la posición corriente es nula
		}
	}
	
	// CONSULTAS
	/**
	 * Retorna verdadero si hay un elemento siguiente en el iterador, falso en caso contrario
	 */
	public boolean hasNext() {
		return cursor != null; //Hay siguiente si el cursor no está más allá de la última posición
	}
	
	// COMANDOS
	/**
	 * Retorna el siguiente elemento en el iterador
	 * @throws NoSuchElementException En caso de que no haya elemento siguiente.
	 */
	public E next() throws NoSuchElementException {
		if(cursor == null) { // Si el cursor es null, el cliente no testeó que hasNext() fuese verdadero
			throw new NoSuchElementException("ERROR! No hay siguiente.");
		}
		E retorno = cursor.element(); //Salvo el elemento corriente
		try {
			if(cursor == lista.last()) {
				cursor = null;
			}else {
				cursor = lista.next(cursor); //Avanzo a la siguiente posición
			}
		}catch(EmptyListException ele) {
		}catch(BoundaryViolationException bve) {
		}catch(InvalidPositionException ipe) {} //bloque try-catch para que el compilador se quede piola
		
		return retorno; //Retorno el elemento salvado
	}
	
	/**
	 * Elimina un elemento del iterator. Actualmente no tiene funcionalidad.
	 */
	public void remove() {}
}
