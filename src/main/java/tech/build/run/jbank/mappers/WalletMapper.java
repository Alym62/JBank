package tech.build.run.jbank.mappers;

import org.springframework.beans.BeanUtils;
import tech.build.run.jbank.controllers.dto.CreateWalletDto;
import tech.build.run.jbank.domain.Wallet;

import java.math.BigDecimal;

public class WalletMapper {
    private WalletMapper() {}

    public static Wallet dtoToDomain(CreateWalletDto dto) {
        Wallet wallet = new Wallet();
        wallet.setCurrentBalance(BigDecimal.valueOf(0));
        BeanUtils.copyProperties(dto, wallet, "currentBalance");

        return wallet;
    }
}
