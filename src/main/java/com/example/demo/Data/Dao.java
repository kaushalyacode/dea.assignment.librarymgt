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
    PreparedStatement pstmt = null;
    Collection books =null;

    String retrieveBooks = "SELECT * FROM book";


    public void Connection() throws SQLException, ClassNotFoundException {
        System.out.println("start conncetion etablishement");
        Class.forName(JDBC_DRIVER);
        conn = DriverManager.getConnection(DB_URL,USER,PASS);
        pstmt = conn.prepareStatement(retrieveBooks);
    }


    public Collection getBorrowedBooks(){

        books = new LinkedList();

        try {

            ResultSet rs = pstmt.executeQuery();

            while(rs.next()) {

                book =new Book();

                Long id  = rs.getLong("book_id");
                String title = rs.getString("book_title");

                book.setTitle(title);
                book.setId(id);

                books.add(book);
            }
            rs.close();
        } catch(SQLException e) {

            e.printStackTrace();

        } catch(Exception e) {

            e.printStackTrace();

        } finally {

            try {
                if(pstmt!=null)
                {
                    pstmt.close();
                }
            } catch(SQLException e)
            {

            } try {
                if(conn!=null)
                {
                    conn.close();
                }
            } catch(SQLException e)
            {
                e.printStackTrace();
            }
        }
        return books;
    }
}