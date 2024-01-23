package com.uem._05_springboot;

import com.uem._05_springboot.entidad.Cliente;
import com.uem._05_springboot.entidad.Persona;
import com.uem._05_springboot.persistencia.PersonaDao;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Optional;

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
        Persona p2 = (Persona)context.getBean("persona66"); //se puede hacer casteando a Persona
        p2.setNombre("Manuel");

        Persona p3 = context.getBean("persona66",Persona.class);
        System.out.println(p3.getNombre());

        p3 = context.getBean("persona2",Persona.class);
        System.out.println(p3.getNombre());
        p2 = null;
        p1 = null;

        p2 = (Persona)context.getBean("persona66");
        System.out.println(p2.getNombre());
        // Si es gestionado por spring, el objeto no se destruye hasta que se cierre el contexto de spring, aunque se deje de referenciar

        Cliente c1 = context.getBean("cliente",Cliente.class);
        System.out.println(c1.getEntidadBancaria().getNumeroCuenta());

        PersonaDao pDao = context.getBean(PersonaDao.class);
        pDao.save(p2);

        Optional<Persona> op = pDao.findById(1);
        if(op.isPresent()){
            System.out.println(op.get());
        }
    }

    @Bean
    public Persona persona2(){
        Persona p = new Persona();
        p.setNombre("El bicho");
        return p;
    }

    @Bean
    public Persona pepito(){
        Persona p = new Persona();
        p.setNombre("El bicho");
        return p;
    }

}
