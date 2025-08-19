package com.dev_jdias.userController.user.dto;

import com.dev_jdias.userController.user.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record DadosCadastro(
        @NotBlank(message = "Email é obrigatório")
        @Email(message = "Formato de email inválido")
        String email,
        @NotBlank(message = "Senha é obrigatória")
        @Size(min = 6, message = "Senha deve ter pelo menos 6 caracteres")
        String password,
        @NotNull(message = "Role é obrigatória")
        Role role) {
}
