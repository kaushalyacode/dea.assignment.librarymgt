package com.example.demo.Data.Model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity
@Table(name ="Author" , schema = "public")
public class Author
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "author_id",nullable = false,updatable = false)
    private int id;

    @Column(name = "author_name",updatable = true,nullable = false)
    private String name;
}