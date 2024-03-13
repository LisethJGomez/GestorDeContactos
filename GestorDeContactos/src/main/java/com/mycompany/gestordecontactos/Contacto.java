package com.mycompany.gestordecontactos;

class Contacto {
    String nombre;
    String telefono;
    Contacto siguiente;

    public Contacto(String nombre, String telefono) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.siguiente = null;
    }    
}