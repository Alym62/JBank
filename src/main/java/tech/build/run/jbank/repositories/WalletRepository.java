package tech.build.run.jbank.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tech.build.run.jbank.domain.Wallet;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface WalletRepository extends JpaRepository<Wallet, UUID> {
    @Query("""
    select w from Wallet w where w.cpf = :cpf or w.email = :email
    """)
    Optional<Wallet> getByCpfOrEmail(@Param("cpf") String cpf, @Param("email") String email);
}
