package com.example.demo.Data;

import com.example.demo.Data.Model.Book;
import java.sql.*;
import java.util.Collection;
import java.util.LinkedList;

public class Dao {

    static final String JDBC_DRIVER = "org.h2.Driver";
    static final String DB_URL = "jdbc:h2:mem:lb";

    static final String USER = "sa";
    static final String PASS = "";


    Book book =null;
    Connection conn = null;
    Statement stmt = null;
    Collection books =null;

    String retrieveBooks = "SELECT * FROM book";


    public void Connection() throws SQLException, ClassNotFoundException {
        System.out.println("start conncetion etablishement");
        Class.forName(JDBC_DRIVER);
        conn = DriverManager.getConnection(DB_URL,USER,PASS);
        stmt = conn.createStatement();
    }


    public Collection getBorrowedBooks(){

        books = new LinkedList();

        try {

            ResultSet rs = stmt.executeQuery(retrieveBooks);

            while(rs.next()) {

                book =new Book();

                Long id  = rs.getLong("book_id");
                String title = rs.getString("book_title");

                book.setTitle(title);
                book.setId(id);

                books.add(book);
            }
            rs.close();
        } catch(SQLException se) {

            se.printStackTrace();

        } catch(Exception e) {

            e.printStackTrace();

        } finally {

            try {
                if(stmt!=null) stmt.close();
            } catch(SQLException se2)
            {
            } try {
                if(conn!=null) conn.close();
            } catch(SQLException se) {
                se.printStackTrace();
            }
        }
        return books;
    }
}