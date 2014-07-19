/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ramesh.librarySystem;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Rkaran
 */
public class Member extends Person{
    private int memberNumber;
    private static int memberCount;
    private List<Loan> loans;
    private List<Reservation> reservation;
    
//    public Member(String fName, String lName, String phone, String street, String city, String state, String zip) {
//        super(fName, lName, phone, street, city, state, zip);
//        memberCount++;
//        this.memberNumber = memberCount;
//        loans = new ArrayList<>();
//        this.reservation = new ArrayList<>();
//    }
    
    public Member(Person person){
        super(person.getfName(),person.getlName(),person.getPhone(),person.getAddress());
        this.reservation = new ArrayList();
        this.loans = new ArrayList();
    }
    
    public void addLoan(Loan loan){
        this.loans.add(loan);
    }
    public void addReservation(Reservation reservation){
        this.reservation.add(reservation);
    }
    public void Reserve(Publication publication){
        new Reservation(this, publication);        
    }
    public void cancelReservation(Reservation res){
        res.cancel();
        //this.reservation.remove(res);               //Removing previous Reservation
    }
    public void returnlt(Copy copy){
        copy.returnlt();
        
    }
    
    public List<Reservation> getReservation() {
        return this.reservation;
//        List<Reservation> returnreservation = new ArrayList();
//        for(Reservation res: this.reservation)
//            if( !res.getStatus().equals(Reservation.STATUS_FULLFILLED) && !!res.getStatus().equals(Reservation.STATUS_CANCELLED))
//                returnreservation.add(res);
//        return returnreservation;
    }
    public void Loan(Copy copy){
        new Loan(this, copy);
    }
    
    public void pickUpReservation(Reservation res){
        if(res.getStatus().equals(Reservation.STATUS_ONHOLD))
            //addLoan(res.pickUp());
            res.pickUp();
        else
            JOptionPane.showMessageDialog(null, "Reservation item not available yet", "Invalid Selection", JOptionPane.INFORMATION_MESSAGE);
    }
    public List<Loan> getLoans() {
        return loans;
    }
}
