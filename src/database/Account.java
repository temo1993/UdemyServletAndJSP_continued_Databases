package database;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Account {
    private Connection connection;
    public Account(Connection connection) {
        this.connection = connection;
    }

    public boolean login(String email, String password){
        ResultSet resultSet = null;
        String sql = "SELECT COUNT(*) AS usr FROM users WHERE email=? AND password=?";
        boolean result = false;
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)
             ){

            preparedStatement.setString(1,email);
            preparedStatement.setString(2,password);
            resultSet = preparedStatement.executeQuery();
            int count = 0;
            if (resultSet.next()) {
                count = resultSet.getInt("usr");
            }
            result = count != 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}
