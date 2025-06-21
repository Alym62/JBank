package tech.build.run.jbank.services.impl;

import org.springframework.stereotype.Service;
import tech.build.run.jbank.controllers.dto.CreateWalletDto;
import tech.build.run.jbank.domain.Wallet;
import tech.build.run.jbank.exceptions.WalletDataAlreadyException;
import tech.build.run.jbank.mappers.WalletMapper;
import tech.build.run.jbank.repositories.WalletRepository;
import tech.build.run.jbank.services.IWalletService;

import java.util.Optional;

@Service
public class WalletService implements IWalletService {
    private final WalletRepository repository;

    public WalletService(WalletRepository repository) {
        this.repository = repository;
    }

    @Override
    public Wallet createWallet(CreateWalletDto dto) {
        Optional<Wallet> walletExists = repository.getByCpfOrEmail(dto.cpf(), dto.email());
        if (walletExists.isPresent()) {
            throw new WalletDataAlreadyException("Esse CPF ou Email não estão disponíveis na nossa base de dados");
        }

        return repository.save(WalletMapper.dtoToDomain(dto));
    }
}
