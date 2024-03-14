package com.mycompany.gestordecontactos;

import javax.swing.JOptionPane;

/**@author lihan*/

public class ListaContactos {
    //Objetos
    Contacto primero;

    //Constructor
    public ListaContactos() {
        this.primero = null;
    }

    //Métodos
    public void agregarContacto(String nombre, String telefono) {
        Contacto nuevoContacto = new Contacto(nombre, telefono);
        if (primero == null) {// null -> [primero == null] -> null
            primero = nuevoContacto;// null -> [nuevoContacto] -> null
         } else {
            /*
                null -> [a] ... [z] -> null
                Este bloque de codigo se encarga de añadir un Contacto
                en la posición que le corresponda alfabeticamente
            */
            Contacto temp = primero;
            Contacto previo = null;
            while (temp != null && nombre.compareToIgnoreCase(temp.nombre) > 0) {
                previo = temp;
                temp = temp.siguiente;
            }
            if (previo == null) {
                nuevoContacto.siguiente = primero;
                primero = nuevoContacto;
            } else {
                previo.siguiente = nuevoContacto;
                nuevoContacto.siguiente = temp;
            }
        }
    }
        JOptionPane.showMessageDialog(null, "Contacto agregado: " + nombre);
    }

     public void eliminarContacto(String nombre) {
        if (primero == null) {// null -> [primero == null] -> null
            JOptionPane.showMessageDialog(null, "La lista de contactos está vacía.");
            return;
        }

        if (primero.nombre.equals(nombre)) {//null -> [primero = nombreIngresado] -> ... ->null
            primero = primero.siguiente;
            JOptionPane.showMessageDialog(null, "Contacto eliminado: " + nombre);
            return;
        }

        Contacto temp = primero;
        //Recorre la lista hasta que encuentra el elemento con el nombreIngresado y lo almacena en temp
        while (temp.siguiente != null && !temp.siguiente.nombre.equals(nombre)) {
            temp = temp.siguiente;
        }
        
        //Elimina el contacto
        if (temp.siguiente != null) {
            temp.siguiente = temp.siguiente.siguiente;
            JOptionPane.showMessageDialog(null, "Contacto eliminado: " + nombre);
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró el contacto: " + nombre);
        }
    }

    public void mostrarContactos() {
        if (primero == null) {
            JOptionPane.showMessageDialog(null, "La lista de contactos está vacía.");
            return;
        }
        StringBuilder mensaje = new StringBuilder("Lista de contactos:\n");
        Contacto temp = primero;
        while (temp != null) {
            mensaje.append("Nombre: ").append(temp.nombre).append(", Teléfono: ").append(temp.telefono).append("\n");
            temp = temp.siguiente;
        }
        JOptionPane.showMessageDialog(null, mensaje.toString());
    }
}
