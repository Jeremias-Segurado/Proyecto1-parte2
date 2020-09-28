package TDA_Lista;

/**
 * Clase BoundaryViolationException utilizada por clases que implementan la interface PositionList.
 * @author 
 */
public class BoundaryViolationException extends Exception {
	/**
	 * Constructor
	 * @param msg Mensaje del error.
	 */
	public BoundaryViolationException(String msg) {
		super(msg);
	}
}
