/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicaJogo;

import java.io.Serializable;

/**
 *
 * @author Rafael
 */
public abstract class Estado implements Serializable {

    public Jogo J;

    public Estado(Jogo j) {
        this.J = j;
    }

    abstract public Estado Upgrade(int escolha);

    abstract public Estado Compra(int escolhacompra);

    abstract public Estado Movimento(int opcao, int conta);

    abstract public Estado Vende(int escolhavenda);

    abstract public Estado fimEstado();

    abstract public Estado Recomeca();

    abstract public void fimJogo();

    abstract public int ganha();
}