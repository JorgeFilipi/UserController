package com.dev_jdias.userController.user.dto;

import com.dev_jdias.userController.user.User;

public record DadosDetalhamentoUser(Long id,
                                    String email,
                                    String role) {

    public DadosDetalhamentoUser(User user) {
        this(user.getId(),
                user.getEmail(),
                user.getRole().getRole());
    }
}
