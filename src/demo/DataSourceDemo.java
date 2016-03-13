package demo;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet("/DataSourceDemo")
public class DataSourceDemo extends HttpServlet{
    private static final long serialVersionUID = 1L;
    private DataSource ds;

    public DataSourceDemo() {
        super();
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        try {
            InitialContext initialContext = new InitialContext();
            Context env = (Context) initialContext.lookup("java:comp/env");
            ds = (DataSource) env.lookup("jdbc/webshop?useSSL=false");
        } catch (NamingException e) {
            throw new ServletException();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        try (Connection connection = ds.getConnection()){
            out.println("Connection succeed");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
