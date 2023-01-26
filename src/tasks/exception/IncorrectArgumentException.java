package tasks.exception;

public class IncorrectArgumentException extends RuntimeException {
    public String argument;

    public IncorrectArgumentException(String message, String argument) {
        super(message);
        this.argument = argument;
    }

    public IncorrectArgumentException(String message) {
        super(message);
    }
}
