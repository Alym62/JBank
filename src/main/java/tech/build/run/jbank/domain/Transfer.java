package tech.build.run.jbank.domain;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "TB_TRANSFER")
public class Transfer {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "CODE_TRANSFER")
    private UUID codeTransfer;

    @Column(name = "ACCOUNT_DEPOSIT")
    private String accountDeposit;

    @Column(name = "ACCOUNT_CREDIT")
    private String accountCredit;

    @Column(name = "VALUE_TRANSFER")
    private BigDecimal valueTransfer;

    @Column(name = "CURRENTDATE_TRANSFER")
    private LocalDateTime currentDateTransfer;

    @ManyToOne
    @JoinColumn(name = "WALLET_RECEIVER_ID")
    private Wallet walletReceiver;

    @ManyToOne
    @JoinColumn(name = "WALLET_SENDER_ID")
    private Wallet walletSender;

    public UUID getCodeTransfer() {
        return codeTransfer;
    }

    public void setCodeTransfer(UUID codeTransfer) {
        this.codeTransfer = codeTransfer;
    }

    public BigDecimal getValueTransfer() {
        return valueTransfer;
    }

    public void setValueTransfer(BigDecimal valueTransfer) {
        this.valueTransfer = valueTransfer;
    }

    public LocalDateTime getCurrentDateTransfer() {
        return currentDateTransfer;
    }

    public void setCurrentDateTransfer(LocalDateTime currentDateTransfer) {
        this.currentDateTransfer = currentDateTransfer;
    }

    public String getAccountDeposit() {
        return accountDeposit;
    }

    public void setAccountDeposit(String accountDeposit) {
        this.accountDeposit = accountDeposit;
    }

    public String getAccountCredit() {
        return accountCredit;
    }

    public void setAccountCredit(String accountCredit) {
        this.accountCredit = accountCredit;
    }

    public Wallet getWalletReceiver() {
        return walletReceiver;
    }

    public void setWalletReceiver(Wallet walletReceiver) {
        this.walletReceiver = walletReceiver;
    }

    public Wallet getWalletSender() {
        return walletSender;
    }

    public void setWalletSender(Wallet walletSender) {
        this.walletSender = walletSender;
    }
}
