/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MW.Mapa;

import MW.Recs.RecBranco;
import MW.Recs.Recs;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Rafael
 */
public class PPirata extends Mapa implements Serializable {
    Recs rec;
    ArrayList<Integer> Custo = new ArrayList();
    
    public PPirata(int x, int y) {
        super("X", false, x, y);
        rec = new RecBranco();
    }
    
    @Override
    public Recs getRecurso()
    {
        return rec;
    }
    
    @Override
    public void setRecurso(Recs x)
    {
        rec=x;
    }
    
    @Override
    public ArrayList<Integer> getCusto()
    {
        return Custo;
    }
    
    @Override
    public void setCusto(int c,int pos)
    {
        Custo.add(pos, c);
    }

    @Override
    public ArrayList<Recs> getRecursos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setRecursos(Recs x, int pos) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
