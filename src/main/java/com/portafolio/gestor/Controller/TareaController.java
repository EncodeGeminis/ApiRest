package com.portafolio.gestor.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portafolio.gestor.Entity.Tarea;
import com.portafolio.gestor.Service.TareaService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("api/tareas")
public class TareaController {
    @Autowired
    private TareaService tareaService;

    //metodo que muestra la lista de todas las tareas
    @GetMapping
    public List<Tarea> ListaTareas() {
        return tareaService.obtenerListaTareas();
    }
    //metodo para obtener el id 
    @GetMapping("/{id}")
    public ResponseEntity<Tarea> obtenerTareaPorId(@PathVariable Long id) {
        return tareaService.obtenerPorId(id)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
    }
    @PostMapping
    public Tarea crearTarea(@RequestBody Tarea tarea) {
        return tareaService.guardar(tarea);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Tarea> actualizarTarea(@PathVariable Long id, @RequestBody Tarea tarea) {
        return tareaService.obtenerPorId(id)
        .map (t ->{
            t.setTitulo(tarea.getTitulo());
            t.setDescripcion(tarea.getDescripcion());
            t.setCompletada(tarea.isCompletada());
            return ResponseEntity.ok(tareaService.guardar(t));
        }).orElse(ResponseEntity.notFound().build());

    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarTarea(@PathVariable Long id){
        if(tareaService.obtenerPorId(id).isPresent()){
            tareaService.eliminarTarea(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
