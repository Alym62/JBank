package tech.build.run.jbank.controllers.dto;

import tech.build.run.jbank.domain.enums.StatementOperation;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record StatementItemDto(
        String statementId,
        String type,
        String literal,
        BigDecimal value,
        LocalDateTime dateTime,
        StatementOperation operation
) {
}
