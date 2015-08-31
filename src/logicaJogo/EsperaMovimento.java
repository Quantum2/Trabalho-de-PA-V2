/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicaJogo;

import java.io.Serializable;
import static java.lang.System.exit;
import java.util.Random;

/**
 *
 * @author Rafael
 */
public class EsperaMovimento extends Estado implements Serializable {

    public EsperaMovimento(Jogo j) {
        super(j);
    }

    @Override
    public Estado Upgrade(int escolha) {
        return this;
    }

    @Override
    public Estado Compra(int escolhacompra) {
        return this;
    }

    @Override
    public Estado Movimento(int opcao, int conta) {
        int x,y;
        x=J.jogador.getNave().getX();
        y=J.jogador.getNave().getY();
       
        if (opcao == 0) {                               
            Random rn = new Random();
            int x_rand, y_rand;

            do {
                x_rand = rn.nextInt(9);
                y_rand = rn.nextInt(7);
            }while(J.mapa[y_rand][x_rand].getCheck()==true && !"_".equals(J.mapa[y_rand][x_rand].getTexto()));
            
            J.mapa[y_rand][x_rand].setCheck(Boolean.TRUE);
            
            J.jogador.getNave().setY(y_rand);
            J.jogador.getNave().setX(x_rand);
            J.jogador.setMoney(J.jogador.getMoney()-1);
        }
        if(opcao==1)
        {
            if(y+1<7 && J.mapa[y+1][x].getCheck()==true && !" ".equals(J.mapa[y+1][x].getTexto()))
            {
                J.jogador.getNave().setY(y+1);
                J.jogador.setMoney(J.jogador.getMoney()-1);
            }else{
                opcao=0;
            }
        }
        if(opcao==2)
        {
            if(y-1>-1 && J.mapa[y-1][x].getCheck()==true && !" ".equals(J.mapa[y-1][x].getTexto()))
            {
                J.jogador.getNave().setY(y-1);
                J.jogador.setMoney(J.jogador.getMoney()-1);
            }else{
                opcao=0;
            }
        }
        if(opcao==3)
        {
            if(x+1<9 && J.mapa[y][x+1].getCheck()==true && !" ".equals(J.mapa[y][x+1].getTexto()))
            {
                J.jogador.getNave().setX(x+1);
                J.jogador.setMoney(J.jogador.getMoney()-1);
            }else{
                opcao=0;
            }
        }
        if(opcao==4)
        {
            if(x-1>-1 && J.mapa[y][x-1].getCheck()==true &&!" ".equals(J.mapa[y][x-1].getTexto()))
            {
                J.jogador.getNave().setX(x-1);
                J.jogador.setMoney(J.jogador.getMoney()-1);
            }else{
                opcao=0;
            }
        }
        if(opcao==5)
        {
            if(y+1<7 && x+1<9 && J.mapa[y+1][x+1].getCheck()==true && !" ".equals(J.mapa[y+1][x+1].getTexto()))
            {
                J.jogador.getNave().setY(y+1);
                J.jogador.getNave().setX(x+1);
                J.jogador.setMoney(J.jogador.getMoney()-1);
            }else{
                opcao=0;
            }
        }
        if(opcao==6)
        {
            if(y+1<7 && x-1>-1 && J.mapa[y+1][x-1].getCheck()==true && !" ".equals(J.mapa[y+1][x-1].getTexto()))
            {
                J.jogador.getNave().setY(y+1);
                J.jogador.getNave().setX(x-1);
                J.jogador.setMoney(J.jogador.getMoney()-1);
            }else{
                opcao=0;
            }
        }
        if(opcao==7)
        {
            if(y-1>-1 && x+1<9 && J.mapa[y-1][x+1].getCheck()==true && !" ".equals(J.mapa[y-1][x+1].getTexto()))
            {
                J.jogador.getNave().setY(y-1);
                J.jogador.getNave().setX(x+1);
                J.jogador.setMoney(J.jogador.getMoney()-1);
            }else{
                opcao=0;
            }
        }
        if(opcao==8)
        {
            if(y-1>-1 && x-1>-1 && J.mapa[y-1][x-1].getCheck()==true && !" ".equals(J.mapa[y-1][x-1].getTexto()))
            {
                J.jogador.getNave().setY(y-1);
                J.jogador.getNave().setX(x-1);
                J.jogador.setMoney(J.jogador.getMoney()-1);
            }else{
                opcao=0;
            }
        }
        
        if(opcao==9)
        {
                J.jogador.getNave().setX(J.XTrans.get(conta));
                J.jogador.getNave().setY(J.YTrans.get(conta));
            }else{
                opcao=0;
            }
        
        //Fase da nave inimiga
        Random rn = new Random();
        int rand_x, rand_y, chooser;
        
        if (J.jogador.getEnemie().getLargada() == 0) {
            do {
                rand_y = rn.nextInt(7);
                rand_x = rn.nextInt(9);
            } while (!"X".equals(J.mapa[rand_y][rand_x].getTexto()));
            J.jogador.enemie.setX(rand_x);
            J.jogador.enemie.setY(rand_y);
            J.jogador.enemie.setLargada(1);
        }else{
            chooser = rn.nextInt(5);
            
            if(chooser == 1 && !" ".equals(J.mapa[J.jogador.enemie.getY()][J.jogador.enemie.getX() + 1].getTexto())){
                J.jogador.enemie.setX(J.jogador.enemie.getX() + 1);
            }else if(chooser == 2 && !" ".equals(J.mapa[J.jogador.enemie.getY() + 1][J.jogador.enemie.getX()].getTexto())){
                J.jogador.enemie.setY(J.jogador.enemie.getY() + 1);
            }else if(chooser == 3 && !" ".equals(J.mapa[J.jogador.enemie.getY()][J.jogador.enemie.getX() - 1].getTexto())){
                J.jogador.enemie.setX(J.jogador.enemie.getX() - 1);
            }else if(chooser == 4 && !" ".equals(J.mapa[J.jogador.enemie.getY() - 1][J.jogador.enemie.getX()].getTexto())){
                J.jogador.enemie.setY(J.jogador.enemie.getY() - 1);
            }
        }

        return new EsperaMovimento(this.J);
    }

    @Override
    public Estado Vende(int escolhavenda) {
        return this;
    }

    @Override
    public Estado fimEstado() {
        return new EsperaVenda(this.J);
    }

    @Override
    public Estado Recomeca() {
        return this;
    }

    @Override
    public void fimJogo() {
        exit(0);
    }

    @Override
    public int ganha() {
        return -1;
    }
    
}
