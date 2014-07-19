/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ramesh.librarySystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 *
 * @author Rkaran
 */
public class Book extends Publication{
    private String ISBN;
    private List<Author> author;
    
    public Book(String title,String isbn) {
        super(title);
        this.ISBN = isbn;
        this.author = new ArrayList();
    }
    public Book(String title,String isbn, List<Author> author) {
        super(title);
        this.ISBN = isbn;
        this.author = new ArrayList();
        this.author = author;
        for(Author auth: author)
            auth.addBook(this);
    }

    public String getISBN() {
        return ISBN;
    }
    
    public List<Author> getAuthor() {
        return author;
    }

    public void addAuthor(Author author) {
        this.author.add(author);
        author.addBook(this);
    }
    public Vector getVectorBook(){
        Vector vector = new Vector();
        vector.add(super.getTitle());
        vector.add(this.ISBN);
        vector.add(super.getNumberOfAvailableCopies());
        vector.add(super.getNumberOfLendCopies());
        return vector;
    }
    @Override
    public void print(){
        System.out.println("Book Details: ");
        System.out.println("ISBN: "+this.ISBN);
        super.print();
        for(Author auth : this.author)
            auth.print();
    }
 }

