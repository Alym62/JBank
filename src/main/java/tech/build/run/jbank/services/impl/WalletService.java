package tech.build.run.jbank.services.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tech.build.run.jbank.controllers.dto.CreateWalletDto;
import tech.build.run.jbank.controllers.dto.DepositDto;
import tech.build.run.jbank.domain.Deposit;
import tech.build.run.jbank.domain.Wallet;
import tech.build.run.jbank.exceptions.DeleteWalletException;
import tech.build.run.jbank.exceptions.WalletDataAlreadyException;
import tech.build.run.jbank.exceptions.WalletNotFoundException;
import tech.build.run.jbank.mappers.DepositMapper;
import tech.build.run.jbank.mappers.WalletMapper;
import tech.build.run.jbank.repositories.DepositRepository;
import tech.build.run.jbank.repositories.WalletRepository;
import tech.build.run.jbank.services.IWalletService;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class WalletService implements IWalletService {
    private final WalletRepository repository;
    private final DepositRepository depositRepository;

    public WalletService(WalletRepository repository, DepositRepository depositRepository) {
        this.repository = repository;
        this.depositRepository = depositRepository;
    }

    @Override
    public Wallet createWallet(CreateWalletDto dto) {
        Optional<Wallet> walletExists = repository.getByCpfOrEmail(dto.cpf(), dto.email());
        if (walletExists.isPresent()) {
            throw new WalletDataAlreadyException("Esse CPF ou Email não estão disponíveis na nossa base de dados");
        }

        return repository.save(WalletMapper.dtoToDomain(dto));
    }

    @Override
    public boolean deleteWallet(UUID walletId) {
        Optional<Wallet> walletExists = repository.findById(walletId);
        if (walletExists.isPresent()) {
            if (walletExists.get().getCurrentBalance().compareTo(BigDecimal.ZERO) != 0) {
                throw new DeleteWalletException("O saldo da sua conta bancária");
            }

            repository.deleteById(walletId);
        }

        return walletExists.isPresent();
    }

    @Override
    public List<Wallet> getListWallet() {
        return repository.findAll();
    }

    @Transactional
    @Override
    public void depositInWallet(UUID walletId, DepositDto dto, String ipAddress) {
        Wallet wallet = repository.findById(walletId)
                .orElseThrow(() -> new WalletNotFoundException("Carteira não encontrada em nossa base de dados"));

        Deposit deposit = DepositMapper.dtoToDomain(dto);
        deposit.setWallet(wallet);
        deposit.setAddressIp(ipAddress);

        depositRepository.save(deposit);

        wallet.setCurrentBalance(wallet.getCurrentBalance().add(dto.value()));

        repository.save(wallet);
    }
}
