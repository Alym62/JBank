package tech.build.run.jbank.controllers.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CPF;

public record CreateWalletDto(
        @CPF(message = "CPF inválido")
        @NotBlank(message = "O campo 'CPF' é obrigatório")
        String cpf,
        @Email(message = "Email inválido")
        @NotBlank(message = "O campo 'email' é obrigatório")
        String email,
        @NotBlank(message = "O campo 'nome' é obrigatório")
        String name
) {
}
