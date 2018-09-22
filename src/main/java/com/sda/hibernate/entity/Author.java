package com.sda.hibernate.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String lastname;
    @ManyToMany(mappedBy = "authors")
    private Set<Book> books;

    public Author() {
    }

    public Author(String name, String lastname) {
        this.name = name;
        this.lastname = lastname;
    }


    public String getName() {
        return name;
    }
}
