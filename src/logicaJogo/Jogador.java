/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicaJogo;

import MW.Misc.Nave;
import java.io.Serializable;

/**
 *
 * @author Rafael
 */
class Jogador implements Serializable {
    Nave nave;
    int money = 10;

    public Jogador() {
        nave=new Nave(0,6);
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public Nave getNave() {
        return nave;
    }

    public void setNave(Nave nave) {
        this.nave = nave;
    }
}