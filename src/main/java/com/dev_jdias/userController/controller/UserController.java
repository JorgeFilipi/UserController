package com.dev_jdias.userController.controller;

import com.dev_jdias.userController.user.User;
import com.dev_jdias.userController.user.UserRepository;
import com.dev_jdias.userController.user.dto.DadosCadastro;
import com.dev_jdias.userController.user.dto.DadosDetalhamentoUser;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController 
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/cadastrar")
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastro dados) {
        if (repository.existsByEmail(dados.email())) {
            return ResponseEntity.badRequest().body("Email já cadastrado");
        }
        
        var user = new User(dados);
        user.setPassword(passwordEncoder.encode(dados.password()));
        this.repository.save(user);
        return ResponseEntity.ok().body(new DadosDetalhamentoUser(user));
    }

    @GetMapping
    public ResponseEntity<Page<DadosDetalhamentoUser>> listar(@PageableDefault(size = 10, sort = {"email"}) Pageable paginacao) {
        var page = repository.findAll(paginacao).map(DadosDetalhamentoUser::new);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id) {
        var user = repository.findById(id);
        if (user.isPresent()) {
            return ResponseEntity.ok(new DadosDetalhamentoUser(user.get()));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deletar(@PathVariable Long id) {
        var user = repository.findById(id);
        if (user.isPresent()) {
            repository.delete(user.get());
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
