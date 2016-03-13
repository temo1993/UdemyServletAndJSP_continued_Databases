package controller;

import bean.User;
import database.Account;

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

@WebServlet("/Controller")
public class Controller extends HttpServlet{
    private static final long serialVersionUID = 1L;
    private DataSource ds;

    public Controller() {
        super();
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        try {
            InitialContext initialContext = new InitialContext();
            Context env = (Context) initialContext.lookup("java:comp/env");
            ds = (DataSource) env.lookup("jdbc/webshop");
        } catch (NamingException e) {
            throw new ServletException();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Use connection
        PrintWriter out = resp.getWriter();
        String action = req.getParameter("action");
        if (action == null) {
            out.println("unrecognised action");
            return;
        }

        try (Connection connection = ds.getConnection()){
            if (action.equals("dologin")) {
                String email = req.getParameter("email");
                String password = req.getParameter("password");
                User user = new User(email,password);
                req.setAttribute("email",email);
                req.setAttribute("password","");


                Account account = new Account(connection);
                if (account.login(email, password)) {
                    req.getRequestDispatcher("/loginsuccess.jsp").forward(req,resp);
                } else {
                    req.setAttribute("message","email address or password not recognized.");
                    req.getRequestDispatcher("/login.jsp").forward(req,resp);
                }
            } else {
                out.println("unrecognised action");
            }
        } catch (SQLException e) {
            // Do something sensible here -- forward to error.jsp etc.
            e.getMessage();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        PrintWriter out = resp.getWriter();
//        try (Connection connection = ds.getConnection()){
//            out.println("Connection succeed");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        PrintWriter out = resp.getWriter();
        out.println("Something went wrong!");
    }
}
