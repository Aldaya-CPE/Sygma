package Sygma.Database;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.SQLException;


public class Database {
    
         private static Database instance;
    private Connection connection;
    public static Statement st;
    public static Database getInstance(){
        if (instance==null) {
            instance = new Database();
        }
        return instance;
    }
        private Database(){
        
    }
    
     public void ConnectToDatabase() throws  SQLException, ClassNotFoundException{
        String server = "127.0.0.1";
//        String server = "192.168.60.111";

        String port = "3306";
        String database = "sygma";
//        String user = "Sygma";
        String user = "root";

        String password = "Aldaya@1234";

        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = (Connection) java.sql.DriverManager.getConnection("jdbc:mysql://"+server+":"+port+"/"+database,user,password);
          st=connection.createStatement();
     }
    public Connection getConnection() {
        return connection;
    }
}




