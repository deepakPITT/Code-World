/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Popular;

import java.util.Date;

/**
 *
 * @author deepak
 */
public class Input implements Comparable<Input> {
    
    int id;
    Date date;
    
    Input(int id, Date date) {
        this.id = id;
        this.date = date;
    }
    
    
    public int getId() {
        return this.id;
    }
    
    public Date getDateField() {
        return this.date;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public void setDate(Date date) {
        this.date = date;
    }
    
    @Override
  public int compareTo(Input o) {
    return getDateField().compareTo(o.getDateField());
  }

   
}

