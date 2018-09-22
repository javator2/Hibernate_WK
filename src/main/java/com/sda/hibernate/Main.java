package com.sda.hibernate;

import com.sda.hibernate.entity.Author;
import com.sda.hibernate.entity.Book;
import com.sda.hibernate.entity.Category;
import com.sda.hibernate.entity.Publisher;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    private static final SessionFactory sessionFactory;

    static {
        try {


            Configuration configuration = new Configuration();
            configuration.configure();
            sessionFactory = configuration.buildSessionFactory();
        } catch (Throwable ex){
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession(){
        return sessionFactory.openSession();
    }


    public static void main(String[] args) {

        Book book = new Book();
        book.setIsbn("324-324");
        book.setTitle("Nowak");

        book.setIsbn("324-384");
        book.setTitle("Okrasa");

        book.setIsbn("324-311");
        book.setTitle("Żwir");

        book.setIsbn("222-324");
        book.setTitle("Chmura");

        Book book1 = new Book("2", "2");

        Session session = getSession();

        Transaction tx = tx = session.getTransaction();

        tx.begin();

        session.save(book);
        session.save(book1);

        tx.commit();

        tx.begin();
        Book book2 = new Book("IBM w ćwiczeniach", "255-556");
        tx.commit();

        tx.begin();
        Book book3 = new Book("Pan Tadeusz", "200-556");
        tx.commit();


        session.save(book2);
        session.save(book3);

        tx.begin();

        Category category = new Category("Fantastyka09");
        Book book5 = new Book();
        book5.setTitle("Title");
        book5.setIsbn("200-200");
        book5.setCategory(category);

        tx.commit();
        //session.save(book5);


        Publisher publisher = new Publisher("Prószyński", "ul. Wilcza", "Wawa");
        Category category1 = new Category("Sci-Fi");
        Book book6 = new Book();
        book6.setTitle("Nowa Fantastyka");
        book6.setIsbn("656-99");
        book6.setCategory(category1);
        book6.setPublisher(publisher);

        tx.begin();
        session.save(book6);
        tx.commit();



        Set<Author> authors = new HashSet<>();
        authors.add(new Author("Jan","Kowalski"));
        authors.add(new Author("Jan2","Kowalski2"));
        authors.add(new Author("Jan3","Kowalski3"));

        Book book7 = new Book();
        book7.setCategory(new Category("Nowa kategoria"));
        book7.setIsbn("232432");
        book7.setTitle("Title_0");
        book7.setAuthors(authors);


        List<Book> bookList = session.createQuery("FROM " + Book.class.getName()).list();
        for (Book b: bookList){
            System.out.println("Tytuł: " + b.getTitle());

            for (Author a: b.getAuthors()){
                System.out.println("Author: " + a.getName());
            }
        }

        /*
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Book> bookCriteriaBuilder = builder.createQuery(Book.class);
        for (Book b: bookCriteriaBuilder){
            System.out.println(b.getAuthor());
        }
        */

        //Book book4 = session.byId(Book.class).getReference(1);
        //System.out.println(book4);


        session.close();

    }
}
