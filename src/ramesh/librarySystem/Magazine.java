/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ramesh.librarySystem;

import java.util.Vector;

/**
 *
 * @author Rkaran
 */
public class Magazine extends Publication{
    private int issueNum;

    public Magazine(String title, int issuenum) {
        super(title);
        this.issueNum = issuenum;
    }

    public int getIssueNum() {
        return issueNum;
    }
    public Vector getVector(){
        Vector vector = new Vector();
        vector.add(super.getTitle());        
        vector.add(issueNum);
        vector.add(super.getNumberOfAvailableCopies());
        vector.add(super.getNumberOfLendCopies());
        return vector;
    }
    @Override
    public void print(){
        System.out.println("Magazine Details: ");
        System.out.println("issue Number: "+this.issueNum);
        super.print();
    }
}
