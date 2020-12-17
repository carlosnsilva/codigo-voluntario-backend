package com.projeto.codigovoluntario.service;

import com.projeto.codigovoluntario.controller.repositorios.projetoRepositorio;
import com.projeto.codigovoluntario.model.Projetos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class projetosService {

    @Autowired
    private projetoRepositorio projectRepository;

    public List<Projetos> getProjects(){
        return this.projectRepository.findAll();
    }

    public Projetos getProjectPorId(Long idProject){
        return this.projectRepository.findById(idProject).orElse(null);
    }

    public Projetos insertProject(Projetos projeto){
        return this.projectRepository.save(projeto);
    }

    /*
    public Projetos updateProject(Long id, Projetos project){
        return projectRepository.findById(id)
                .map(body -> {
                    body.setDescricao(project.getDescricao());
                    body.setTecnologias(project.getTecnologias());
                    body.setUrl(project.getUrl());

                    Projetos p = projectRepository.save(body);
                    return p;
                }).orElse(null);
        // esse método apaga os dados anteriores, deixando tudo null
    }

     */



    public Projetos updateProject(Long id, Projetos project){
        return projectRepository.findById(id)
                .map(body -> {
                    Projetos projetoAntigo = projectRepository.findById(id).orElse(null);
                    if(project.getName() == null){
                        project.setName(projetoAntigo.getName());

                    }
                    if(project.getDescription() == null){
                        project.setDescription(projetoAntigo.getDescription());

                    }
                    if(project.getTags() == null){
                        project.setTags(projetoAntigo.getTags());

                    }
                    if(project.getUrl() == null){
                        project.setUrl(projetoAntigo.getUrl());
                    }

                    body.setName(project.getName());
                    body.setDescription(project.getDescription());
                    body.setTags(project.getTags());
                    body.setUrl(project.getUrl());

                    Projetos p = projectRepository.save(body);
                    return p;
                }).orElse(null);
    }
    //Esse método faz uma tratativa para não apagar os registros antigos, mas está estourando null point exception



    public void deleteProject(Long idProject){
        this.projectRepository.deleteById(idProject);

    }
}
