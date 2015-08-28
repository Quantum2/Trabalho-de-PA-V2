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
public class Planeta extends Mapa implements Serializable {
    ArrayList<Recs> Recs=new ArrayList();     
    ArrayList<Integer> Custo=new ArrayList();
    
    public Planeta(int x,int y)
    {
        super("P",false,x,y);
        Recs.add(new RecBranco());
        Recs.add(new RecBranco());
    }
    
    @Override
    public ArrayList<Recs> getRecursos()
    {
        return Recs;
    }
    
    @Override
    public void setRecursos(Recs x,int pos)
    {
        Recs.add(pos, x);
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
    public Recs getRecurso()
    {
        throw new UnsupportedOperationException("Not supported yet");
    }
    
    @Override
    public void setRecurso(Recs x)
    {
        throw new UnsupportedOperationException("Not supported yet");
    }
}
