/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ramesh.librarySystem;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rkaran
 */
public class Author extends Person{
    private String credential;
    private String shortBio;
    private List<Book> book;
    

//    public Author(String credential, String shortBio, String fName, String lName,String phone, String street, String city, String state, String zip) {
//        super(fName, lName, phone, street, city, state, zip);
//        this.credential = credential;
//        this.shortBio = shortBio;
//    }
    public Author(String credential, String shortbio, Person person){
        super(person.getfName(),person.getlName(), person.getPhone(), person.getAddress());
        this.credential = credential;
        this.shortBio = shortbio;
        this.book = new ArrayList();
    }
    
    public void addBook(Book book){
        this.book.add(book);
    }
    public String getCredential() {
        return credential;
    }

    public void setCredential(String credential) {
        this.credential = credential;
    }

    public String getShortBio() {
        return shortBio;
    }

    public void setShortBio(String shortBio) {
        this.shortBio = shortBio;
    }
    
    @Override
    public void print(){
        super.print();
        System.out.println("Author Details: ");
        System.out.println("Credentials: "+this.credential);
        System.out.println("Bio: "+this.shortBio);
        super.print();
        
    }
}
