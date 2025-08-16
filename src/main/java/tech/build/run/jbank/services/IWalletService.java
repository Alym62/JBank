package tech.build.run.jbank.services;

import tech.build.run.jbank.controllers.dto.CreateWalletDto;
import tech.build.run.jbank.controllers.dto.DepositDto;
import tech.build.run.jbank.domain.Wallet;

import java.util.List;
import java.util.UUID;

public interface IWalletService {
    Wallet createWallet(CreateWalletDto dto);

    boolean deleteWallet(UUID walletId);

    List<Wallet> getListWallet();

    void depositInWallet(UUID walletId, DepositDto dto, String ipAddress);
}
