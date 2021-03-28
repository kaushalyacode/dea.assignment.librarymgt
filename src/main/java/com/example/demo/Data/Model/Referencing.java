package com.example.demo.Data.Model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table( name ="Reference_book_operation_details",schema = "public")
public class Referencing
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "referencing_id",nullable = false,updatable = false)
    private int id;

    @Column(name = "reference_book_issued_date",updatable = false,nullable = false)
    private Date issuedDate;

    @Column(name = "reference_book_due_date",updatable = false,nullable = false)
    private Date dueDate;

    /*many to one unidirectional*/
    @ManyToOne(optional = false)
    @JoinColumn(name="Book_id")
    private Book book;

    /*many to one unidirectional*/
    @ManyToOne(optional = false)
    @JoinColumn(name="student_id")
    private Student student;

    /*many to one unidirectional*/
    @ManyToOne(optional = false)
    @JoinColumn(name="staff_memeber_id")
    private StaffMember staffMember;
}
