package com.example.demo.Controller;

import com.example.demo.Data.Model.Author;
import com.example.demo.Data.Repository.Interface.IAuthorRepository;
import com.example.demo.Services.Infrastructure.AuthorService;
import com.example.demo.Services.Interface.IAuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthorController {


    @Autowired
    IAuthorRepository iAuthorRepository;

    @RequestMapping("/")
    public String Home()
    {
        return "home.jsp";
    }

    @RequestMapping("/addAuthor")
    public String addAuthor()
    {
      //  iAuthorRepository.sav
        return  "Nol";

    }
}
