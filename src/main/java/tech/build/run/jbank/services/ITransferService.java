package tech.build.run.jbank.services;

import tech.build.run.jbank.controllers.dto.TransferDto;

public interface ITransferService {
    void transferMoney(TransferDto dto);
}
