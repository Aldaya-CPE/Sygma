
package db;
import java.sql.*;
import javax.swing.JOptionPane;
import java.sql.Connection;


public class dbConnect {
     private static dbConnect instance;
    public static Connection c;
    public static Statement st;
    static{
        try{
            c=DriverManager.getConnection("jdbc:mysql://localhost:3306/Sygma", "root", "Aldaya@1234");
            st=c.createStatement();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
    }
}
    
    
      public static dbConnect getInstance() {
        if (instance == null) {
            instance = new dbConnect();
        }
        return instance;
    }

    public Connection getConnection() {
        return c;
    }

    public Statement getStatement() {
        return st;
    }
    public PreparedStatement prepareStatement(String sql) throws SQLException {
    return c.prepareStatement(sql);
}
}