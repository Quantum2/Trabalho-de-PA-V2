/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicaJogo;

import MW.Recs.RecBranco;
import java.io.Serializable;

/**
 *
 * @author Rafael
 */
public class EsperaVenda extends Estado implements Serializable {

    public EsperaVenda(Jogo j) {
        super(j);
    }

    @Override
    public Estado Vende(int escolhavenda)        
    {
        int x=J.jogador.getNave().getX();
        int y=J.jogador.getNave().getY();
        
        if("P".equals(J.mapa[y][x].getTexto()))
        {
                if(!"Branco".equals(J.jogador.getNave().getCargo().get(escolhavenda).getNome()) && !"Cinzento".equals(J.jogador.getNave().getCargo().get(escolhavenda).getNome()))
                {
                    if(!"Branco".equals(J.mapa[y][x].getRecursos().get(0).getNome()))
                    {
                        if("Azul".equals(J.jogador.getNave().getCargo().get(escolhavenda).getNome()))
                        {
                            J.jogador.setMoney(J.jogador.getMoney()+J.mapa[y][x].getCusto().get(0));
                        }else{
                            if("Amarelo".equals(J.jogador.getNave().getCargo().get(escolhavenda).getNome()))
                            {
                                J.jogador.setMoney(J.jogador.getMoney()+J.mapa[y][x].getCusto().get(1));
                            }else{
                                if("Vermelho".equals(J.jogador.getNave().getCargo().get(escolhavenda).getNome()))
                                {
                                    J.jogador.setMoney(J.jogador.getMoney()+J.mapa[y][x].getCusto().get(2));
                                }else{
                                    if("Preto".equals(J.jogador.getNave().getCargo().get(escolhavenda).getNome()))
                                    {
                                        J.jogador.setMoney(J.jogador.getMoney()+J.mapa[y][x].getCusto().get(3));
                                    }
                                }
                            }
                        }
                        if(!"Preto".equals(J.jogador.getNave().getCargo().get(escolhavenda).getNome()))
                        {
                            J.mapa[y][x].getRecursos().set(0,J.jogador.getNave().getCargo().get(escolhavenda));
                            J.jogador.getNave().getCargo().set(escolhavenda, new RecBranco());
                        }else{
                            J.jogador.getNave().getCargo().set(escolhavenda, new RecBranco());
                        }
                    }else{
                        if(!"Branco".equals(J.mapa[y][x].getRecursos().get(1).getNome()))
                        {
                            if("Azul".equals(J.jogador.getNave().getCargo().get(escolhavenda).getNome()))
                            {
                                J.jogador.setMoney(J.jogador.getMoney()+J.mapa[y][x].getCusto().get(0));
                            }else{
                                if("Amarelo".equals(J.jogador.getNave().getCargo().get(escolhavenda).getNome()))
                                {
                                    J.jogador.setMoney(J.jogador.getMoney()+J.mapa[y][x].getCusto().get(1));
                                }else{
                                    if("Vermelho".equals(J.jogador.getNave().getCargo().get(escolhavenda).getNome()))
                                    {
                                        J.jogador.setMoney(J.jogador.getMoney()+J.mapa[y][x].getCusto().get(2));
                                    }else{
                                        if("Preto".equals(J.jogador.getNave().getCargo().get(escolhavenda).getNome()))
                                        {
                                            J.jogador.setMoney(J.jogador.getMoney()+J.mapa[y][x].getCusto().get(3));
                                        }
                                    }
                                }
                            }
                        if(!"Preto".equals(J.jogador.getNave().getCargo().get(escolhavenda).getNome()))
                        {
                            J.mapa[y][x].getRecursos().set(0,J.jogador.getNave().getCargo().get(escolhavenda));
                            J.jogador.getNave().getCargo().set(escolhavenda, new RecBranco());
                        }else{
                            J.jogador.getNave().getCargo().set(escolhavenda, new RecBranco());
                        }
                        }else{
                            System.out.println("Operacao Impossivel");
                        }
                    }
                }else{
                    System.out.println("Operacao Impossivel");
                    } 
        }
        
        if("X".equals(J.mapa[y][x].getTexto()))
        {
                if(!"Branco".equals(J.jogador.getNave().getCargo().get(escolhavenda).getNome()) && !"Cinzento".equals(J.jogador.getNave().getCargo().get(escolhavenda).getNome()) )
                {
                    if("Azul".equals(J.jogador.getNave().getCargo().get(escolhavenda).getNome()))
                        {
                            J.jogador.setMoney(J.jogador.getMoney()+J.mapa[y][x].getCusto().get(0));
                        }else{
                            if("Amarelo".equals(J.jogador.getNave().getCargo().get(escolhavenda).getNome()))
                            {
                                J.jogador.setMoney(J.jogador.getMoney()+J.mapa[y][x].getCusto().get(1));
                            }else{
                                if("Vermelho".equals(J.jogador.getNave().getCargo().get(escolhavenda).getNome()))
                                {
                                    J.jogador.setMoney(J.jogador.getMoney()+J.mapa[y][x].getCusto().get(2));
                                }else{
                                    if("Preto".equals(J.jogador.getNave().getCargo().get(escolhavenda).getNome()))
                                    {
                                        J.jogador.setMoney(J.jogador.getMoney()+J.mapa[y][x].getCusto().get(3));
                                    }
                                }
                            }
                        }
                J.jogador.getNave().getCargo().set(escolhavenda, new RecBranco());               
                }
            }
        
        return new EsperaVenda(this.J);
    }
    
    @Override
    public Estado Upgrade(int escolha) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Estado Compra(int escolhacompra) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Estado Movimento(int opcao, int conta) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Estado fimEstado() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Estado Recomeca() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void fimJogo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int ganha() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
