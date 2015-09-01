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
public class EsperaCompra extends Estado implements Serializable {

    public EsperaCompra(Jogo j) {
        super(j);
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
        return new EsperaCompra(this.J);
    }

    @Override
    public Estado Compra(int escolhacompra) {
        int x = J.jogador.getNave().getX();
        int y = J.jogador.getNave().getY();
        
        int temp_old = J.jogador.getMoney();
        int prejuizo_nave_near;
        
        if(J.perto()){
            prejuizo_nave_near = 1;
        }else{
            prejuizo_nave_near = 0;
        }
        
        if ("P".equals(J.mapa[y][x].getTexto())) {
            if (!"Branco".equals(J.mapa[y][x].getRecursos().get(escolhacompra).getNome())) {
                if ("Branco".equals(J.jogador.getNave().getCargo().get(0).getNome())) {
                    if ("Azul".equals(J.mapa[y][x].getRecursos().get(escolhacompra).getNome())) {
                        J.jogador.setMoney(J.jogador.getMoney() - J.mapa[y][x].getCusto().get(0) - prejuizo_nave_near);
                    } else {
                        if ("Amarelo".equals(J.mapa[y][x].getRecursos().get(escolhacompra).getNome())) {
                            J.jogador.setMoney(J.jogador.getMoney() - J.mapa[y][x].getCusto().get(1) - prejuizo_nave_near);
                        } else {
                            if ("Vermelho".equals(J.mapa[y][x].getRecursos().get(escolhacompra).getNome())) {
                                J.jogador.setMoney(J.jogador.getMoney() - J.mapa[y][x].getCusto().get(2) - prejuizo_nave_near);
                            } else {
                                if ("Preto".equals(J.mapa[y][x].getRecursos().get(escolhacompra).getNome())) {
                                    J.jogador.setMoney(J.jogador.getMoney() - J.mapa[y][x].getCusto().get(3) - prejuizo_nave_near);
                                }
                            }
                        }
                    }
                    J.jogador.getNave().getCargo().set(0, J.mapa[y][x].getRecursos().get(escolhacompra));
                    J.mapa[y][x].getRecursos().set(escolhacompra, new RecBranco());
                } else {
                    if ("Branco".equals(J.jogador.getNave().getCargo().get(1).getNome())) {
                        if ("Azul".equals(J.mapa[y][x].getRecursos().get(escolhacompra).getNome())) {
                            J.jogador.setMoney(J.jogador.getMoney() - J.mapa[y][x].getCusto().get(0) - prejuizo_nave_near);
                        } else {
                            if ("Amarelo".equals(J.mapa[y][x].getRecursos().get(escolhacompra).getNome())) {
                                J.jogador.setMoney(J.jogador.getMoney() - J.mapa[y][x].getCusto().get(1) - prejuizo_nave_near);
                            } else {
                                if ("Vermelho".equals(J.mapa[y][x].getRecursos().get(escolhacompra).getNome())) {
                                    J.jogador.setMoney(J.jogador.getMoney() - J.mapa[y][x].getCusto().get(2) - prejuizo_nave_near);
                                } else {
                                    if ("Preto".equals(J.mapa[y][x].getRecursos().get(escolhacompra).getNome())) {
                                        J.jogador.setMoney(J.jogador.getMoney() - J.mapa[y][x].getCusto().get(3) - prejuizo_nave_near);
                                    }
                                }
                            }
                        }
                        J.jogador.getNave().getCargo().set(1, J.mapa[y][x].getRecursos().get(escolhacompra));
                        J.mapa[y][x].getRecursos().set(escolhacompra, new RecBranco());
                    } else {
                        if ("Branco".equals(J.jogador.getNave().getCargo().get(1).getNome())) {
                            if ("Azul".equals(J.mapa[y][x].getRecursos().get(escolhacompra).getNome())) {
                                J.jogador.setMoney(J.jogador.getMoney() - J.mapa[y][x].getCusto().get(0) - prejuizo_nave_near);
                            } else {
                                if ("Amarelo".equals(J.mapa[y][x].getRecursos().get(escolhacompra).getNome())) {
                                    J.jogador.setMoney(J.jogador.getMoney() - J.mapa[y][x].getCusto().get(1) - prejuizo_nave_near);
                                } else {
                                    if ("Vermelho".equals(J.mapa[y][x].getRecursos().get(escolhacompra).getNome())) {
                                        J.jogador.setMoney(J.jogador.getMoney() - J.mapa[y][x].getCusto().get(2) - prejuizo_nave_near);
                                    } else {
                                        if ("Preto".equals(J.mapa[y][x].getRecursos().get(escolhacompra).getNome())) {
                                            J.jogador.setMoney(J.jogador.getMoney() - J.mapa[y][x].getCusto().get(3) - prejuizo_nave_near);
                                        }
                                    }
                                }
                            }
                            J.jogador.getNave().getCargo().set(2, J.mapa[y][x].getRecursos().get(escolhacompra));
                            J.mapa[y][x].getRecursos().set(escolhacompra, new RecBranco());
                        } else {
                            System.out.println("Operacao Impossivel");
                        }
                    }
                }
            }
        }

        if ("X".equals(J.mapa[y][x].getTexto())) {
            if ("Branco".equals(J.jogador.getNave().getCargo().get(0).getNome())) {
                if ("Preto".equals(J.mapa[y][x].getRecurso().getNome())) {
                    J.jogador.setMoney(J.jogador.getMoney() - 1 - prejuizo_nave_near);
                }
                J.jogador.getNave().getCargo().set(0, J.mapa[y][x].getRecurso());
                J.mapa[y][x].setRecurso(new RecBranco());
            } else {
                if ("Branco".equals(J.jogador.getNave().getCargo().get(1).getNome())) {
                    if ("Preto".equals(J.mapa[y][x].getRecurso().getNome())) {
                        J.jogador.setMoney(J.jogador.getMoney() - 1 - prejuizo_nave_near);
                    }
                    J.jogador.getNave().getCargo().set(1, J.mapa[y][x].getRecurso());
                    J.mapa[y][x].setRecurso(new RecBranco());

                } else {
                    if ("Branco".equals(J.jogador.getNave().getCargo().get(2).getNome())) {
                        if ("Preto".equals(J.mapa[y][x].getRecurso().getNome())) {
                            J.jogador.setMoney(J.jogador.getMoney() - 1 - prejuizo_nave_near);
                        }
                        J.jogador.getNave().getCargo().set(2, J.mapa[y][x].getRecurso());
                        J.mapa[y][x].setRecurso(new RecBranco());
                    }
                }
            }
        }

        return new EsperaCompra(this.J);
    }

