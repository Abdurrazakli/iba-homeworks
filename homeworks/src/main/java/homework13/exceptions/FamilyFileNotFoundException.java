package homework13.exceptions;

public class FamilyFileNotFoundException extends RuntimeException {
    public FamilyFileNotFoundException(String message) {
        super(message);
    }

    public FamilyFileNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
