package tech.build.run.jbank.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class WalletNotFoundException extends JBankException {
    private final String message;

    public WalletNotFoundException(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public ProblemDetail toProblemDetail() {
        ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.NOT_FOUND);
        problemDetail.setDetail(message);
        problemDetail.setTitle("Carteira não encontrada");

        return problemDetail;
    }
}
