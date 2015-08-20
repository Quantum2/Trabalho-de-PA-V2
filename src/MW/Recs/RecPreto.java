/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MW.Recs;

import java.io.Serializable;

/**
 *
 * @author Rafael
 */
public class RecPreto extends Recs implements Serializable {
    String nome = "Preto";

    public RecPreto() {
    }

    @Override
    public void setNome(String n) {
        this.nome = n;
    }

    @Override
    public String getNome() {
        return nome;
    }
}
