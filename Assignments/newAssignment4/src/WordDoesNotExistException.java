package assignment4;

public class WordDoesNotExistException extends Exception {
    private static final long serialVersionUID = 1L;

    public WordDoesNotExistException(String message) {
        super(message);
    }

    public WordDoesNotExistException(String message, Throwable throwable) {

        super(message, throwable);

    }
}