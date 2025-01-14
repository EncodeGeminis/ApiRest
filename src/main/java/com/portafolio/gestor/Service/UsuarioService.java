package com.portafolio.gestor.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portafolio.gestor.Entity.Usuario;
import com.portafolio.gestor.Repository.UsuarioRepository;

@Service
public class UsuarioService {
    @Autowired
    UsuarioRepository usuarioRepository;

    //Metodo para crear un nuevo usuario 
    public Usuario crearUsuario (Usuario usuario){
        return usuarioRepository.save(usuario);
    }
    //Obtener todos los usuarios 
    public List<Usuario> listaUsuarios(){
        return usuarioRepository.findAll();
    }
    //Obtener un usuario por Id
    public Optional<Usuario> obtenerUsuarioPorId(Long id){
        return usuarioRepository.findById(id);
    }
    //Actualizar un usuario 
    public Usuario actualizarUsuario(Long id, Usuario usuarioActualizado){
        if(usuarioRepository.existsById(id)){
            usuarioActualizado.setId(id);
            return usuarioRepository.save(usuarioActualizado);
        } else{ return null; }
    }
    //Metodo para eliminar un usuario
    public void eliminarUsuario(Long id){
        usuarioRepository.deleteById(id);
    }
    //Metodo para buscar por nombre
    public List<Usuario> buscarUsuarioPorNombre(String nombre){
        return usuarioRepository.findByNombreContainingIgnoreCase(nombre);
    }
}
