package tech.build.run.jbank.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tech.build.run.jbank.constants.QueriesJbank;
import tech.build.run.jbank.domain.Wallet;
import tech.build.run.jbank.domain.projections.StatementView;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface WalletRepository extends JpaRepository<Wallet, UUID> {
    Optional<Wallet> findByEmailOrCpf(String cpf, String email);

    @Query(value = QueriesJbank.SQL_STATEMENT, countQuery = QueriesJbank.SQL_COUNT_STATEMENT, nativeQuery = true)
    Page<StatementView> findStatements(UUID walletId, PageRequest pageRequest);
}
