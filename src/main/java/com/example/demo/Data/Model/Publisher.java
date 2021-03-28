package com.example.demo.Data.Model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity
@Table(name ="Publisher" , schema = "public")
public class Publisher
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name ="PublisherId", nullable= false)
    private int id;

    @Column(name ="PublisherName", nullable= false)
    private String name;

    @Column(name ="PublisherTelephone", nullable= true)
    private String telephone;
}
