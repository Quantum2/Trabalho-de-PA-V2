/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iu.texto;

import java.io.Serializable;
import static java.lang.System.exit;
import java.util.ArrayList;
import java.util.Scanner;
import logicaJogo.Jogo;

/**
 *
 * @author Rafael
 */
public class Texto implements Serializable {
    Jogo j;
    transient Scanner sc=new Scanner(System.in); 

    public Texto(Jogo j) {
        this.j = j;
    }
 
    public void TJogar() {
        int i = 0;
        while (true) {
            if (i == 0) //
            {
                comecajogo();
                i++;
            } else {
                mostrajogo();
            }
        }
    }

    private void comecajogo() {
        int x;
        
        System.out.println("Trabalho de PA");
        System.out.println(" Milky Way Express\n");
        System.out.println("1: Novo jogo");
        System.out.println("2: Carregar jogo");
        System.out.println("3: Sair\n");
        System.out.println("Escolha uma opção:");
        
        do {
            x = sc.nextInt();
        } while (x < 1 && x > 3);
        
        switch(x)
        {
            case 1:{
                j.fazerMapa();        
                mostraMapa();          
                j.setEstado(j.getEstado().fimEstado());
                mostrajogo();        
                break;
            }
            case 2:{
                carregar();
                break;
            }
            case 3:{
                exit(0);
            }
        }
    }

    private void mostrajogo() {
        ArrayList<Integer> pirTexto = new ArrayList();
        ArrayList<Integer> pirTexto2 = new ArrayList();
        
        int g, opcao, opcao2, x, y, conta = 0;
        
        System.out.println("Quer gravar o jogo ?\n (1)- Sim e sair do jogo (2)- Sim (3)- Não");
        do {
            opcao = sc.nextInt();
        } while (opcao < 1 && opcao > 3);
        if (opcao == 1) {
            gravar();
            exit(0);
        }
        if (opcao == 2) {
            gravar();
        }
      
        pirTexto.addAll(j.explora());

        if ("X".equals(j.getMapa()[j.getJogador().getNave().getY()][j.getJogador().getNave().getX()].getTexto())) {
            mostraAtaquePirata(pirTexto);
        }
        mostraMapa();
        
        pirTexto2.addAll(j.Repoe());       
        if(pirTexto2.get(0)>-1 && pirTexto2.get(1)>-1)
        {
            mostraAtaquePirata(pirTexto);
        }
        mostraMapa();
     
        if ("P".equals(j.getMapa()[j.getJogador().getNave().getY()][j.getJogador().getNave().getX()].getTexto()) || "X".equals(j.getMapa()[j.getJogador().getNave().getY()][j.getJogador().getNave().getX()].getTexto())) {
            if ("P".equals(j.getMapa()[j.getJogador().getNave().getY()][j.getJogador().getNave().getX()].getTexto())) {
                do {
                    System.out.print("Quer vender alguma carga(1- Sim, 2- Não):");
                    do {
                        opcao = sc.nextInt();
                    } while (opcao < 1 && opcao > 2);
                    if (opcao == 1) {
                        System.out.println("Precos do planeta: Azul:" + j.getMapa()[j.getJogador().getNave().getY()][j.getJogador().getNave().getX()].getCusto().get(0) + " Amarelo:" + j.getMapa()[j.getJogador().getNave().getY()][j.getJogador().getNave().getX()].getCusto().get(1) + " Vermelho:" + j.getMapa()[j.getJogador().getNave().getY()][j.getJogador().getNave().getX()].getCusto().get(2) + " Preto:" + j.getMapa()[j.getJogador().getNave().getY()][j.getJogador().getNave().getX()].getCusto().get(3));
                        System.out.println("\nEscolha a carga a vender (cargas brancas e cinzentas não podem ser vendidas) 1- " + j.getJogador().getNave().getCargo().get(0).getNome() + " 2- " + j.getJogador().getNave().getCargo().get(1).getNome() + " 3- " + j.getJogador().getNave().getCargo().get(2).getNome());
                        do {
                            opcao2 = sc.nextInt();
                        } while (opcao2 < 1 && opcao2 > 3);
                        opcao2 = opcao2 - 1;
                        j.setEstado(j.getEstado().Vende(opcao2));
                        j.setEstado(j.getEstado().fimEstado());
                    }
                } while (opcao != 2);
            }

        }
    }
  
    void LimpaJanela() 
    {
        int i = 0;
        while (i < 12) {
            System.out.print("\n");
            i++;
        }
    }
    
    public void mostraAtaquePirata(ArrayList<Integer> x)
    {
        if (x.get(0) > j.getJogador().getNave().getPower()) {
            System.out.println("Foste atacado por piratas com força de: " + x.get(0));
        } else {
            System.out.println("Ataque pirata falhou !");
        }

        if (x.get(1) > j.getJogador().getNave().getPower()) {
            System.out.println("Es atacado por piratas com força de: " + x.get(1));
        } else {
            System.out.println("Ataque pirata falhado");
        }
    }

    private void carregar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void mostraMapa() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Jogo getJ() {
        return j;
    }

    public void setJ(Jogo j) {
        this.j = j;
    }

    private void gravar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
