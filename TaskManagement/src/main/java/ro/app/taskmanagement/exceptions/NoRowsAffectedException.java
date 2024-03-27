package ro.app.taskmanagement.exceptions;

public class NoRowsAffectedException extends RuntimeException{
    public NoRowsAffectedException(String message) {
        super(message);
    }
}
