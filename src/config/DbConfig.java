package config;
import java.sql.*;

public class DbConfig {
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/student_db", "root", "321"
        );
    }
}
