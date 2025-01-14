package com.portafolio.gestor.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portafolio.gestor.Entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    //Metodo para buscar usuario por nombre 
    List<Usuario> findByNombreContainingIgnoreCase(String nombre);
}
