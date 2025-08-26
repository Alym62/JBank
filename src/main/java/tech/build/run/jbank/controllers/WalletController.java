package tech.build.run.jbank.controllers;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.build.run.jbank.controllers.dto.CreateWalletDto;
import tech.build.run.jbank.controllers.dto.DepositDto;
import tech.build.run.jbank.controllers.dto.StatementDto;
import tech.build.run.jbank.domain.Wallet;
import tech.build.run.jbank.services.IWalletService;

import java.net.URI;
import java.util.List;
import java.util.UUID;

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

    @GetMapping("/list")
    public ResponseEntity<List<Wallet>> list() {
        List<Wallet> listWallet = service.getListWallet();
        return ResponseEntity.ok().body(listWallet);
    }

    @PostMapping("/create")
    public ResponseEntity<Void> create(@RequestBody @Valid CreateWalletDto dto) {
        Wallet walletSaved = service.createWallet(dto);
        return ResponseEntity.created(URI.create("/api/v1/wallets/" + walletSaved.getCodeWallet().toString())).build();
    }

    @DeleteMapping("/{walletId}")
    public ResponseEntity<Void> delete(@PathVariable UUID walletId) {
        boolean walletDeleted = service.deleteWallet(walletId);
        return walletDeleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

    @PostMapping("/{walletId}/deposits")
    public ResponseEntity<Void> deposit(@PathVariable UUID walletId, @RequestBody @Valid DepositDto dto, HttpServletRequest request) {
        service.depositInWallet(walletId, dto, request.getAttribute("x-user-ip").toString());
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{walletId}/statements")
    public ResponseEntity<Page<StatementDto>> getStatements(@PathVariable UUID walletId, @RequestParam Integer page,
                                                            @RequestParam Integer pageSize) {
        return ResponseEntity.ok().body(service.getStatements(walletId, page, pageSize));
    }
}
