package com.example.demo.Data.Model;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity
@Table(name = "Book" ,schema = "public")
public class Book {

    @Id
    @Column(name = "book_id",updatable = false,nullable = false)
    private Long id;

    @Column(name = "book_title",updatable = true,nullable = false)
    private String Title;

    @Column(name = "book_isbn",updatable = false,nullable = false)
    private String isbn;

    @Column(name = "stock_quantity",updatable = true,nullable = false)
    private int stockQty;

    @Column(name = "borrow_quantity",updatable = true,nullable = false)
    private int borrowedQty;

    @Column(name = "available_quantity",updatable = true,nullable = false)
    private int availableQty;

    @ManyToOne(optional = false)
    @JoinColumn(name="publisher_id")
    private Publisher publisher;
}