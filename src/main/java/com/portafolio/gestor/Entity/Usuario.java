package com.portafolio.gestor.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import jakarta.persistence.GenerationType;


@Entity
public class Usuario {

    @Id
    @GeneratedValue (strategy =  GenerationType.IDENTITY)
    private Long id;
    
    @NotNull
    @Size(min = 2, max =100)
    private String nombre;

    @Min(18)
    private int edad;

    @Email
    private String correo;
    
    @Pattern(regexp = "^[0-9]{10}$")
    private String telefono;

    
    public Usuario() {
    }

    public Usuario(@NotNull @Size(min = 2, max = 100) String nombre, @Min(18) int edad, @Email String correo,
            @Pattern(regexp = "^[0-9]{10}$") String telefono) {
        this.nombre = nombre;
        this.edad = edad;
        this.correo = correo;
        this.telefono = telefono;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    

}
