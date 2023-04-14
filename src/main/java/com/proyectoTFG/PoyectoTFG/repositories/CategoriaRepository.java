package com.proyectoTFG.PoyectoTFG.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;

import com.proyectoTFG.PoyectoTFG.entities.Categoria;

//@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer>{
    
}
