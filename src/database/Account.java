package database;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Account {
    private Connection connection;
    public Account(Connection connection) {
        this.connection = connection;
    }

    public boolean login(String email, String password){

        String sql = "SELECT count(*) FROM users WHERE email=? AND password=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return true;
    }
}
