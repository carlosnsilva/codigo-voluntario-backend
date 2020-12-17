package com.projeto.codigovoluntario.controller.repositorios;

import com.projeto.codigovoluntario.model.projetoUsuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface projetoUsuarioRepositorio extends JpaRepository<projetoUsuario, Long> {
}
