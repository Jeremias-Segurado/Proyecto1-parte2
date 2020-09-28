package TDA_Lista;

/**
 * Clase EmptyListException utilizada en clases que implemenen la interface PositionList.
 * @author 
 *
 */
public class EmptyListException extends Exception {
	/**
	 * Constructor
	 * @param msg Mensaje del error.
	 */
	public EmptyListException(String msg) {
		super(msg);
	}
}
