package tech.build.run.jbank.domain;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "TB_WALLET")
public class Wallet {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "CODE_WALLET")
    private UUID codeWallet;

    @Column(name = "CPF", unique = true, updatable = false)
    private String cpf;

    @Column(name = "EMAIL", unique = true)
    private String email;

    @Column(name = "NAME")
    private String name;

    @Column(name = "CURRENT_BALANCE")
    private BigDecimal currentBalance;

    public UUID getCodeWallet() {
        return codeWallet;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getCurrentBalance() {
        return currentBalance;
    }

    public void setCodeWallet(UUID codeWallet) {
        this.codeWallet = codeWallet;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCurrentBalance(BigDecimal currentBalance) {
        this.currentBalance = currentBalance;
    }
}
