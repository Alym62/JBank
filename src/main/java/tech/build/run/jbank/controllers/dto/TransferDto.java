package tech.build.run.jbank.controllers.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.UUID;

public record TransferDto(
    @NotNull
    UUID sender,
    @DecimalMin("0.01")
    BigDecimal valueTransfer,
    @NotNull
    UUID received
) {
}
