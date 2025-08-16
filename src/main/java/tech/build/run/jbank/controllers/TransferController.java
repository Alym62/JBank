package tech.build.run.jbank.controllers;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.build.run.jbank.controllers.dto.TransferDto;
import tech.build.run.jbank.services.ITransferService;

@RestController
@RequestMapping("api/v1/transfers")
public class TransferController {
    private final ITransferService service;

    public TransferController(ITransferService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Void> transfer(@RequestBody @Valid TransferDto dto) {
        service.transferMoney(dto);
        return ResponseEntity.noContent().build();
    }
}
