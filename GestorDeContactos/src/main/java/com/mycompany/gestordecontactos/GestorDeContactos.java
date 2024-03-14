package com.mycompany.gestordecontactos;


import javax.swing.JOptionPane;

public class GestorDeContactos {

    public static void main(String[] args) {
        ListaContactos lista = new ListaContactos();
        //Variables
        int opcion;
        String nombre;
        String telefono;
        do {
            opcion=Integer.parseInt(JOptionPane.showInputDialog("Menú:\n1. Agregar contacto\n2. Eliminar contacto\n3. Mostrar contactos\n4. Salir"));
            
            switch (opcion) {
                case 1:
                    nombre=JOptionPane.showInputDialog("Ingrese el nombre del contacto:");
                    telefono=JOptionPane.showInputDialog("Ingrese el teléfono del contacto:");
                    lista.agregarContacto(nombre, telefono);
                    break;
                case 2:
                    nombre = JOptionPane.showInputDialog("Ingrese el nombre del contacto a eliminar:");
                    lista.eliminarContacto(nombre);
                    break;
                case 3:
                    lista.mostrarContactos();
                    break;
                case 4:
                    JOptionPane.showMessageDialog(null, "Saliendo del programa...");
                    break;
                default:
                    JOptionPane.showMessageDialog(null,"Opción inválida.");
                    break;
            }
        } while (opcion != 4);
    }
}
