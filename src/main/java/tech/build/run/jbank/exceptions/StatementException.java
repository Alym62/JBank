package tech.build.run.jbank.exceptions;

public class StatementException extends JBankException{
    private final String message;

    public StatementException(String message) {
        super(message);
        this.message = message;
    }
}
