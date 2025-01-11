package com.portafolio.gestor.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portafolio.gestor.Entity.Tarea;
import com.portafolio.gestor.Repository.TareaRepository;
@Service
public class TareaService {
    @Autowired
    TareaRepository tareaRepository;

    public List<Tarea> obtenerListaTareas(){
        return tareaRepository.findAll();
    }
    public Optional<Tarea> obtenerPorId(Long id){
        return tareaRepository.findById(id);
    }
    public Tarea guardar(Tarea tarea){
        return tareaRepository.save(tarea);
    }
    public void eliminarTarea(Long id){
        tareaRepository.deleteById(id);
    }

}
