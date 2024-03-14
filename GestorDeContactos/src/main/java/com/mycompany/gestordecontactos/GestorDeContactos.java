package com.mycompany.gestordecontactos;


import javax.swing.JOptionPane;

public class GestorDeContactos {

    public static void main(String[] args) {
        ListaContactos lista = new ListaContactos();
        //Variables
        int opcion;
        String nombre="";
        String telefono="";
        //Bucle principal
        try{
            do {
                opcion=Integer.parseInt(JOptionPane.showInputDialog("Menú:\n1. Agregar contacto\n2. Eliminar contacto\n3. Mostrar contactos\n4. Salir"));
                switch (opcion) {
                    case 1:
                        nombre=JOptionPane.showInputDialog("Ingrese el nombre del contacto:").toLowerCase();
                        do{
                            telefono=JOptionPane.showInputDialog("Ingrese el teléfono del contacto:","+57 ");
                            if (telefono.length()<7 ){
                                JOptionPane.showMessageDialog(null,"Numero demasiado corto","Error",JOptionPane.ERROR_MESSAGE);
                            }
                            if (telefono.length()>10){
                                JOptionPane.showMessageDialog(null,"Numero demasiado largo","Error",JOptionPane.ERROR_MESSAGE);
                            }
                        }while(telefono.length()<7 && telefono.length()>10);
                        lista.agregarContacto(nombre, telefono);
                        if (telefono.length()<7 && telefono.length()>10){
                            lista.eliminarContacto(nombre);
                        }
                    break;
                 case 2:
                        nombre = JOptionPane.showInputDialog("Ingrese el nombre del contacto a eliminar:").toLowerCase();
                        lista.eliminarContacto(nombre);
                        break;
                    case 3:
                        lista.mostrarContactos();
                        break;
                    case 4:
                        JOptionPane.showMessageDialog(null, "Saliendo del programa...","Saliendo...",JOptionPane.PLAIN_MESSAGE);
                        break;
                    default:
                        JOptionPane.showMessageDialog(null,"Opción inválida.","Error",JOptionPane.ERROR_MESSAGE);
                        break;
                }
            } while (opcion != 4);
          } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Se ha encontrado un Error en el programa","ERROR",JOptionPane.ERROR_MESSAGE);
            JOptionPane.showMessageDialog(null, "Cerrando el programa","ERROR",JOptionPane.ERROR_MESSAGE);
        }
    }
}
