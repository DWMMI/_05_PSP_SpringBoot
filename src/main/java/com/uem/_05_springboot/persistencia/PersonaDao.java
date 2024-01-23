package com.uem._05_springboot.persistencia;

import com.uem._05_springboot.entidad.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaDao extends JpaRepository<Persona, Integer>{

}
