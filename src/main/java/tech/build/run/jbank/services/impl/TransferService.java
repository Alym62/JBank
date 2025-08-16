package tech.build.run.jbank.services.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tech.build.run.jbank.controllers.dto.TransferDto;
import tech.build.run.jbank.domain.Transfer;
import tech.build.run.jbank.domain.Wallet;
import tech.build.run.jbank.exceptions.TransferException;
import tech.build.run.jbank.exceptions.WalletNotFoundException;
import tech.build.run.jbank.mappers.TransferMapper;
import tech.build.run.jbank.repositories.TransferRepository;
import tech.build.run.jbank.repositories.WalletRepository;
import tech.build.run.jbank.services.ITransferService;

import java.util.List;

@Service
public class TransferService implements ITransferService {
    private final TransferRepository repository;
    private final WalletRepository walletRepository;

    public TransferService(TransferRepository repository, WalletRepository walletRepository) {
        this.repository = repository;
        this.walletRepository = walletRepository;
    }

    @Override
    @Transactional
    public void transferMoney(TransferDto dto) {
        Wallet sender = walletRepository.findById(dto.sender())
                .orElseThrow(() -> new WalletNotFoundException("Carteira não encontrada em nossa base de dados - Devedor: " + dto.sender()));
        Wallet received = walletRepository.findById(dto.received())
                .orElseThrow(() -> new WalletNotFoundException("Carteira não encontrada em nossa base de dados - Cobrador: " + dto.received()));

        if (sender.getCurrentBalance().compareTo(dto.valueTransfer()) < 0) {
            throw new TransferException("Saldo insuficiente na carteira");
        }

        Transfer transfer = TransferMapper.dtoToDomain(dto);
        transfer.setWalletSender(sender);
        transfer.setWalletReceiver(received);

        repository.save(transfer);

        sender.setCurrentBalance(sender.getCurrentBalance().subtract(dto.valueTransfer()));
        received.setCurrentBalance(received.getCurrentBalance().add(dto.valueTransfer()));

        walletRepository.saveAll(List.of(sender, received));
    }
}
