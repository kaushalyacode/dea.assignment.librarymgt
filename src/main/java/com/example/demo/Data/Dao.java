package com.example.demo.Data;

import com.example.demo.Data.Model.Book;
import java.sql.*;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class Dao {

    static final String JDBC_DRIVER = "org.h2.Driver";
    static final String DB_URL = "jdbc:h2:mem:lb";

    static final String USER = "sa";
    static final String PASS = "";


    Book book =null;
    Connection conn = null;
    PreparedStatement pstmt = null;
    List<Book> books =null;
    Collection referencing =null;

    String retrieveBooks = "SELECT * FROM book where stock_quantity <> available_quantity";
    String retrieveReferencing ="SELECT  * FROM  Reference_book_operation_details";
    String retrieveLending = "SELECT  * FROM  Lending_book_operation_details";

    public void Connection() throws SQLException, ClassNotFoundException {
        System.out.println("start conncetion etablishement");
        Class.forName(JDBC_DRIVER);
        conn = DriverManager.getConnection(DB_URL,USER,PASS);
    }

    public List<Book> getBorrowedBooks(){

        books = new LinkedList<Book>();

        try {
            pstmt = conn.prepareStatement(retrieveBooks);
            ResultSet rs = pstmt.executeQuery();

            while(rs.next()) {

                book =new Book();

                Long id  = rs.getLong("book_id");
                String title = rs.getString("book_title");
                String isbn =rs.getString("book_isbn");
                int availablequanity =rs.getInt("available_quantity");
                int wholeBookSok =rs.getInt("stock_quantity");


                book.setTitle(title);
                book.setId(id);
                book.setAvailableQty(availablequanity);
                book.setIsbn(isbn);
                book.setStockQty(wholeBookSok);

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

    public Collection getLendedOperationDetails(){

        referencing = new LinkedList();

        try {
            pstmt = conn.prepareStatement(retrieveLending);
            ResultSet rs = pstmt.executeQuery();

            while(rs.next()) {

                book =new Book();

                Long id  = rs.getLong("book_id");
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

    public Collection getReferenceOperationDetails(){

        referencing = new LinkedList();

        try {
            pstmt = conn.prepareStatement(retrieveReferencing);
            ResultSet rs = pstmt.executeQuery();

            while(rs.next()) {

                book =new Book();

                Long id  = rs.getLong("book_id");
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