package tech.build.run.jbank.domain;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "TB_DEPOSIT")
public class Deposit {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "CODE_DEPOSIT")
    private UUID codeDeposit;

    @Column(name = "VALUE_DEPOSIT")
    private BigDecimal valueDeposit;

    @Column(name = "CURRENTDATE_DEPOSIT", updatable = false)
    @CreationTimestamp
    private LocalDateTime currentDateDeposit;

    @Column(name = "ADDRESS_IP")
    private String addressIp;

    @ManyToOne
    @JoinColumn(name = "WALLET_ID")
    private Wallet wallet;

    public UUID getCodeDeposit() {
        return codeDeposit;
    }

    public void setCodeDeposit(UUID codeDeposit) {
        this.codeDeposit = codeDeposit;
    }

    public BigDecimal getValueDeposit() {
        return valueDeposit;
    }

    public void setValueDeposit(BigDecimal valueDeposit) {
        this.valueDeposit = valueDeposit;
    }

    public LocalDateTime getCurrentDateDeposit() {
        return currentDateDeposit;
    }

    public void setCurrentDateDeposit(LocalDateTime currentDateDeposit) {
        this.currentDateDeposit = currentDateDeposit;
    }

    public String getAddressIp() {
        return addressIp;
    }

    public void setAddressIp(String addressIp) {
        this.addressIp = addressIp;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }
}
