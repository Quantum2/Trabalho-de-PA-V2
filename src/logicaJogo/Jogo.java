/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicaJogo;

import MW.Mapa.Mapa;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Observable;

/**
 *
 * @author Rafael
 */
public class Jogo extends Observable implements Serializable {
    Estado estado;
    Jogador jogador;
    
    int linhas = 7;
    int colunas = 9;
    
    public Mapa [][] mapa=new Mapa[linhas][colunas]; 
    ArrayList<String> dado=new ArrayList<>(Arrays.asList("Branco","Branco","Preto","Azul","Vermelho","Amarelo"));

    public Jogo() {
        estado = new EsperaInicio(this);
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
    
    
}
