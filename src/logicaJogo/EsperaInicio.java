/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicaJogo;

import java.io.Serializable;
import static java.lang.System.exit;

/**
 *
 * @author Rafael
 */
public class EsperaInicio extends Estado implements Serializable {

    public EsperaInicio(Jogo j) {
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
        return this;
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
