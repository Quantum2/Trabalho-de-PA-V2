/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MW.Misc;

import MW.Recs.RecBranco;
import MW.Recs.RecCinzento;
import MW.Recs.Recs;
import java.util.ArrayList;

/**
 *
 * @author Rafael
 */
public class Nave {
    int x, y, power;
    ArrayList<Recs> cargo=new ArrayList();

    public Nave(int i, int j) {
        x = i;
        y = j;
        power = 3;
        cargo.add(new RecBranco());
        cargo.add(new RecBranco());
        cargo.add(new RecCinzento());
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

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public ArrayList<Recs> getCargo() {
        return cargo;
    }

    public void setCargo(Recs x, int pos) {
        cargo.add(pos, x);
    }
    
}
