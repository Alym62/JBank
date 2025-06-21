package tech.build.run.jbank.services;

import tech.build.run.jbank.controllers.dto.CreateWalletDto;
import tech.build.run.jbank.domain.Wallet;

public interface IWalletService {
    Wallet createWallet(CreateWalletDto dto);
}
