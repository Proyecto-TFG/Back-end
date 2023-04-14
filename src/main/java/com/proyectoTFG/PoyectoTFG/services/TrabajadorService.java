package com.proyectoTFG.PoyectoTFG.services;

import java.util.List;


import com.proyectoTFG.PoyectoTFG.entities.Trabajador;

public interface TrabajadorService {
    List<Trabajador> findAll();
    Trabajador findById(Integer id);
    Trabajador save(Trabajador trabajador);
    void deleteById(Integer id);

}
