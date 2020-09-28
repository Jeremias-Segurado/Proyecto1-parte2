package TDA_Lista;

import java.util.Iterator;


/**
 * Clase ListaDoblementeEnlazada, utiliza una estructura de nodos doblemente enlazada
 * @author 
 * @param <E> Tipo de dato genórico
 */

public class ListaDoblementeEnlazada<E> implements PositionList<E> {
	protected int longitud; //Nómero de elementos en la lista
	protected DNodo<E> cabeza, cola; //Centinelas
	
	/**
	 * Constructor. Crea una lista vacóa
	 */
	public ListaDoblementeEnlazada() {
		longitud = 0;
		cabeza = new DNodo<E>(null, null, null); //Crea la cabeza
		cola = new DNodo<E>(cabeza, null, null); //Crea la cola y enlaza la cola con la cabeza
		cabeza.setNext(cola); //Enlaza la cabeza con la cola
	}
	
	// CONSULTAS
	@Override
	public int size() {
		return longitud;
	}
	
	@Override
	public boolean isEmpty() {
		return (longitud == 0);
	}
	
	@Override
	public Position<E> first() throws EmptyListException{
		if(this.isEmpty()) {
			throw new EmptyListException("ERROR! Lista vacóa.");
		}
		return cabeza.getNext();
	}
	
	@Override
	public Position<E> last() throws EmptyListException{
		if(this.isEmpty()) {
			throw new EmptyListException("ERROR! Lista vacóa.");
		}
		return cola.getPrev();
	}
	
	@Override
	public Position<E> next(Position<E> p) throws InvalidPositionException, BoundaryViolationException{
		DNodo<E> v = checkPosition(p);
		DNodo<E> sig = v.getNext();
		if(sig == cola) {
			throw new BoundaryViolationException("ERROR! No hay posición siguiente a la óltima posición.");
		}
		return sig;
	}
	
	@Override
	public Position<E> prev(Position<E> p) throws InvalidPositionException, BoundaryViolationException{
		DNodo<E> v = checkPosition(p);
		DNodo<E> prev = v.getPrev();
		if(prev == cabeza) {
			throw new BoundaryViolationException("ERROR! No hay posición previa a la primera posición.");
		}
		return prev;
	}
	
	// COMANDOS
	@Override
	public void addAfter(Position<E> p, E elem) throws InvalidPositionException{
		DNodo<E> v = checkPosition(p);
		DNodo<E> nuevo = new DNodo<E>(v, v.getNext(), elem);
		v.getNext().setPrev(nuevo);
		v.setNext(nuevo);
		longitud++;
	}
	
	@Override
	public void addBefore(Position<E> p, E elem) throws InvalidPositionException{
		DNodo<E> v = checkPosition(p);
		DNodo<E> nuevo = new DNodo<E>(v.getPrev(), v, elem);
		v.getPrev().setNext(nuevo);
		v.setPrev(nuevo);
		longitud++;
	}
	
	@Override
	public void addFirst(E elem) {
		DNodo<E> nuevo = new DNodo<E>(cabeza, cabeza.getNext(), elem);
		cabeza.getNext().setPrev(nuevo);
		cabeza.setNext(nuevo);
		longitud++;
	}
	
	@Override
	public void addLast(E elem) {
		DNodo<E> nuevo = new DNodo<E>(cola.getPrev(), cola, elem);
		cola.getPrev().setNext(nuevo);
		cola.setPrev(nuevo);
		longitud++;
	}
	
	@Override
	public E remove(Position<E> p) throws InvalidPositionException {
		DNodo<E> v = checkPosition(p);
		DNodo<E> v_prev = v.getPrev();
		DNodo<E> v_next = v.getNext();
		v_prev.setNext(v_next);
		v_next.setPrev(v_prev);
		E v_element = v.element();
		
		//Desligo la posición de la lista
		v.setNext(null);
		v.setPrev(null);
		v.setElement(null);
		
		longitud--;
		return v_element;
	}
	
	@Override
	public E set(Position<E> p, E element) throws InvalidPositionException{
		DNodo<E> v = checkPosition(p);
		E elem_viejo = v.element();
		v.setElement(element);
		return elem_viejo;
	}
	
	/**
	 * Mótodo auxiliar para validar posiciones
	 * @param p Posición a validar
	 * @return Posición validada (en otras palabras, la posición p convertida en un DNodo)
	 * @throws InvalidPositionException En caso de que la posición no sea vólida
	 */
	protected DNodo<E> checkPosition(Position<E> p) throws InvalidPositionException{
		DNodo<E> aux = null;
		if(p == null) {
			throw new InvalidPositionException("ERROR! Posición nula.");
		}
		if(p == cabeza) {
			throw new InvalidPositionException("ERROR! El nodo cabeza no es una posición vólida.");
		}
		if(p == cola) {
			throw new InvalidPositionException("ERROR! El nodo cola no es una posición vólida.");
		}
		try {
			aux = (DNodo<E>) p;
			if((aux.getPrev() == null) || (aux.getNext() == null)){
				throw new InvalidPositionException("ERROR! La posición no es vólida.");
			}
		}catch(ClassCastException e) {
			throw new InvalidPositionException("ERROR! La posición no es del tipo de dato correcto.");
		}
		return aux;
	}
	
	// ITERADORES
	@Override
	public Iterator<E> iterator(){
		// Creo un ElementIterator sobre la lista this a iterar
		return new ElementIterator<E>(this);
	}

	@Override
	public Iterable<Position<E>> positions(){
		boolean ultimo = false;
		PositionList<Position<E>> l = new ListaDoblementeEnlazada<Position<E>>(); //Crea una lista de posiciones
		
		if(longitud>0) {
			DNodo<E> p = cabeza.next;
			while(!ultimo) {
				l.addLast(p); //Agrega la posición p como óltimo elemento de la lista l
				if(p == cola.prev) {
					ultimo = true;
				}
				p = p.next;
			}			
		}
		
		return l; //Devuelve l como nuestro objeto Iterable
	}	
}
