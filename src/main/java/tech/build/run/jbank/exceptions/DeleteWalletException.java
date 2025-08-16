package tech.build.run.jbank.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class DeleteWalletException extends JBankException {
    private final String message;

    public DeleteWalletException(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public ProblemDetail toProblemDetail() {
        ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.UNPROCESSABLE_ENTITY);
        problemDetail.setDetail(message);
        problemDetail.setTitle("Não é possível deletar a carteira");

        return problemDetail;
    }
}
