/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MW.Recs;

import java.io.Serializable;

/**
 *
 * @author Rafael
 */
public abstract class Recs implements Serializable{

    public Recs() {
    }
    
    abstract public String getNome();
    abstract public void setNome(String n);
}
