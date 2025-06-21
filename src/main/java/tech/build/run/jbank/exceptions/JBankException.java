package tech.build.run.jbank.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public abstract class JBankException extends RuntimeException {
    public JBankException(String message) {
        super(message);
    }

    public JBankException(Throwable cause) {
        super(cause);
    }

    public ProblemDetail toProblemDetail() {
        ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        problemDetail.setTitle("Internal server error");
        problemDetail.setDetail("Contact JBank support");

        return problemDetail;
    }
}
