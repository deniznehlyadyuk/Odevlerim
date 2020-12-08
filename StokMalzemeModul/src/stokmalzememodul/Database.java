package stokmalzememodul;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Database {
    static private boolean DatabaseConnection = false;
    static private Connection conn = null;
    static private Statement statement = null;
    public static void Connect() {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/stoktakip", "root", "15251");
            if (conn != null) {
                statement = conn.createStatement();
                DatabaseConnection = true;
            }
        } catch(Exception e) {
        }
    }
    
    public static boolean IsConnected() {
        return DatabaseConnection;
    }
    
    public static void CloseConnection() {
        try {
            conn.close();
        } catch(Exception e) {
            
        }
    }
    
    public static void RunUpdateQuery(String query) {
        try {
            statement.executeUpdate(query);
        } catch(Exception e) {
            System.out.println(e);
        }
    }
    
    public static ResultSet RunSelectQuery(String query) {
        try {
            return statement.executeQuery(query);
        } catch(Exception e) {
            
        }
        return null;
    }
}
