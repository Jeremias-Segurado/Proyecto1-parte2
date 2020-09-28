package TDA_Lista;

/**
 * Clase InvalidPositionException utilizada en clases que implemenen la interface PositionList.
 * @author 
 *
 */
public class InvalidPositionException extends Exception {
	/**
	 * Constructor
	 * @param msg Mensaje del error.
	 */
	public InvalidPositionException(String msg) {
		super(msg);
	}
}
