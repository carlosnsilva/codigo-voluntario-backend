package com.projeto.codigovoluntario.usuarioUtil;

import com.projeto.codigovoluntario.model.Usuario;
import com.projeto.codigovoluntario.service.usuarioService;

import java.util.List;

public class validaUser {
    private usuarioService userService;

    public Usuario userIsValid(Usuario user){
        List<Usuario> usuarios;

        usuarios = this.userService.getUser();
        if (usuarios == null){
            this.userService.insertUser(user);
            return this.userService.getUser().get(0);
        }
        else{
            return this.userService.getUser().get(0);
        }
    };
}
