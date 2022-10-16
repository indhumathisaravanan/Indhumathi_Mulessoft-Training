package net.sqlitetutorial;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class SelectApp all {

    
    private Connection connect() {
        
        String url = "jdbc:sqlite:C://sqlite/db/test.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    
    
    public void selectAll(){
        String sql = "SELECT name,actor,actress,director,year_of_release FROM movies";
        
        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            
            
            while (rs.next()) {
                System.out.println( 
                                   rs.getString("name") + "\t" +
				   rs.getString("actor") + "\t" +
				   rs.getString("actress") + "\t" +
				   rs.getString("director") + "\t" +
                                   rs.getInt("year_of_release"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
   
    
    public static void main(String[] args) {
        SelectApp app = new SelectApp();
        app.selectAll();
    }

}