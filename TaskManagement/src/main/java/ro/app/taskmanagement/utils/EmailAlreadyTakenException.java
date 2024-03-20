package ro.app.taskmanagement.utils;

public class EmailAlreadyTakenException extends Exception{
    public EmailAlreadyTakenException() {
        super();
    }

    public EmailAlreadyTakenException(String message) {
        super(message);
    }
}
