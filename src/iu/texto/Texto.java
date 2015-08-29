/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iu.texto;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import static java.lang.System.exit;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import logicaJogo.Jogo;

/**
 *
 * @author Rafael
 */
public class Texto implements Serializable {

    Jogo j;
    transient Scanner sc = new Scanner(System.in);

    public Texto(Jogo j) {
        this.j = j;
    }

    public void TJogar() {
        int i = 0;
        while (true) {
            if (i == 0) {
                comecajogo();
                i++;
            } else {
                mostrajogo();
            }
        }
    }

    public void comecajogo() {
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

        switch (x) {
            case 1: {
                j.fazerMapa();
                mostraMapa();
                j.setEstado(j.getEstado().fimEstado());
                mostrajogo();
                break;
            }
            case 2: {
                carregar();
                break;
            }
            case 3: {
                exit(0);
            }
        }
    }

    public void mostrajogo() {
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
        if (pirTexto2.get(0) > -1 && pirTexto2.get(1) > -1) {
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
                    }else if(opcao == 2){
                        j.setEstado(j.getEstado().fimEstado());
                    }
                } while (opcao != 2);
            }

            System.out.println("\nGostaria de fazer algum upgrade 1 - Sim 2 - Nao");
            do {
                opcao = sc.nextInt();
            } while (opcao < 1 && opcao > 2);
            if (opcao == 1) {
                opcao = 0;
                if (j.getJogador().getNave().getPower() == 3 && "Cinzento".equals(j.getJogador().getNave().getCargo().get(2).getNome())) {
                    System.out.println("Escolha o upgrade: 1 - Força(4 moedas) 2 - Carga(5 moedas)");
                    do {
                        opcao = sc.nextInt();
                    } while (opcao < 1 && opcao > 2);
                    if (opcao == 1 && j.getJogador().getMoney() - 4 > 0) {
                        j.setEstado(j.getEstado().Upgrade(opcao));
                        j.setEstado(j.getEstado().fimEstado());
                        System.out.println("Sucesso|");
                    } else {
                        if (opcao == 2 && j.getJogador().getMoney() - 5 > 0) {
                            j.setEstado(j.getEstado().Upgrade(opcao));
                            j.setEstado(j.getEstado().fimEstado());
                            System.out.println("Sucesso|");
                        } else {
                            System.out.println("Impossivel");
                        }
                    }
                } else {
                    if (j.getJogador().getNave().getPower() == 3 && j.getJogador().getMoney() - 4 > 0) {
                        System.out.println("Escolha o upgrade: 1 - Força");
                        do {
                            opcao = sc.nextInt();
                        } while (opcao < 1 && opcao > 2);
                        if (opcao == 1) {
                            j.setEstado(j.getEstado().Upgrade(opcao));
                            j.setEstado(j.getEstado().fimEstado());
                            System.out.println("Sucesso|");
                        }
                    } else {
                        if ("Cinzento".equals(j.getJogador().getNave().getCargo().get(2).getNome()) && j.getJogador().getMoney() - 5 > 0) {
                            System.out.println("Escolha o upgrade: 1 - Carga");
                            do {
                                opcao = sc.nextInt();
                            } while (opcao < 1 && opcao > 2);
                            if (opcao == 1) {
                                j.setEstado(j.getEstado().Upgrade(opcao));
                                j.setEstado(j.getEstado().fimEstado());
                                System.out.println("Sucesso|");
                            }
                        } else {
                            System.out.println("Impossivel");
                        }
                    }
                }
            }else if(opcao == 2){
                //j.setEstado(j.getEstado().fimEstado());
            }

            if ("X".equals(j.getMapa()[j.getJogador().getNave().getY()][j.getJogador().getNave().getX()].getTexto())) {
                do {
                    System.out.print("Gostaria de vender alguma da sua carga(1-sim,2-não):");
                    do {
                        opcao = sc.nextInt();
                    } while (opcao < 1 && opcao > 2);
                    if (opcao == 1) {
                        System.out.println("Precos do planeta: Azul:" + j.getMapa()[j.getJogador().getNave().getY()][j.getJogador().getNave().getX()].getCusto().get(0) + " Amarelo:" + j.getMapa()[j.getJogador().getNave().getY()][j.getJogador().getNave().getX()].getCusto().get(1) + " Vermelho:" + j.getMapa()[j.getJogador().getNave().getY()][j.getJogador().getNave().getX()].getCusto().get(2) + " Preto:" + j.getMapa()[j.getJogador().getNave().getY()][j.getJogador().getNave().getX()].getCusto().get(3));
                        System.out.println("\nEscolha a carga a vender(carga branco e cinzenta nao pode ser vendida) 1-" + j.getJogador().getNave().getCargo().get(0).getNome() + " 2-" + j.getJogador().getNave().getCargo().get(1).getNome() + " 3-" + j.getJogador().getNave().getCargo().get(2).getNome());

                        do {
                            opcao2 = sc.nextInt();
                        } while (opcao2 < 1 && opcao2 > 3);
                        opcao2 = opcao2 - 1;
                        j.setEstado(j.getEstado().Vende(opcao2));
                        j.setEstado(j.getEstado().fimEstado());
                    }else if(opcao == 2){
                        j.setEstado(j.getEstado().fimEstado());
                    }
                } while (opcao != 2);

            }
        } else {
            j.setEstado(j.getEstado().fimEstado());
        }
        mostraMapa();

        if ("P".equals(j.getMapa()[j.getJogador().getNave().getY()][j.getJogador().getNave().getX()].getTexto()) || "X".equals(j.getMapa()[j.getJogador().getNave().getY()][j.getJogador().getNave().getX()].getTexto())) {
            if ("P".equals(j.getMapa()[j.getJogador().getNave().getY()][j.getJogador().getNave().getX()].getTexto())) {
                do {
                    System.out.print("Gostaria de comprar algum recurso(1-sim,2-não):");
                    do {
                        opcao = sc.nextInt();
                    } while (opcao < 1 && opcao > 2);
                    if (opcao == 1) {
                        System.out.println("Precos do planeta: Azul:" + j.getMapa()[j.getJogador().getNave().getY()][j.getJogador().getNave().getX()].getCusto().get(0) + " Amarelo:" + j.getMapa()[j.getJogador().getNave().getY()][j.getJogador().getNave().getX()].getCusto().get(1) + " Vermelho:" + j.getMapa()[j.getJogador().getNave().getY()][j.getJogador().getNave().getX()].getCusto().get(2) + " Preto:" + j.getMapa()[j.getJogador().getNave().getY()][j.getJogador().getNave().getX()].getCusto().get(3));
                        System.out.println("\nEscolha o Recurso a comprar(carga branco e cinzenta nao pode ser compradas) 1-" + j.getMapa()[j.getJogador().getNave().getY()][j.getJogador().getNave().getX()].getRecursos().get(0).getNome() + " 2-" + j.getMapa()[j.getJogador().getNave().getY()][j.getJogador().getNave().getX()].getRecursos().get(1).getNome());
                        do {
                            opcao2 = sc.nextInt();
                        } while (opcao2 < 1 && opcao2 > 2);
                        opcao2 = opcao2 - 1;
                        j.setEstado(j.getEstado().Compra(opcao2));
                        j.setEstado(j.getEstado().fimEstado());
                    }
                } while (opcao != 2);

                System.out.println("\nGostaria de fazer algum upgrade 1 - Sim 2 - Nao");
                do {
                    opcao = sc.nextInt();
                } while (opcao < 1 && opcao > 2);
                if (opcao == 1) {
                    opcao = 0;
                    if (j.getJogador().getNave().getPower() == 3 && "Cinzento".equals(j.getJogador().getNave().getCargo().get(2).getNome())) {
                        System.out.println("Escolha o upgrade: 1 - Força(4 moedas) 2 - Carga(5 moedas)");
                        do {
                            opcao = sc.nextInt();
                        } while (opcao < 1 && opcao > 2);
                        if (opcao == 1 && j.getJogador().getMoney() - 4 > 0) {
                            j.setEstado(j.getEstado().Upgrade(opcao));
                            j.setEstado(j.getEstado().fimEstado());
                            System.out.println("Sucesso|");
                        } else {
                            if (opcao == 2 && j.getJogador().getMoney() - 5 > 0) {
                                j.setEstado(j.getEstado().Upgrade(opcao));
                                j.setEstado(j.getEstado().fimEstado());
                                System.out.println("Sucesso|");
                            } else {
                                System.out.println("Impossivel");
                            }
                        }
                    } else {
                        if (j.getJogador().getNave().getPower() == 3 && j.getJogador().getMoney() - 4 > 0) {
                            System.out.println("Escolha o upgrade: 1 - Força");
                            do {
                                opcao = sc.nextInt();
                            } while (opcao < 1 && opcao > 2);
                            if (opcao == 1) {
                                j.setEstado(j.getEstado().Upgrade(opcao));
                                j.setEstado(j.getEstado().fimEstado());
                                System.out.println("Sucesso|");
                            }
                        } else {
                            if ("Cinzento".equals(j.getJogador().getNave().getCargo().get(2).getNome()) && j.getJogador().getMoney() - 5 > 0) {
                                System.out.println("Escolha o upgrade: 1 - Carga");
                                do {
                                    opcao = sc.nextInt();
                                } while (opcao < 1 && opcao > 2);
                                if (opcao == 1) {
                                    j.setEstado(j.getEstado().Upgrade(opcao));
                                    j.setEstado(j.getEstado().fimEstado());
                                    System.out.println("Sucesso|");
                                }
                            } else {
                                System.out.println("Impossivel");
                            }
                        }
                    }
                }else if(opcao == 2){
                    j.setEstado(j.getEstado().fimEstado());
                }
            }

            if ("X".equals(j.getMapa()[j.getJogador().getNave().getY()][j.getJogador().getNave().getX()].getTexto())) {
                do {
                    System.out.print("Gostaria de comprar algum dos recursos(1-sim,2-não):");
                    do {
                        opcao = sc.nextInt();
                    } while (opcao < 1 && opcao > 2);
                    if (opcao == 1) {
                        System.out.println("Precos do planeta: Preto:1");
                        System.out.println("\nEscolha o Recurso a comprar(carga branco e cinzenta nao pode ser compradas) 1-" + j.getMapa()[j.getJogador().getNave().getY()][j.getJogador().getNave().getX()].getRecurso().getNome());

                        do {
                            opcao2 = sc.nextInt();
                        } while (opcao2 < 1 && opcao2 > 2);
                        opcao2 = opcao2 - 1;
                        j.setEstado(j.getEstado().Compra(opcao2));
                        j.setEstado(j.getEstado().fimEstado());
                    }else if(opcao == 2){
                        j.setEstado(j.getEstado().fimEstado());
                    }
                } while (opcao != 2);
                g = j.getEstado().ganha();
                if (g == 1) {
                    LimpaJanela();
                    System.out.println("Perdeu o jogo");
                    exit(0);
                }
            }
        } else {
            g = j.getEstado().ganha();
            if (g == 1) {
                LimpaJanela();
                System.out.println("Perdeu o jogo");
                exit(0);
            }
            j.setEstado(j.getEstado().fimEstado());
        }
        mostraMapa();

        Scanner sc2 = new Scanner(System.in);
        x = j.getJogador().getNave().getX();
        y = j.getJogador().getNave().getY();
        
        System.out.println("\n0-Warp !");

        if (y + 1 < 7 && j.getMapa()[y + 1][x].getCheck() == true && !" ".equals(j.getMapa()[y + 1][x].getTexto())) {
            System.out.println("\n1-Avançar para baixo");
        }

        if (y - 1 > -1 && j.getMapa()[y - 1][x].getCheck() == true && !" ".equals(j.getMapa()[y - 1][x].getTexto())) {
            System.out.println("2-Avançar para cima");
        }

        if (x + 1 < 9 && j.getMapa()[y][x + 1].getCheck() == true && !" ".equals(j.getMapa()[y][x + 1].getTexto())) {
            System.out.println("3-Avançar para a direita");
        }

        if (x - 1 > -1 && j.getMapa()[y][x - 1].getCheck() == true && !" ".equals(j.getMapa()[y][x - 1].getTexto())) {
            System.out.println("4-Avançar para a esquerda");
        }

        if (y + 1 < 7 && x + 1 < 9 && j.getMapa()[y + 1][x + 1].getCheck() == true && !" ".equals(j.getMapa()[y + 1][x + 1].getTexto())) {
            System.out.println("5-Avançar para direita e para baixo");
        }

        if (y + 1 < 7 && x - 1 > -1 && j.getMapa()[y + 1][x - 1].getCheck() == true && !" ".equals(j.getMapa()[y + 1][x - 1].getTexto())) {
            System.out.println("6-Avançar para a esquerda e para baixo");
        }

        if (y - 1 > -1 && x + 1 < 9 && j.getMapa()[y - 1][x + 1].getCheck() == true && !" ".equals(j.getMapa()[y - 1][x + 1].getTexto())) {
            System.out.println("7-Avançar para a direita e para cima");
        }

        if (y - 1 > -1 && x - 1 > -1 && j.getMapa()[y - 1][x - 1].getCheck() == true && !" ".equals(j.getMapa()[y - 1][x - 1].getTexto())) {
            System.out.println("8-Avançar para a esquerda e para cima");
        }

        if ("W".equals(j.getMapa()[y][x].getTexto())) {
            System.out.println("9-Para entrar no wormhole");
        }

        System.out.println("Escolha um dos movimentos:");
        do {
            do {
                opcao = sc2.nextInt();
            } while (opcao < 0 && opcao > 9);
            if ("W".equals(j.getMapa()[y][x].getTexto()) && opcao == 9) {
                while (conta < 4) {
                    if (j.getMapa()[j.getYTrans().get(conta)][j.getXTrans().get(conta)].getCheck() == true) {
                        System.out.println((conta + 1) + " - (" + j.getXTrans().get(conta) + "," + j.getYTrans().get(conta) + ")");
                    }
                    conta++;
                }
                System.out.println("Escolha as coodernadas do wormhole para que deseja viajar:");
                do {
                    conta = sc.nextInt();
                } while (conta < 1 && conta > 4);
                conta = conta - 1;
            }

            j.setEstado(j.getEstado().Movimento(opcao, conta));
            j.setEstado(j.getEstado().fimEstado());
        } while (opcao < 0 && opcao > 9);
    }

    void LimpaJanela() {
        int i = 0;
        while (i < 12) {
            System.out.print("\n");
            i++;
        }
    }

    public void mostraAtaquePirata(ArrayList<Integer> x) {
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

    public void mostraMapa() {
        LimpaJanela();
        System.out.println("\n\n\n");
        for(int i=0;i<7;i++)
        {
            for(int k=0;k<9;k++)
            {
                if(j.getMapa()[i][k].getCheck()==false)
                {
                    System.out.print("#  ");
                }else{
                    if(j.getJogador().getNave().getX()==k&&j.getJogador().getNave().getY()==i)
                    {
                        System.out.print(j.getMapa()[i][k].getTexto()+ "N ");
                    }else{
                       System.out.print(j.getMapa()[i][k].getTexto()+ "  ");
                    }
                }
            }
            switch(i)
            {
                case 0:{
                    System.out.println("\t\t\t\tO teu dinheiro:"+ j.getJogador().getMoney()+ "\t\t\t\t#- Espaço nao Explorado");
                    break;
                }
                case 1:{
                    System.out.println("\t\t\t\tA tua carga : "+j.getJogador().getNave().getCargo().get(0).getNome()+"/"+j.getJogador().getNave().getCargo().get(1).getNome()+"/"+j.getJogador().getNave().getCargo().get(2).getNome()+ "\t\t_ - Espaço Explorado");
                    break;
                }
                case 2:{
                    System.out.println("\t\t\t\t \t\t\t\t\t\tP - Planetas");
                    break;
                }
                case 3:{
                    System.out.println("\t\t\t\t \t\t\t\t\t\tX - Planeta de Piratas");
                    break;
                }
                case 4:{
                    System.out.println("\t\t\t\t \t\t\t\t\t\tW - WormHole");
                    break;
                }
                case 5:{
                    System.out.println("\t\t\t\t \t\t\t\t\t\tN - Nave");
                    break;
                }
                case 6:{
                    System.out.println("\t\t\t\t \t\t\t\t\t\t");
                    break;
                }                
            }
        }
    }

    public void carregar() {
        try {
            FileInputStream fin = new FileInputStream("jogo.ser");
            try (ObjectInputStream ois = new ObjectInputStream(fin)) {
                j = (Jogo) ois.readObject();
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Texto.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(Texto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Jogo getJ() {
        return j;
    }

    public void setJ(Jogo j) {
        this.j = j;
    }

    public void gravar() {
        try {
            FileOutputStream fout = new FileOutputStream("jogo.ser");
            try (ObjectOutputStream oss = new ObjectOutputStream(fout)) {
                oss.writeObject(j);
                oss.flush();
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Texto.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Texto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}