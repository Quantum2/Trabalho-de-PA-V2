/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicaJogo;

import MW.Recs.RecBranco;
import java.io.Serializable;
import static java.lang.System.exit;

/**
 *
 * @author Rafael
 */
public class EsperaVenda extends Estado implements Serializable {

    public EsperaVenda(Jogo j) {
        super(j);
    }

    @Override
    public Estado Vende(int escolhavenda) {
        int x = J.jogador.getNave().getX();
        int y = J.jogador.getNave().getY();
        
        int temp_old = J.jogador.getMoney();
        int custo_nave_near;
        
        if(J.perto()){
            custo_nave_near = 1;
        }else{
            custo_nave_near = 0;
        }

        if ("P".equals(J.mapa[y][x].getTexto())) {
            if (!"Branco".equals(J.jogador.getNave().getCargo().get(escolhavenda).getNome()) && !"Cinzento".equals(J.jogador.getNave().getCargo().get(escolhavenda).getNome())) {
                if (!"Branco".equals(J.mapa[y][x].getRecursos().get(0).getNome())) {
                    if ("Azul".equals(J.jogador.getNave().getCargo().get(escolhavenda).getNome())) {
                        J.jogador.setMoney(J.jogador.getMoney() + J.mapa[y][x].getCusto().get(0));
                    } else {
                        if ("Amarelo".equals(J.jogador.getNave().getCargo().get(escolhavenda).getNome())) {
                            J.jogador.setMoney(J.jogador.getMoney() + J.mapa[y][x].getCusto().get(1));
                        } else {
                            if ("Vermelho".equals(J.jogador.getNave().getCargo().get(escolhavenda).getNome())) {
                                J.jogador.setMoney(J.jogador.getMoney() + J.mapa[y][x].getCusto().get(2));
                            } else {
                                if ("Preto".equals(J.jogador.getNave().getCargo().get(escolhavenda).getNome())) {
                                    J.jogador.setMoney(J.jogador.getMoney() + J.mapa[y][x].getCusto().get(3));
                                }
                            }
                        }
                    }
                    if (!"Preto".equals(J.jogador.getNave().getCargo().get(escolhavenda).getNome())) {
                        J.mapa[y][x].getRecursos().set(0, J.jogador.getNave().getCargo().get(escolhavenda));
                        J.jogador.getNave().getCargo().set(escolhavenda, new RecBranco());
                    } else {
                        J.jogador.getNave().getCargo().set(escolhavenda, new RecBranco());
                    }
                } else {
                    if (!"Branco".equals(J.mapa[y][x].getRecursos().get(1).getNome())) {
                        if ("Azul".equals(J.jogador.getNave().getCargo().get(escolhavenda).getNome())) {
                            J.jogador.setMoney(J.jogador.getMoney() + J.mapa[y][x].getCusto().get(0));
                        } else {
                            if ("Amarelo".equals(J.jogador.getNave().getCargo().get(escolhavenda).getNome())) {
                                J.jogador.setMoney(J.jogador.getMoney() + J.mapa[y][x].getCusto().get(1));
                            } else {
                                if ("Vermelho".equals(J.jogador.getNave().getCargo().get(escolhavenda).getNome())) {
                                    J.jogador.setMoney(J.jogador.getMoney() + J.mapa[y][x].getCusto().get(2));
                                } else {
                                    if ("Preto".equals(J.jogador.getNave().getCargo().get(escolhavenda).getNome())) {
                                        J.jogador.setMoney(J.jogador.getMoney() + J.mapa[y][x].getCusto().get(3));
                                    }
                                }
                            }
                        }
                        if (!"Preto".equals(J.jogador.getNave().getCargo().get(escolhavenda).getNome())) {
                            J.mapa[y][x].getRecursos().set(0, J.jogador.getNave().getCargo().get(escolhavenda));
                            J.jogador.getNave().getCargo().set(escolhavenda, new RecBranco());
                        } else {
                            J.jogador.getNave().getCargo().set(escolhavenda, new RecBranco());
                        }
                    } else {
                        System.out.println("Operacao Impossivel");
                    }
                }
            } else {
                System.out.println("Operacao Impossivel");
            }
        }

        if ("X".equals(J.mapa[y][x].getTexto())) {
            if (!"Branco".equals(J.jogador.getNave().getCargo().get(escolhavenda).getNome()) && !"Cinzento".equals(J.jogador.getNave().getCargo().get(escolhavenda).getNome())) {
                if ("Azul".equals(J.jogador.getNave().getCargo().get(escolhavenda).getNome())) {
                    J.jogador.setMoney(J.jogador.getMoney() + J.mapa[y][x].getCusto().get(0));
                } else {
                    if ("Amarelo".equals(J.jogador.getNave().getCargo().get(escolhavenda).getNome())) {
                        J.jogador.setMoney(J.jogador.getMoney() + J.mapa[y][x].getCusto().get(1));
                    } else {
                        if ("Vermelho".equals(J.jogador.getNave().getCargo().get(escolhavenda).getNome())) {
                            J.jogador.setMoney(J.jogador.getMoney() + J.mapa[y][x].getCusto().get(2));
                        } else {
                            if ("Preto".equals(J.jogador.getNave().getCargo().get(escolhavenda).getNome())) {
                                J.jogador.setMoney(J.jogador.getMoney() + J.mapa[y][x].getCusto().get(3));
                            }
                        }
                    }
                }
                J.jogador.getNave().getCargo().set(escolhavenda, new RecBranco());
            }
        }
        
        if(temp_old != J.jogador.getMoney() && J.isSuborno()){
            J.jogador.setMoney(((J.jogador.getMoney() - temp_old) * 2) + J.jogador.getMoney());
        }

        return new EsperaVenda(this.J);
    }

    @Override
    public Estado Upgrade(int escolha) {
        if (escolha == 1) {
            J.jogador.getNave().setPower(5);
            J.jogador.setMoney(J.jogador.getMoney() - 4);
        } else {
            if (escolha == 2 && J.jogador.getMoney() - 5 > 0) {
                J.jogador.getNave().getCargo().set(2, new RecBranco());
            }
        }
        return new EsperaVenda(this.J);
    }

    @Override
    public Estado Compra(int escolhacompra) {
        return this;
    }

    @Override
    public Estado Movimento(int opcao, int conta) {
        return this;
    }

    @Override
    public Estado fimEstado() {
        return new EsperaCompra(this.J);
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