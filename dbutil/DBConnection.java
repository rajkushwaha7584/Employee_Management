/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empmgmt.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author rj851
 */
public class DBConnection {
    private static Connection  conn;
    static {
        try {
             conn = DriverManager.getConnection("jdbc:oracle:thin:@//MyArea:1521/xe", "AdvjavaBatch2", "Rajk123#");
        } catch (SQLException ex) {
            System.out.println("Cannot connect to DB : "+ex.getMessage());
            System.exit(0);
        }
    } 
    public static Connection getConnection(){
        return conn;
    }
    public static void CloseConnection(){
        try {
            conn.close();
            System.out.println("Disconnected sucessfull !");
        } catch (SQLException ex) {
            System.out.println("Cannot disconnect to DB : "+ex.getMessage());
        }
    }
}
