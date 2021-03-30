package com.example.demo.Controller;


import com.example.demo.Data.Dao;
import com.example.demo.Data.Model.Book;
import com.example.demo.Data.Repository.Interface.IBookRepository;
import com.example.demo.ViewModel.BorrowedBooksViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("books")
public class BookController {

    @Autowired
    IBookRepository iBookRepository;

    @RequestMapping("/getBorrowedBooksJpa")
    public Iterable<Book> getBorrowedBooksJpa()
    {
        return iBookRepository.findAll();
    }


    @RequestMapping("/getBorrowedBooksNonJpa")
    public Collection getBorrowedBooksNoJpa() throws SQLException, ClassNotFoundException {

        Dao data =new Dao();
        data.Connection();

        List<BorrowedBooksViewModel> books =new LinkedList<BorrowedBooksViewModel>();
        data.getBorrowedBooks().forEach(singleBook -> {

                    BorrowedBooksViewModel book = new BorrowedBooksViewModel();

                    book.setId(singleBook.getId());
                    book.setBorrowedQty(singleBook.getBorrowedQty());
                    book.setAvailableQty(singleBook.getAvailableQty());
                    book.setIsbn(singleBook.getIsbn());
                    book.setStockQty(singleBook.getStockQty());
                    book.setTitle(singleBook.getTitle());

                    books.add((book));
                    System.out.println(book);

                }
        );
        return books;
    }
}
