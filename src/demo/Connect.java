package demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet("/Connect")
public class Connect extends HttpServlet{
    private static final long serialVersionUID = 1L;

    public Connect() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter out = resp.getWriter();
        String database = "jdbc:mysql://localhost/webshop?useSSL=false";
        String userName = "root";
        String password = "123456";
        String query = "SELECT * FROM users";

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            out.println(e.getMessage());
        }

        try(Connection connection = DriverManager.getConnection(database,userName,password);
            Statement statement = connection.createStatement();
            ResultSet myResultSet = statement.executeQuery(query)){
                while(myResultSet.next()){
                    String email = myResultSet.getString("email");
                    String passw = myResultSet.getString("password");
                    out.print("User's email is: " + email);
                    out.println(", and password is: " + passw);
                }
        } catch (SQLException e) {
            out.println(e.getMessage());
        }
    }
}
