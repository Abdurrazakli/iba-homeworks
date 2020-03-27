package homework12.exceptions;

public class FamilyOverflowException extends RuntimeException {
    public FamilyOverflowException(String message) {
        super(message);
    }

    public FamilyOverflowException(String message, Throwable cause) {
        super(message, cause);
    }
}
