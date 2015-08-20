/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicaJogo;

import MW.Mapa.Mapa;
import MW.Mapa.PPirata;
import MW.Mapa.Planeta;
import MW.Mapa.Vazio;
import MW.Mapa.VazioNotDiscovered;
import MW.Mapa.Wormhole;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Observable;
import java.util.Random;

/**
 *
 * @author Rafael
 */
public class Jogo extends Observable implements Serializable {

    Estado estado;
    Jogador jogador;

    int linhas = 7;
    int colunas = 9;

    public Mapa[][] mapa = new Mapa[linhas][colunas];
    ArrayList<String> dado = new ArrayList<>(Arrays.asList("Branco", "Branco", "Preto", "Azul", "Vermelho", "Amarelo"));

    ArrayList<Integer> XTrans = new ArrayList();
    ArrayList<Integer> YTrans = new ArrayList();

    public Jogo() {
        estado = new EsperaInicio(this);
        jogador = new Jogador();
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    int getRandomCusto() {
        return new Random().nextInt(4);
    }

    int getRandomDado() {
        return new Random().nextInt(6);
    }

    int getRandomM(ArrayList<Integer> n) {
        return new Random().nextInt(n.size());
    }

    public void fazerMapa() {
        ArrayList<Integer> x = new ArrayList();
        x.addAll(Arrays.asList(0, 0, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 7, 7, 8, 8));
        ArrayList<Integer> y = new ArrayList();
        y.addAll(Arrays.asList(5, 4, 4, 3, 4, 3, 2, 3, 2, 1, 2, 3, 4, 3, 4, 5, 2, 3, 4, 2, 3, 2, 1));

        Wormhole aux1 = new Wormhole(0, 6);
        aux1.setCheck(Boolean.TRUE);
        aux1.setNave(Boolean.TRUE);

        Wormhole aux2 = new Wormhole(8, 0);
        aux2.setCheck(Boolean.TRUE);

        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                VazioNotDiscovered e = new VazioNotDiscovered(j, i);
                mapa[i][j] = e;
            }
        }

        XTrans.add(0);
        YTrans.add(6);
        XTrans.add(8);
        YTrans.add(0);

        mapa[6][0] = aux1;
        mapa[0][8] = aux2;

        for (int i = 0; i < 2; i++) {
            int pos = getRandomM(x);
            mapa[y.get(pos)][x.get(pos)] = new Wormhole(y.get(pos), x.get(pos));
            XTrans.add(x.get(pos));
            YTrans.add(y.get(pos));
            x.remove(pos);
            y.remove(pos);
        }

        for (int i = 0; i < 6; i++) {
            int conta = 0;
            int pos = getRandomM(x);
            mapa[y.get(pos)][x.get(pos)] = new Planeta(y.get(pos), x.get(pos));
            while (conta < 4) {
                mapa[y.get(pos)][x.get(pos)].setCusto(getRandomCusto() + 1, conta);
                conta++;
            }
            x.remove(pos);
            y.remove(pos);
        }

        for (int i = 0; i < 3; i++) {
            int conta = 0;
            int pos = getRandomM(x);
            mapa[y.get(pos)][x.get(pos)] = new PPirata(y.get(pos), x.get(pos));
            while (conta < 4) {
                mapa[y.get(pos)][x.get(pos)].setCusto(getRandomCusto() + 1, conta);
                conta++;
            }
            x.remove(pos);
            y.remove(pos);
        }

        for (int i = 0; i < 12; i++) {
            int pos = getRandomM(x);
            mapa[y.get(pos)][x.get(pos)] = new Vazio(y.get(pos), x.get(pos));
            x.remove(pos);
            y.remove(pos);
        }

        setChanged();
        notifyObservers();
    }
    
    public ArrayList<Integer> geraPiratas() {
        ArrayList<Integer> pirTexto = new ArrayList();
        int forcaataque, i = 0;
        while (i < 2) {
            forcaataque = getRandomDado();
            pirTexto.add(i, forcaataque);
            if (forcaataque > jogador.getNave().getPower()) {
                jogador.setMoney(jogador.getMoney() + (jogador.getNave().getPower() - forcaataque));
            } else {

            }
            i++;
        }
        setChanged();
        notifyObservers();
        return pirTexto;
    }
    
    public ArrayList<Integer> explora()   //vai ver em todos os quadrados a volta da nave, e liga o VISTO para true se houver algum com ele a False
    {
        ArrayList<Integer> pirTexto=new ArrayList();
        pirTexto.add(-1);
        pirTexto.add(-1);
        int x,y;
        x=jogador.getNave().getX();
        y=jogador.getNave().getY();
        
        if("X".equals(mapa[y][x].getTexto()))
        {
            pirTexto.addAll(geraPiratas());
        }
        
        if(mapa[y][x].getCheck()==false)
        {
            mapa[y+1][x].setCheck(Boolean.TRUE);
        }
        
        if(y+1<7 && mapa[y+1][x].getCheck()==false && !" ".equals(mapa[y+1][x].getTexto()))
        {
            mapa[y+1][x].setCheck(Boolean.TRUE);
        }
        
        if(y-1>-1 && mapa[y-1][x].getCheck()==false && !" ".equals(mapa[y-1][x].getTexto()))
        {
            mapa[y-1][x].setCheck(Boolean.TRUE);
        }
        
        if(x+1<9 && mapa[y][x+1].getCheck()==false && !" ".equals(mapa[y][x+1].getTexto()))
        {
            mapa[y][x+1].setCheck(Boolean.TRUE);
        }
        
        if(x-1>-1 && mapa[y][x-1].getCheck()==false &&!" ".equals(mapa[y][x-1].getTexto()))
        {
            mapa[y][x-1].setCheck(Boolean.TRUE);
        }
        
        if(y+1<7 && x+1<9 && mapa[y+1][x+1].getCheck()==false && !" ".equals(mapa[y+1][x+1].getTexto()))
        {
            mapa[y+1][x+1].setCheck(Boolean.TRUE);
        }
        
        if(y+1<7 && x-1>-1 && mapa[y+1][x-1].getCheck()==false && !" ".equals(mapa[y+1][x-1].getTexto()))
        {
            mapa[y+1][x-1].setCheck(Boolean.TRUE);
        }
        
        if(y-1>-1 && x+1<9 && mapa[y-1][x+1].getCheck()==false && !" ".equals(mapa[y-1][x+1].getTexto()))
        {
            mapa[y-1][x+1].setCheck(Boolean.TRUE);
        }
        
        if(y-1>-1 && x-1>-1 && mapa[y-1][x-1].getCheck()==false && !" ".equals(mapa[y-1][x-1].getTexto()))
        {
            mapa[y-1][x-1].setCheck(Boolean.TRUE);
        }
        
        setChanged();
        notifyObservers();
        return pirTexto;
    }
    
    
}