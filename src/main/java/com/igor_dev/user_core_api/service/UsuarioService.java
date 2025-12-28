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

    public Optional<Usuario> findById(Long id) {
        return usuarioRepository.findById(id);
    }

    public Usuario saveUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public void deleteUsuario(Long id) {
        usuarioRepository.deleteById(id);
        System.out.println("Usuario removido com sucesso!");
    }

    public  Usuario updateUsuario(Usuario usuario, Long id) {
            Usuario updateUser = usuarioRepository.findById(id).
                    orElseThrow(() -> new RuntimeException("Usuario com o id" + id + "não encontrado para atualização."));
            updateUser.setUsername(usuario.getUsername());
            updateUser.setEmail(usuario.getEmail());
            updateUser.setPassword(usuario.getPassword());
            return usuarioRepository.save(updateUser);
    }
}
