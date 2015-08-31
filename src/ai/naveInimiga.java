/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ai;

import MW.Recs.Recs;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Rafael
 */
public class naveInimiga implements Serializable {

    int x, y, power, largada;

    public naveInimiga(int i, int j) {
        x = i;
        y = j;
        power = 3;
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

    public int getLargada() {
        return largada;
    }

    public void setLargada(int largada) {
        this.largada = largada;
    }
}