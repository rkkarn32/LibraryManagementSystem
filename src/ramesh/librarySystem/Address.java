/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ramesh.librarySystem;

/**
 *
 * @author Rkaran
 */
public class Address {
    private String street;
    private String city;
    private String state;
    private String zip;
    private Person person;

    public Address(String street, String city, String state, String zip, Person person) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.person = person;
        person.setAddress(this);
    }
    public Address(String street, String city, String state, String zip) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
    public Address(){
        
    }
    
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    @Override
    public String toString() {
        return "Address{" + "street=" + street + ", city=" + city + ", state=" + state + ", zip=" + zip + '}';
    }
}
