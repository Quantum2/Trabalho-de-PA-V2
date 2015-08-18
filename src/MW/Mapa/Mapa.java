/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MW.Mapa;

import java.io.Serializable;
import java.util.ArrayList;
import MW.Recs.Recs;

/**
 *
 * @author Rafael
 */
public abstract class Mapa implements Serializable{
    String texto;
    Boolean check=false;
    Boolean nave=false;
    
    int x,y;
    
    public Mapa(){
        
    }
    
    public Mapa(String L,Boolean check_nave,int x,int y)
    {
        this.texto=L;
        this.nave=check_nave;
        this.x=x;
        this.y=y;
    }
    
    abstract public ArrayList<Recs> getRecursos();
    abstract public void setRecursos(Recs x,int pos);
    abstract public ArrayList<Integer> getCusto();
    abstract public void setCusto(int c,int pos);
    abstract public Recs getRecurso();
    abstract public void setRecurso(Recs x);

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Boolean getCheck() {
        return check;
    }

    public void setCheck(Boolean check) {
        this.check = check;
    }

    public Boolean getNave() {
        return nave;
    }

    public void setNave(Boolean nave) {
        this.nave = nave;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
