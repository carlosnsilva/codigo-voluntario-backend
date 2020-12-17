package com.projeto.codigovoluntario.service;

import com.projeto.codigovoluntario.controller.repositorios.usuarioRepositorio;
import com.projeto.codigovoluntario.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class usuarioService {

    @Autowired

    private usuarioRepositorio userRepository;

    public List<Usuario> getUser() {
        return this.userRepository.findAll();
    }

    public Usuario getUsuarioPorId(Long idUsuario) {
        return this.userRepository.findById(idUsuario).orElse(null);
    }

    public Usuario insertUser(Usuario user) {
        return this.userRepository.save(user);
    }

    public Usuario updateUser(Long idUser, Usuario user) {

        return userRepository.findById(idUser)
                .map(body -> {
                    Usuario usuarioAntigo = userRepository.findById(idUser).orElse(null);

                    if (user.getEmail() == null) {
                        user.setEmail(usuarioAntigo.getEmail());
                    }
                    if (user.getPassword() == null) {
                        user.setPassword(usuarioAntigo.getPassword());
                    }

                    body.setPassword(user.getPassword());
                    body.setEmail(user.getEmail());

                    Usuario u = userRepository.save(body);
                    return u;
                }).orElse(null);

    }

    public void deleteUser(Long idUser) {
        this.userRepository.deleteById(idUser);
    }
}
