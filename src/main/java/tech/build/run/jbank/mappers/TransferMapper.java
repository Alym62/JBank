package tech.build.run.jbank.mappers;

import tech.build.run.jbank.controllers.dto.TransferDto;
import tech.build.run.jbank.domain.Transfer;

import java.time.LocalDateTime;

public class TransferMapper {
    private TransferMapper() {
    }

    public static Transfer dtoToDomain(TransferDto dto) {
        Transfer transfer = new Transfer();
        transfer.setValueTransfer(dto.valueTransfer());
        transfer.setAccountCredit(dto.sender().toString());
        transfer.setAccountDeposit(dto.received().toString());
        transfer.setCurrentDateTransfer(LocalDateTime.now());

        return transfer;
    }
}
