package cat.passerine.sylvia.handler;

public class FoodNotFoundException extends RuntimeException {
 
    public FoodNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public FoodNotFoundException() {
        super();
    }

}
