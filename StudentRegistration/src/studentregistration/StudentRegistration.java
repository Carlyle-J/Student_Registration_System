/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package studentregistration;

import java.sql.*;
import javax.swing.table.DefaultTableModel;

public class StudentRegistration {

    // Add Student
    public boolean addStudent(String Name, String Roll_No, String Nationality, String Date_Of_Birth, String Course, 
                              String gender, String Address, String Email, String Father_Name, String Mother_Name, 
                              String Medical_Conditions, String bloodGroup) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "INSERT INTO studentreg (Name, Roll_No, Nationality, Date_Of_Birth, Course, Gender, Address, Email, Father_Name, Mother_Name, Medical_Conditions, Blood_Group) "
                       + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, Name);
            ps.setString(2, Roll_No);
            ps.setString(3, Nationality);
            ps.setString(4, Date_Of_Birth);
            ps.setString(5, Course);
            ps.setString(6, gender);
            ps.setString(7, Address);
            ps.setString(8, Email);
            ps.setString(9, Father_Name);
            ps.setString(10, Mother_Name);
            ps.setString(11, Medical_Conditions);
            ps.setString(12, bloodGroup);

            int rows = ps.executeUpdate();
            System.out.println("✅" + rows + " student(s) added.");
            return rows > 0;

        } catch (SQLException e) {
            System.out.println("Error adding student: " + e.getMessage());
            return false;
        }
    }

    // Load Students
    public void loadStudents(DefaultTableModel model) {
        try (Connection conn = DBConnection.getConnection()) {
            model.setRowCount(0);
            String sql = "SELECT * FROM studentreg";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Object[] row = {
                    rs.getString("Name"),
                    rs.getString("Roll_No"),
                    rs.getString("Course"),
                    rs.getString("Date_Of_Birth"),
                    rs.getString("Email"),
                    rs.getString("Nationality"),
                    rs.getString("Gender"),
                    rs.getString("Address"),
                    rs.getString("Father_Name"),
                    rs.getString("Mother_Name"),
                    rs.getString("Medical_Conditions"),
                    rs.getString("Blood_Group")
                };
                model.addRow(row);
            }
        } catch (SQLException e) {
            System.out.println("Error loading students: " + e.getMessage());
        }
    }

    // Delete Student
    public boolean deleteStudent(String Roll_No) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "DELETE FROM studentreg WHERE Roll_No = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, Roll_No);
            int rows = ps.executeUpdate();
            return rows > 0;
        } catch (SQLException e) {
            System.out.println("Error deleting student: " + e.getMessage());
            return false;
        }
    }
}


