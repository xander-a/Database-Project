/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ph.database.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Xander
 */
public class formDatabase {

    public boolean signupForm(int age, String username, String email, String password) throws SQLException {
        // Use try-with-resources to ensure proper resource management
        String query = "INSERT INTO formdatabase (age, username, email, password) VALUES (?, ?, ?, ?)";
        
        try (Connection conn = ConnectionPool.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setInt(1, age);
            ps.setString(2, username);
            ps.setString(3, email);
            ps.setString(4, password);

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            // Log the exception and rethrow to the caller
            // Here, replace System.out.println with an appropriate logging mechanism
            System.out.println("SQLException: " + e.getMessage());
            throw e; // Rethrow the exception
        }
    }
}
