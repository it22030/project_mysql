package Application;

import java.sql.*;

public class Services {

    // Database credentials
   // static String url = "jdbc:mysql://urowmyrks8sa1rih:RsKRqsn19uGmkebas6WR@b3p5m8nhncgiqy1daeus-mysql.services.clever-cloud.com:3306/b3p5m8nhncgiqy1daeus";
    //static String user = "urowmyrks8sa1rih";
   // static String password = "RsKRqsn19uGmkebas6WR";
    public static String url = "jdbc:mysql://localhost:3306/ict";
    public static String user = "root";
    public static String password = "ashik";

    // SQL queries for CRUD operations
    static String insertQuery = "insert into students (name) values (?)";

    static String deleteQuery = "delete from students where id = ?";
    static String viewQuery = "select *from students";
    static String findQuery = "select *from students where id = ?";
    static String updateQuery = "update students set name = ? where id = ?";

    // Method to insert data into the database
    public static void insertData(String name){
        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement ps = connection.prepareStatement(insertQuery)) {
            ps.setString(1, name);
            int result = ps.executeUpdate();
            if (result > 0) {
                System.out.println("Data inserted successfully!");
            } else {
                System.out.println("Failed to insert data.");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    // Method to delete data from the database
    public static void deleteData(int id){
        try(Connection connection = DriverManager.getConnection(url, user, password);
            PreparedStatement ps = connection.prepareStatement(deleteQuery)){
            ps.setInt(1, id);
            int result = ps.executeUpdate();
            if (result > 0) {
                System.out.println("Data deleted successfully!");
            } else {
                System.out.println("Failed to delete data.");
            }
        }catch (SQLException e){
            System.out.println("Error deleting data: " + e.getMessage());
        }
    }

    // Method to view all students in the database
    public static void viewAllStudents(){
        try(Connection connection = DriverManager.getConnection(url, user, password);
            PreparedStatement ps = connection.prepareStatement(viewQuery)){
            ResultSet rs = ps.executeQuery();
            System.out.println("ID\tName");
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                System.out.println(id + "\t" + name);
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving data: " + e.getMessage());
        }
    }

    // Method to find a student by ID
    public static void findStudent(int id) {
        try(Connection connection = DriverManager.getConnection(url, user, password);
            PreparedStatement ps = connection.prepareStatement(findQuery)){
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String name = rs.getString("name");
                System.out.println("Student Found: ID = " + id + ", Name = " + name);
            } else {
                System.out.println("No student found with ID: " + id);
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving data: " + e.getMessage());
        }
    }

    // Method to update a student's name by ID
    public static void updateStudent(int id, String newName) {
        try(Connection connection = DriverManager.getConnection(url, user, password);
            PreparedStatement ps = connection.prepareStatement(updateQuery)) {
            ps.setString(1, newName);
            ps.setInt(2, id);
            int result = ps.executeUpdate();
            if (result > 0) {
                System.out.println("Data updated successfully!");
            } else {
                System.out.println("Failed to update data. Check if the ID exists.");
            }
        }catch (SQLException e) {
            System.out.println("Error updating data: " + e.getMessage());
        }
    }


}