package com.proyectoTFG.PoyectoTFG.repositories;

import org.springframework.data.jpa.repository.JpaRepository;


import com.proyectoTFG.PoyectoTFG.entities.Producto;


public interface ProductoRepository extends JpaRepository<Producto, Long>{
    
}
