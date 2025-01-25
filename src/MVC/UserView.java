/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MVC;

import java.util.Scanner;

/**
 * View for the class User, of the MVC exercise with a CRUD.
 * Made for Software Development Esp - Software Development Platforms course.
 * @author Yotis56
 */
public class UserView {
    private final Scanner scanner = new Scanner(System.in);

    public int mostrarMenu(String[] opciones, String title, boolean endMenu) {
        System.out.println(title);
        for (int i = 0; i < opciones.length; i++){
            System.out.println( i + 1 + ". " +  opciones[i]);
        }
        if (endMenu) {
            System.out.println(opciones.length + 1 + ". Salir");
        }
        return leerInt("Seleccione una opción: ");
    }

    public String leerString(String mensaje) {
        String input;
        do {
            System.out.print(mensaje);
            input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("El campo no puede estar vacío. Intente nuevamente.");
            }
        } while (input.isEmpty());
        return input;
    }

    public int leerInt(String mensaje) {
        int numero;
        while (true) {
            try {
                System.out.print(mensaje);
                String input = scanner.nextLine().trim();
                numero = Integer.parseInt(input);

                // Validar que la edad sea positiva
                if (numero <= 0) {
                    System.out.println("La edad debe ser un número positivo. Intente nuevamente.");
                } else {
                    break;  // Salir del bucle si la edad es v�lida
                }
            } catch (NumberFormatException e) {
                System.out.println("Debe ingresar un número válido. Intente nuevamente.");
            }
        }
        return numero;
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}
