/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ph.database.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import ph.database.model.formModel;
/**
 *
 * @author Xander
 */


public class formDao {

    
public ArrayList<formModel> getFormList() {
    ArrayList<formModel> productList = new ArrayList<>();  
    Connection conn  = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    String query = "select * from formdatabase";
    try {
        conn = ConnectionPool.getConnection();
        ps = conn.prepareStatement(query);
        rs = ps.executeQuery();
        while (rs.next()) {
            formModel form = new formModel(
                rs.getString("username"),
                rs.getString("email"),
                rs.getString("password")
            );
            productList.add(form);
        }

        conn.close();
    } catch (SQLException e) {
        System.out.println("getProductList Error: " + e); 
    } finally {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                //ignore
            }
        }
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                //ignore
            }
        }
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                //ignore
            }
        }
        
    }
    
    return productList;
}

   

public formModel getFormDetails(String username) {
    formModel formDetails = null;
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    String query = "SELECT username, email, password FROM formdatabase WHERE username = ?";
    try {
        conn = ConnectionPool.getConnection();
        ps = conn.prepareStatement(query);
        ps.setString(1, username);
        System.out.println("Executing SQL Query: " + ps.toString()); // Debugging output
        
        rs = ps.executeQuery();
        if (rs.next()) {
            String email = rs.getString("email");
            String password = rs.getString("password");
            formDetails = new formModel(username, email, password);
        }
    } catch (SQLException e) {
        System.out.println("getFormDetails Error: " + e);
    } finally {
        // Close resources
        // ...
    }
    return formDetails;
}

    public boolean createForm (formModel form) {
        boolean success = false;
        Connection conn  = null;
        PreparedStatement ps = null;
        String query = "insert into formdatabase ("
                + "username, "
                + "email,"
                + "password )"
                + "values (?,?,?)";
        try {
            conn = ConnectionPool.getConnection();
            ps = conn.prepareStatement(query);
             
            ps.setString(1, form.getusername());
            ps.setString(2, form.getemail());
            ps.setString(3, form.getpassword());
            int rowAffected = ps.executeUpdate();
            if (rowAffected != 0) {
                success = true;
            }
        } catch (SQLException e) {
            System.out.println("createUser Error: " + e); 
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    //ignore
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    //ignore
                }
            }
            
        }
        return success;
    }
public boolean updateForm(formModel form) {
    boolean success = false;
    Connection conn = null;
    PreparedStatement ps = null;
    String query = "UPDATE formdatabase SET "
            + "email = ?, "
            + "password = ? "
            + "WHERE username = ?";
    try {
        // Get a connection from the connection pool
        conn = ConnectionPool.getConnection();
        
        // Prepare the SQL statement
        ps = conn.prepareStatement(query);
        
        // Set parameters for the SQL query
        ps.setString(1, form.getemail());
        ps.setString(2, form.getpassword());
        ps.setString(3, form.getusername());
        
        // Print the SQL query for debugging purposes
        System.out.println("Executing SQL Query: " + ps.toString());
        
        // Execute the update statement
        int rowAffected = ps.executeUpdate();
        
        // Check if any rows were affected
        if (rowAffected != 0) {
            success = true;
        }
    } catch (SQLException e) {
        // Log the exception
        System.out.println("updateForm Error: " + e);
    } finally {
        // Close resources to avoid resource leaks
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
             
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                
            }
        }
    }
    return success;
}



    
}