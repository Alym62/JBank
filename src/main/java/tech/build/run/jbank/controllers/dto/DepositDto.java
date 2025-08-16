package tech.build.run.jbank.controllers.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record DepositDto(
        @NotNull
        @DecimalMin("10.00")
        BigDecimal value
) {
}
