package tech.build.run.jbank.controllers;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.build.run.jbank.controllers.dto.CreateWalletDto;
import tech.build.run.jbank.domain.Wallet;
import tech.build.run.jbank.services.IWalletService;

import java.net.URI;

@RestController
@RequestMapping("api/v1/wallets")
public class WalletController {
    private final IWalletService service;

    public WalletController(IWalletService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<String> health() {
        return ResponseEntity.ok().body("OK!");
    }

    @PostMapping("/create")
    public ResponseEntity<Void> create(@RequestBody @Valid CreateWalletDto dto) {
        Wallet walletSaved = service.createWallet(dto);
        return ResponseEntity.created(URI.create("/api/v1/wallets/" + walletSaved.getCodeWallet().toString())).build();
    }
}
