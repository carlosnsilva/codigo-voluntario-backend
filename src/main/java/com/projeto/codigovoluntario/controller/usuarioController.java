package com.projeto.codigovoluntario.controller;

import com.projeto.codigovoluntario.model.Usuario;
import com.projeto.codigovoluntario.service.usuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class usuarioController {

    @Autowired
    private usuarioService userservice;

    @GetMapping("/user")
    public List<Usuario> getUser(){
        return this.userservice.getUser();
    }

    @GetMapping("/user/{id}")
    public Usuario getUserPorId(@PathVariable("id") Long id){
        return this.userservice.getUsuarioPorId(id);
    }

    @PostMapping("/user")
    public Usuario insertUser(@RequestBody Usuario usuario){
        return this.userservice.insertUser(usuario);
    }

    @PutMapping("/user/{id}")
    public Usuario updateUser(@PathVariable("id") Long id, @RequestBody Usuario usuario){
        return this.userservice.updateUser(id, usuario);
    }

    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable("id") Long id){
        this.userservice.deleteUser(id);
    }

}