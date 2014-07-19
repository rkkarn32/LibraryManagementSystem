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
public class Person {
    private String fName;
    private String lName;
    private String phone;
    private Address address;

    public Person(String fName, String lName, String phone, String street, String city, String state, String zip) {
        this.fName = fName;
        this.lName = lName;
        this.phone = phone;
        this.address = new Address(street, city, state, zip, this);
    }
    public Person(String fName, String lName, String phone, Address address) {
        this.fName = fName;
        this.lName = lName;
        this.phone = phone;
        this.address = address;
        address.setPerson(this);
    }
    public Person(String fName, String lName, String phone) {
        this.fName = fName;
        this.lName = lName;
        this.phone = phone;
        this.address = null;
    }
    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
    @Override
    public String toString(){
        return getfName()+" "+getlName();
    }
    
    public void print(){
        System.out.println("Personal Detail: ");
        System.out.println("Name: "+this.fName+" "+this.lName);
        System.out.println("Phone: "+this.phone);
        System.out.println(address.toString());
    }
     
}
