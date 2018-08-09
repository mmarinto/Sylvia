package cat.passerine.sylvia.handler;

public class FoodIdMismatchException extends RuntimeException {
 
    public FoodIdMismatchException(String message, Throwable cause) {
        super(message, cause);
    }
    // ...

	public FoodIdMismatchException() {
		super();
	}

}