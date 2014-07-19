/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ramesh.librarySystem;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Rkaran
 */
public class Publication {
    private String title;
    private List<Reservation> reservations;

    public List<Reservation> getReservations() {
        return reservations;
    }

    public Reservation getPendingReservation(){
        if(this.reservations.size()>0)
        {
            for(Reservation res : this.reservations){
                if (res.getStatus().equals(Reservation.STATUS_PENDING))
                        return res;
            }
        }
        return null;
    }
    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }
    private List<Copy> availableCopy = new ArrayList();
    private List<Copy> lendCopies = new ArrayList();

    public Publication(String title) {
        
        this.title = title;
        this.reservations = new ArrayList<>();
        new Copy(this);
        
    }
    public void addCopy(Copy copy){
        this.availableCopy.add(copy);
    }
    public void removeReservation(Copy copy){
        this.lendCopies.remove(copy);
    }
    public void addReservation(Reservation reservation){
        this.reservations.add(reservation);
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getTitle(){
        return this.title;
    }
    public int getNumberOfAvailableCopies(){
        return this.availableCopy.size();
    }
    public int getNumberOfLendCopies(){
        return this.lendCopies.size();
    }

    public List<Copy> getCopy() {
        return availableCopy;
    }
    
    public Publication getPublication(){
        return this;
    }
    
    public boolean hasPendingReservation(){
        
        if(this.reservations.size()>0)
        {
            for(Reservation res : this.reservations){
                if (res.getStatus().equals(Reservation.STATUS_PENDING))
                        return true;
            }
        }
        return false;
    }
    
    public Copy loanCopy(){
        Copy copy =null;
        if(this.availableCopy.size()>0)
        {
            copy = this.availableCopy.get(0);
            this.availableCopy.remove(copy);
            this.lendCopies.add(copy);
        }
        return copy;
    }
    public void returnlt(Copy copy){
        this.lendCopies.remove(copy);
        this.availableCopy.add(copy);
    }
    
    @Override
    public String toString(){
        return this.title;
    }
    public void print(){
        System.out.println("Publication's Title: "+this.title);
    }
    
}
