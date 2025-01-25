package MVC;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
/**
 * Main Class of the MVC exercise with a CRUD. 
 * Made for Software Development Esp - Software Development Platforms course.
 * @author Yotis56
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        UserView vista = new UserView();
        UserController controller = new UserController(vista);
        controller.iniciar();
    }
    
}
