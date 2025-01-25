/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MVC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Model for the class User, of the MVC exercise with a CRUD. 
 * Made for Software Development Esp - Software Development Platforms course.
 * @author Yotis56
 */
public class UserModel {
  private mySQLdb db;
  private Connection connection;

    public UserModel() {
      this.db = mySQLdb.getInstance(); 
      this.connection = db.connect(); 
    }

    public ResultSet getUsers(){
      try {
        Statement statement = connection.createStatement();
        String query = "SELECT * FROM users";
        ResultSet result = statement.executeQuery(query);
        return result;
      } catch (Exception e){
        e.printStackTrace();
        return null;
      }
    }

    public ResultSet getUserById(int id){
      try {
        Statement statement = connection.createStatement();
        String query = "SELECT * FROM users WHERE id = " + id;
        ResultSet result = statement.executeQuery(query);
        return result;
      } catch (Exception e){
        e.printStackTrace();
        return null;
      }
    }
    public boolean createUser(String name, String mail, int phone){
      try {
        Statement statement = connection.createStatement();
        String query = "INSERT INTO users (name, mail, phone) VALUES ('" + name + "', '" + mail + "' , " + phone + ")";
        statement.executeUpdate(query);
        return true;
      } catch (Exception e){
        e.printStackTrace();
        return false;
      }
    }
    public boolean updateUser(int id, String field, Object newValue){
      try {
        Statement statement = connection.createStatement();
        String query = "UPDATE users SET " + field + " = '" + newValue + "' WHERE id = " + id;
        statement.executeUpdate(query);
        return true;
      } catch (Exception e){
        e.printStackTrace();
        return false;
      }
    }
  

    public boolean deleteUser(int id){
      try {
        Statement statement = connection.createStatement();
        String query = "DELETE FROM users WHERE id = " + id;
        statement.executeUpdate(query);
        return true;
      } catch (Exception e){
        e.printStackTrace();
        return false;
      }
    }
}
