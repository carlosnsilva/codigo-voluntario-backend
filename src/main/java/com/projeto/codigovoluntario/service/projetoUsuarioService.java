package com.projeto.codigovoluntario.service;


import com.projeto.codigovoluntario.controller.repositorios.projetoUsuarioRepositorio;
import com.projeto.codigovoluntario.model.projetoUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class projetoUsuarioService {

    @Autowired
    private projetoUsuarioRepositorio projectUserRepository;

    public List<projetoUsuario> getProjectUser(){
        return this.projectUserRepository.findAll();
    }

    public projetoUsuario getProjectUserPorId(Long idProjectUser){
        return this.projectUserRepository.findById(idProjectUser).orElse(null);
    }

    public projetoUsuario insertProjectUser(projetoUsuario projectUser){
        return this.projectUserRepository.save(projectUser);
    }

    public projetoUsuario updateProjectUser(Long id, projetoUsuario projectUser){
        return projectUserRepository.findById(id)
                .map(body -> {
                    projetoUsuario projetoUsuarioAntigo = projectUserRepository.findById(id).orElse(null);

                    if(projectUser.getProject_id() == null){
                        projectUser.setProject_id(projetoUsuarioAntigo.getProject_id());
                    }
                    if(projectUser.getStars() == null){
                        projectUser.setStars(projetoUsuarioAntigo.getStars());
                    }
                    if(projectUser.getUser_id() == null){
                        projectUser.setUser_id(projetoUsuarioAntigo.getUser_id());
                    }

                    body.setProject_id(projectUser.getProject_id());
                    body.setUser_id(projectUser.getUser_id());
                    body.setStars(projectUser.getStars());

                    projetoUsuario pu = projectUserRepository.save(body);
                    return pu;
                }).orElse(null);
    }

}
