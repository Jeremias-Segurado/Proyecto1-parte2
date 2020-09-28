package GrafoDirigido;

import java.util.logging.*;
import TDA_Lista.*;

public class Graph<E> {
	private PositionList<Nodo<Integer>> Vertices;
	private static Logger logger;
	
	public Graph() {
		Vertices = new ListaDoblementeEnlazada<Nodo<Integer>>();
		if (logger==null) {
			logger=logger.getLogger(Graph.class.getName());
			
			Handler hnd = new ConsoleHandler();
			hnd.setLevel(Level.FINE);
			logger.addHandler(hnd);
			
			logger.setLevel(Level.WARNING);
			
			Logger rootLogger = logger.getParent();
			for (Handler h: rootLogger.getHandlers()) {
				h.setLevel(Level.OFF);
			}
			
		}
		/*Niveles logger:
		 *  FINE: operacion realizada con exito.
		 * 	WANRING: operacion no realizada.
		 * 	SEVERE: un error realizado por una excepcion, algo que no deberia ocurrir.
		 */
	}
	
	/**
	 * Agrega el nodo “node” al grafo, si aún no pertenecía a la estructura.
	 * @param node
	 */
	public void addNode(int node) {
		boolean pertenece=false;
		for (Nodo<Integer> nodo:Vertices) {
			if (nodo.element().equals(node))
				pertenece=true;
		}
		if (!pertenece) {
			Vertices.addLast(new Nodo<Integer>(node));
			logger.fine("Nodo "+node+" agregado al grafo.");
		}else {
			logger.warning("Nodo "+node+" ya existe.");
		}
	}
	
	/**
	 * Agrega un arco entre el nodo “node1” y el nodo “node2”, si aún 
	 * no existía el arco y ambos parámetros son nodos pertenecientes a la estructura.
	 * @param node1
	 * @param node2
	 */
	public void addEdge(int node1, int node2) {				
		Nodo<Integer> nodo1=checkPosition(node1);
		Nodo<Integer> nodo2=checkPosition(node2);
		if (nodo1!=null && nodo2!=null) {    //Podria crear una exception para cuando no existe el vertice 1 y 2.					
			nodo1.crearArco(nodo2); //Si el arco ya existe no crea ninguno nuevo.
			logger.fine("Arco entre "+node1+" y "+node2+"  creado.");
		}else {
			logger.warning("El arco entre "+node1+" y "+node2+" NO a podido ser creado, uno de los dos nodos NO pertenece al grafo.");
		}
	}
	/**
	 * Remueve el nodo “node” del grafo, si el parámetro es un nodo de la estructura.
	 * @param node
	 */
	public void removeNode(int node) {
		Nodo<Integer> aux=checkPosition(node);
		if (aux!=null) {
			for (Nodo<Integer> nodo: Vertices) {
				for (Arco<Integer> arco: nodo.obtenerArcos()) {
					if (arco.getSucesor().equals(aux)) {
						nodo.eliminarArco(arco);
					}
				}
			}
			try {
				for (Position<Nodo<Integer>> Dnodo: Vertices.positions()) {
					if (Dnodo.element().equals(aux)) {
						Vertices.remove(Dnodo);
						logger.fine("Nodo "+node+" eliminado con exito.");
					}
				}							
			} catch (InvalidPositionException e) {logger.severe("ERROR: Problemas internos con la confirmacion de nodos en 'removeNode'.");;}
		}else {
			logger.warning("El nodo "+node+" NO pertenece al grafo.");
		}
	}
	/**
	 *  remueve el arco entre el nodo “node1” y el nodo “node2”, 
	 *  si el arco formado por los parámetros pertenecen a la estructura.
	 * @param node1
	 * @param node2
	 */
	public void removeEdge(int node1, int node2) {
		Nodo<Integer> nodo1=checkPosition(node1);
		Nodo<Integer> nodo2=checkPosition(node1);
		if (nodo1!=null && nodo2!=null) {
			for (Arco<Integer> arco: nodo1.obtenerArcos()) {
				if (arco.getSucesor().equals(nodo2)) {
					nodo1.eliminarArco(arco);
					logger.fine("El arco entre "+node1+" y "+node2+" se elimino con exito.");
				}
			}
		}else {
			logger.warning("El arco entre "+node1+" y "+node2+" NO pudo ser eliminado, uno de los nodos NO pertenece al grafo.");
		}
	}
	
	private Nodo<Integer> checkPosition(int node){
		Nodo<Integer> aux = null;
		for (Nodo<Integer> nodo: Vertices) {
			if (nodo.element().equals(node))
				aux=nodo;
		}
		return aux;
	}
	
}
