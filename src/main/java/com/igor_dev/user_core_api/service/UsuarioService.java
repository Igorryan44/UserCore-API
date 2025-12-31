package com.igor_dev.user_core_api.service;

import com.igor_dev.user_core_api.model.Usuario;
import com.igor_dev.user_core_api.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<Usuario> fidnAllUsers() {
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> findUserById(Long id) {
        return usuarioRepository.findById(id);
    }

    public Usuario saveUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public void deleteUsuario(Long id) {
        usuarioRepository.deleteById(id);
        System.out.println("Usuario removido com sucesso!");
    }

    public  Usuario updateUsuario(Long id, Usuario usuario) {
            Usuario usuarioEntity = findUserById(id).orElseThrow(() -> new RuntimeException("Usuario nao encontrado"));
            Usuario usuarioUpdated = Usuario.builder()
                    .id(id)
                    .username(usuario.getUsername() != null ? usuario.getUsername() : usuarioEntity.getUsername())
                    .email(usuario.getEmail() != null ? usuario.getEmail() : usuarioEntity.getEmail())
                    .password(usuario.getPassword() != null ? usuario.getPassword() : usuarioEntity.getPassword())
                    .build();
            return usuarioRepository.save(usuarioUpdated);
    }
}
