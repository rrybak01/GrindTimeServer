package com.grindServer.grindServer.entrenamiento;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EntrenamientoRepository extends JpaRepository<Entrenamiento, Long>{

    @Query(value = "select e from Entrenamiento e")
    public List<Entrenamiento> findAll();
    
}

