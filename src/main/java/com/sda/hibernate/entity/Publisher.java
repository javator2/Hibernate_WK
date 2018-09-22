package com.sda.hibernate.entity;

import javax.persistence.*;
import java.util.Set;

@Entity

public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String name;
    @Column
    private String address;
    @Column
    private  String city;
    @OneToMany(mappedBy = "publisher")
    private Set<Book> publishedBooks;

    public Publisher() {
    }

    public Publisher(String name, String address, String city) {
        this.name = name;
        this.address = address;
        this.city = city;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Set<Book> getPublishedBooks() {
        return publishedBooks;
    }

    public void setPublishedBooks(Set<Book> publishedBooks) {
        this.publishedBooks = publishedBooks;
    }
}
