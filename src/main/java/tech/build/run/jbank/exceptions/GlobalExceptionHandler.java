package tech.build.run.jbank.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(JBankException.class)
    public ProblemDetail jBankException(JBankException exception) {
        return exception.toProblemDetail();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ProblemDetail methodArgumentNotValidException(MethodArgumentNotValidException exception) {
        ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);
        Map<String, String> invalidParams = new HashMap<>();

        for (FieldError fieldError : exception.getFieldErrors()) {
            invalidParams.put(fieldError.getField(), fieldError.getDefaultMessage());
        }

        problemDetail.setTitle("Parâmetros da requisição inválidos");
        problemDetail.setDetail("Existe campos inválidos no corpo da requisição");
        problemDetail.setProperty("Parâmetros inválidos", invalidParams);

        return problemDetail;
    }
}
