package tech.build.run.jbank.mappers;

import tech.build.run.jbank.controllers.dto.StatementDto;
import tech.build.run.jbank.controllers.dto.StatementItemDto;
import tech.build.run.jbank.controllers.dto.WalletDto;
import tech.build.run.jbank.domain.Wallet;
import tech.build.run.jbank.domain.enums.StatementOperation;
import tech.build.run.jbank.domain.projections.StatementView;
import tech.build.run.jbank.exceptions.StatementException;

public class StatementMapper {
    private StatementMapper() {}

    public static StatementDto toDto(StatementView projection, Wallet wallet) {
        return new StatementDto(
               mapToWalletDto(wallet),
               mapToItemStatementDto(projection)
        );
    }

    private static WalletDto mapToWalletDto(Wallet wallet) {
        return new WalletDto(
                wallet.getCodeWallet(),
                wallet.getCpf(),
                wallet.getName(),
                wallet.getEmail(),
                wallet.getCurrentBalance()
        );
    }

    private static StatementItemDto mapToItemStatementDto(StatementView projection) {
        return switch (projection.getType()) {
            case "deposit" -> new StatementItemDto(
                    projection.getStatementId(),
                    projection.getType(),
                    "Dinheiro depositado!",
                    projection.getStatementValue(),
                    projection.getStatementDateTime(),
                    StatementOperation.CREDIT
            );
            case "transfer" -> new StatementItemDto(
                    projection.getStatementId(),
                    projection.getType(),
                    "Dinheiro transferido!",
                    projection.getStatementValue(),
                    projection.getStatementDateTime(),
                    StatementOperation.DEBIT
            );
            default -> throw new StatementException("");
        };
    }
}
