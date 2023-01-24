package tasks.exceptions;

public class IncorrectArgumentException extends Exception {
    public String argument;

    public IncorrectArgumentException(String message, String argument) {
        super(message);
        this.argument = argument;
    }
}
