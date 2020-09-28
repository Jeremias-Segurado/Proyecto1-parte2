package GrafoDirigido;

public class Proyecto1 {
	public static void main(String[] args) {
		Graph grafo = new Graph();
		
		int nodo1, nodo2, nodo3;
		
		nodo1=10;
		nodo2=4;
		nodo3=31;
		
		grafo.addNode(nodo1);
		grafo.addNode(nodo2);
		grafo.addNode(nodo3);
		grafo.addNode(nodo2);
		
		grafo.addEdge(nodo1, nodo3);
		grafo.addEdge(nodo3, nodo2);
		grafo.addEdge(44, nodo3);
		
		grafo.removeEdge(nodo2, nodo1);
		grafo.removeEdge(nodo3, nodo2);
		
		grafo.removeNode(15);
		grafo.removeNode(nodo1);
	}
}
