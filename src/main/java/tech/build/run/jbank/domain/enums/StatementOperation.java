package tech.build.run.jbank.domain.enums;

public enum StatementOperation {
    CREDIT("Crédito"),
    DEBIT("Débito");

    private final String value;

    StatementOperation(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
