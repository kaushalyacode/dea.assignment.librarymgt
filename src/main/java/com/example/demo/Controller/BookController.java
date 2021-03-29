package com.example.demo.Controller;

import antlr.collections.List;
import com.example.demo.Data.Dao;
import com.example.demo.Data.Model.Book;
import com.example.demo.Data.Repository.Interface.IBookRepository;
import com.example.demo.ViewModel.BorrowedBooksViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;


@RestController
public class BookController {

    @Autowired
    IBookRepository iBookRepository;

    @RequestMapping("/getBorrowedBooksJpa")
    public Iterable<Book> getBorrowedBooksJpa()
    {
        return iBookRepository.findAll();
    }


    @RequestMapping("/getBorrowedBooksNonJpa")
    public Collection getBorrowedBooksNoJpa()
    {
        Dao data =new Dao();
        return data.getBorrowedBooks();

    }

}