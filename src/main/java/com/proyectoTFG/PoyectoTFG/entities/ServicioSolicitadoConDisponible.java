package com.proyectoTFG.PoyectoTFG.entities;


public class ServicioSolicitadoConDisponible {
    
    private ServicioSolicitado serviciosSolicitados;
    private ServicioDisponible serviciosDisponibles;

    public ServicioSolicitadoConDisponible() {
    }

    public ServicioSolicitadoConDisponible(ServicioSolicitado serviciosSolicitados, ServicioDisponible serviciosDisponibles) {
        this.serviciosSolicitados = serviciosSolicitados;
        this.serviciosDisponibles = serviciosDisponibles;
    }


    public ServicioSolicitado getServiciosSolicitados() {
        return this.serviciosSolicitados;
    }

    public void setServiciosSolicitados(ServicioSolicitado serviciosSolicitados) {
        this.serviciosSolicitados = serviciosSolicitados;
    }

    public ServicioDisponible getServiciosDisponibles() {
        return this.serviciosDisponibles;
    }

    public void setServiciosDisponibles(ServicioDisponible serviciosDisponibles) {
        this.serviciosDisponibles = serviciosDisponibles;
    }

   
}
