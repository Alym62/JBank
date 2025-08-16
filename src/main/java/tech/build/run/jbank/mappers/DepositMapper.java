package tech.build.run.jbank.mappers;

import tech.build.run.jbank.controllers.dto.DepositDto;
import tech.build.run.jbank.domain.Deposit;

import java.time.LocalDateTime;

public class DepositMapper {
    private DepositMapper() {}

    public static Deposit dtoToDomain(DepositDto dto) {
        Deposit deposit = new Deposit();
        deposit.setValueDeposit(dto.value());
        deposit.setCurrentDateDeposit(LocalDateTime.now());

        return deposit;
    }
}
