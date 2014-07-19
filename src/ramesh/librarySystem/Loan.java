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
public class Loan {
    private Date issueDate;
    private Date returnDate;
    private Member loanBy;
    private Copy copy;

    public Loan( Member loanBy, Copy copy) {
        this.issueDate = new Date();
        this.copy = copy;
        this.loanBy = loanBy;
        copy.setLoan(this);
        copy.setStatus(copy.STATUS_LOANED);
        loanBy.addLoan(this);
    }

    public Copy getCopy() {
        return copy;
    }

    public Date getIssuDate() {
        return issueDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public Member getLoanBy() {
        return loanBy;
    }

    public void setIssueDate(Date checkOutDate) {
        this.issueDate = checkOutDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public void setLoanBy(Member loanBy) {
        this.loanBy = loanBy;
    }
    
    public void returnlt(){
        setReturnDate(new Date());
    }
    
    public Vector getVector(){
        Vector vector = new Vector();
        vector.add(copy.getPublication().getTitle());
        vector.add(this.getIssuDate());
        vector.add(this.getReturnDate());
        return vector;
    }
    
}
