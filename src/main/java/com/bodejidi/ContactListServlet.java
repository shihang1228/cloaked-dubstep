package com.bodejidi;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ContactListServlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse resp) 
        throws IOException,ServletException {
        
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch(Exception sqle) {
          
        }
        
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/test?user=root&password=");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from contact");
            while(rs.next()) {
                resp.getWriter().println(rs.getString("name"));
                resp.getWriter().println(rs.getString("mobile"));                               
            }            
        } catch(SQLException sqle) {
            System.out.println(sqle.getMessage());
            System.out.println(sqle.getSQLState());
            System.out.println(sqle.getErrorCode());
        }
    }
} 

