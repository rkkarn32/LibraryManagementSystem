/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ramesh.librarySystem;

import java.util.Date;
import java.util.Vector;

/**
 *
 * @author Rkaran
 */
public class Reservation {
    //private Date statusDate;
    public  static String STATUS_PENDING ="Pending";
    public static String STATUS_ONHOLD ="On Hold";
    public static String STATUS_CANCELLED ="Cancelled";
    public static String STATUS_FULLFILLED ="Fullfilled";
    
    private String status;
    private Date statusDate;
    private Member reserver;
    private Publication publication;
    private Copy reservedCopy;
    
    public Reservation(Member reserver, Publication publication){
        this.status = STATUS_PENDING;
        this.reserver = reserver;
        this.statusDate = new Date();
        this.publication = publication;        
        reserver.addReservation(this);
        publication.addReservation(this);
    }

    public Copy getReservedCopy() {
        return reservedCopy;
    }

    public void setReservedCopy(Copy reservedCopy) {
        this.reservedCopy = reservedCopy;
    }

    public Publication getPublication() {
        return publication;
    }

    public void setPublication(Publication publication) {
        this.publication = publication;
    }

    public Member getReserver() {
        return reserver;
    }

    public void setReserver(Member reserver) {
        this.reserver = reserver;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getStatusDate() {
        return statusDate;
    }

    public void setStatusDate(Date statusDate) {
        this.statusDate = statusDate;
    }
    
    public Vector getVector(){
        Vector vector = new Vector();
        vector.add(this.statusDate);
        vector.add(this.publication.getTitle());
        vector.add(this.status);
        return vector;
    }
    
    
    public void cancel(){
        setStatus(STATUS_CANCELLED);
        setStatusDate(new Date());
        if(this.reservedCopy!=null)
        {
            this.reservedCopy.returnlt();
            this.reservedCopy.setStatus(Copy.STATUS_AVAILABLE);
        }
        System.out.println("Reservation Cancelled");
        // check for hold , otherwise Available
    }
    public void hold(Copy copy){
        setStatus(STATUS_ONHOLD);
        setStatusDate(new Date());
        setReservedCopy(copy);
    }
    public Loan pickUp(){
        setStatus(STATUS_FULLFILLED);
        setStatusDate(new Date());
        return new Loan(this.reserver, this.reservedCopy);
    }
    
}
