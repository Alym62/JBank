package tech.build.run.jbank.controllers.dto;

public record StatementDto(
        WalletDto wallet,
        StatementItemDto statement
) {
}
