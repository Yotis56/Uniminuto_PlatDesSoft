/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MVC;

import java.sql.ResultSet;

/**
 * Controller for the class User, of the MVC exercise with a CRUD.
 * Made for Software Development Esp - Software Development Platforms course.
 * @author Yotis56
 */
public class UserController {
    private final UserView vista;
    private final UserModel modelo;
    
    public UserController (UserView vista) {
        this.vista = vista;
        this.modelo = new UserModel();
    }
    
    public void iniciar () {
        System.out.println("Entré al método iniciar");
        int option;
        String[] menuInicial = {
            "Imprimir todos los usuarios", 
            "Imprimir un usuario", 
            "Crear un usuario",
            "Editar un usuario",
            "Eliminar un usuario"
        };
        do {
            option = this.vista.mostrarMenu(menuInicial, "\n--- Menú ---", true);
            switch (option) {
                case 1:
                    this.imprimirUsuarios();
                    break;
                case 2:
                    this.imprimirUsuarioPorId();
                    break;
                case 3:
                    this.crearUsuario();
                    break;
                case 4:
                    this.editarUsuario();
                    break;
                case 5:
                    this.eliminarUsuario();
                    break;
            }
        } while (option != menuInicial.length + 1);

    }
    private void imprimirUsuarios() {
        try {
            ResultSet usuarios = this.modelo.getUsers();
            while (usuarios.next()) {
                int id = usuarios.getInt("id");
                String name = usuarios.getString("name");
                String email = usuarios.getString("mail");
                int phone = usuarios.getInt("phone");
                this.vista.mostrarMensaje("ID: " + id + ", Name: " + name + ", Email: " + email + ", Phone: " + phone);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void imprimirUsuarioPorId() {
        this.vista.mostrarMensaje("Imprimir usuario por Id");
    }
    
    private void crearUsuario() {
        String name = this.vista.leerString("Ingrese el Nombre del usuario: ");
        String email = this.vista.leerString("Ingrese el Email del usuario: ");
        int phone = this.vista.leerInt("Ingrese el Teléfono del usuario: ");
        try {
            boolean result = this.modelo.createUser(name, email, phone);
            if (result) {
                this.vista.mostrarMensaje("Usuario creado exitosamente");
            } else {
                this.vista.mostrarMensaje("Error al crear el usuario");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void editarUsuario() {
        int id = this.vista.leerInt("Ingrese el id del usuario que desea editar: ");
        String[] opciones = {"Editar nombre", "Editar email", "Editar teléfono"};
        int opcion = this.vista.mostrarMenu(opciones, "Digite el número de la característica a editar", false);
        Object newValue;
        if (opcion == 3) {
            newValue = this.vista.leerInt("Ingrese el nuevo número: ");
        } else {
            newValue = this.vista.leerString("Ingrese el nuevo valor: ");
        }
        String field = opcion == 1 ? "name" : opcion == 2 ? "mail" : "phone";
        try {
            boolean result = this.modelo.updateUser(id, field, newValue);
            if (result) {
                this.vista.mostrarMensaje("Usuario editado exitosamente");
            } else {
                this.vista.mostrarMensaje("Error al editar el usuario");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    private void eliminarUsuario() {
        int id = this.vista.leerInt("Ingrese el id del usuario que desea eliminar: ");
        try {
            boolean result = this.modelo.deleteUser(id);
            if (result) {
                this.vista.mostrarMensaje("Usuario eliminado exitosamente");
            } else {
                this.vista.mostrarMensaje("Error al eliminar el usuario");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
}
