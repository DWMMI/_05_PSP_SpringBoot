package com.uem._05_springboot.entidad;

import org.springframework.stereotype.Component;

/* Con la anotacion component se creará un objeto de tipo persona (y solo uno) en el contexto de spring,
cuyo nombre será "persona"
El ciclo de vida de este objeto, ya no lo llevarán el programador lo llevará Spring. Este concepto se llama inversion de control */
@Component (value = "persona66")
public class Persona {
    private int id;
    private String nombre;
    private int edad;

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    @Override
    public String toString() {
        return "Persona{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", edad=" + edad +
                '}';
    }
}