    @Override
    public Estado Movimento(int opcao, int conta) {
        return this;
    }

    @Override
    public Estado Vende(int escolhavenda) {
        switch(escolhavenda){
            case 1:
                J.jogador.getNave().getCargo().set(1, new RecBranco());
                J.jogador.getNave().getCargo().set(2, new RecBranco());
                break;
            case 2:
                J.jogador.getNave().getCargo().set(0, new RecBranco());
                J.jogador.getNave().getCargo().set(2, new RecBranco());
                break;
            case 3:
                J.jogador.getNave().getCargo().set(0, new RecBranco());
                J.jogador.getNave().getCargo().set(1, new RecBranco());
                break;
        }
        return new EsperaCompra(this.J);
    }

    @Override
    public Estado fimEstado() {
        return new EsperaMovimento(this.J);
    }

    @Override
    public Estado Recomeca() {
        Jogo j=new Jogo();
        return j.getEstado();
    }

    @Override
    public void fimJogo() {
        exit(0);
    }

    @Override
    public int ganha() {
        if(J.jogador.getMoney()<-10)
        {
            return 1;
        }
        
        for(int i=0;i<7;i++)
        {
            for(int j=0;j<9;j++)
            {
                if(J.mapa[i][j].getCheck()==false)
                {
                   return 2;
                }
            }
        }
        
        return 0;
    }
    
}
