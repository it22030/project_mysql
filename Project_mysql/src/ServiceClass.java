import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiceClass extends MySQLClass {

    public boolean InsertDB(String name) {
        connection = this.getConnection();
        String sql = "INSERT INTO students(name) VALUES(?)";
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, name);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAll();
        }
        return false;
    }

    public List<Student> ReadFromDB() {
        List<Student> list = new ArrayList<>();
        connection = this.getConnection();
        String sql = "SELECT * FROM students";
        try {
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Student std = new Student();
                std.setId(rs.getInt("id"));
                std.setName(rs.getString("name"));
                list.add(std);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAll();
        }
        return list;
    }

    public void updateStudent(int id, String newName) {
        connection = this.getConnection();
        String sql = "UPDATE student SET name=? WHERE id=?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, newName);
            ps.setInt(2, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAll();
        }
    }

    public void deleteStudent(int id) {
        connection = this.getConnection();
        String sql = "DELETE FROM student WHERE id=?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAll();
        }
    }

}
