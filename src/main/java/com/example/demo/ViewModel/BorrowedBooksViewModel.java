package com.example.demo.ViewModel;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Id;

@Getter
@Setter
@ToString
public class BorrowedBooksViewModel {


    private Long id;

    private String Title;

    private String isbn;

    private int stockQty;

    private int borrowedQty;

    private int availableQty;
}
