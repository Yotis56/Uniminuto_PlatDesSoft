/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Singleton.java to edit this template
 */
package MVC;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
        
/**
 * Clase singleton para manejar la conexión a la base de datos
 * @author Yotis56
 */
public class mySQLdb {
    private static mySQLdb instance; // Singleton instance
    private Connection connection; // Database connection
    private final String url = "jdbc:mysql://localhost:3306/mvc"; // Database URL
    private final String username = "root"; // Database username
    private final String password = ""; // Database password
    
    private mySQLdb() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection(url, username, password);
        } catch(ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to connect to the database");
        }
    }
    
    public static mySQLdb getInstance() {
        synchronized (mySQLdb.class){
            if (instance == null) {
                instance = new mySQLdb();
            }
        }
        return instance;
    }
      
    public Connection connect (){
        return connection;
    }
}
