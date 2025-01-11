package com.portafolio.gestor.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.portafolio.gestor.Entity.Tarea;

@Repository
public interface TareaRepository extends JpaRepository<Tarea,Long> {}
