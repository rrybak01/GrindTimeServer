package com.grindServer.grindServer.entrenamientosEjercicios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntrenamientosEjerciciosRepository extends JpaRepository<EntrenamientosEjercicios, Long>{
    
}