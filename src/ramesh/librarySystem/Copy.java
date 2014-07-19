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
public class Copy {
    
    public static String STATUS_AVAILABLE="Available";
    public static String STATUS_LOANED="Loaned";
    public static String STATUS_ONHOLD="On Hold";
    
    private int copyNo;
    private static int count;
    private String status;
    private Publication publication;
    private Loan loan;
    private Reservation reservedFor;

    public Loan getLoan() {
        return loan;
    }

    public Reservation getReservedFor() {
        return reservedFor;
    }

    public void setReservedFor(Reservation reservedFor) {
        this.reservedFor = reservedFor;
    }

    public void setLoan(Loan loan) {
        this.loan = loan;
    }
    public Copy(Publication publication) {
        this.publication = publication;
        count++;
        this.copyNo = count;
        this.status = STATUS_AVAILABLE;
        publication.addCopy(this);
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String avalaibleStatus) {
        this.status = avalaibleStatus;
    }

    public int getCopyNo() {
        return copyNo;
    }

    public void setCopyNo(int copyNo) {
        this.copyNo = copyNo;
    }
    @Override
    public String toString(){
        return "Copy No: "+this.copyNo+", Status: "+this.status;
    }
    public Publication getPublication() {
        return publication;
    }

    public void setPublication(Publication publication) {
        this.publication = publication;
    }
    
    public void laon(Loan loan){
        setStatus(STATUS_LOANED);
        this.loan = loan;
    }
    public void reservePublication(){
        
    }
    public void returnlt(){
        loan.returnlt();
        
        
        if(publication.hasPendingReservation() )
        {
            hold();
            this.reservedFor = publication.getReservations().get(0);
            this.reservedFor.hold(this);
            System.out.println("Reservation on Hold");
        }
        else
        {
            setStatus(STATUS_AVAILABLE);
            this.publication.addCopy(this);
            this.publication.removeReservation(this);
        }
        
    }
    public void hold(){
        setStatus(STATUS_ONHOLD);
    }
    
}
