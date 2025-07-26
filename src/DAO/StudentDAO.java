package DAO;

import config.DbConfig;
import entity.Student;

import java.sql.*;
import java.util.*;

public class StudentDAO {

    public void addStudent(Student student) throws SQLException {
        Connection conn = DbConfig.getConnection();
        String sql = "INSERT INTO students (name, age, course) VALUES (?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, student.getName());
        ps.setInt(2, student.getAge());
        ps.setString(3, student.getCourse());
        ps.executeUpdate();
        conn.close();
    }

    public List<Student> getAllStudents() throws SQLException {
        Connection conn = DbConfig.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM students");

        List<Student> list = new ArrayList<>();
        while (rs.next()) {
            Student s = new Student(
                    rs.getString("name"),
                    rs.getInt("age"),
                    rs.getString("course")
            );
            list.add(s);
        }
        conn.close();
        return list;
    }
}

