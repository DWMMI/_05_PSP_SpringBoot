package com.uem._05_springboot;

import com.uem._05_springboot.entidad.Persona;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

//Esta anotación hace 2 cosas funddamentales:
//1. busca dentro de este paquete y de sus subpaquetes anotaciones
//spring para gestionar
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
    //Esta sentencia arranca el contexto de spring y carga
    //los objetos que hayamos dado de alta
        ApplicationContext context = SpringApplication.run(Application.class, args);

        Persona p1 = new Persona();
        Persona p2 = (Persona)context.getBean("persona"); //se puede hacer casteando a Persona
        p2.setNombre("Manuel");

        Persona p3 = context.getBean("persona",Persona.class);
        System.out.println(p3.getNombre());

        p3 = context.getBean("persona2",Persona.class);
        System.out.println(p3.getNombre());
    }

    @Bean
    public Persona persona2(){
        Persona p = new Persona();
        p.setNombre("El bicho");
        return p;
    }

}
