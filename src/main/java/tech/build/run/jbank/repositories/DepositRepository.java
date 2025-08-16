package tech.build.run.jbank.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.build.run.jbank.domain.Deposit;

import java.util.UUID;

@Repository
public interface DepositRepository extends JpaRepository<Deposit, UUID> {
}
