package tech.build.run.jbank.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
public class WalletDataAlreadyException extends JBankException {
    private final String message;

    public WalletDataAlreadyException(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public ProblemDetail toProblemDetail() {
        ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.UNPROCESSABLE_ENTITY);
        problemDetail.setDetail(message);
        problemDetail.setTitle("Dados da carteira existentes");

        return problemDetail;
    }
}
