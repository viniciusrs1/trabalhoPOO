/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho.DAO;

import trabalho.model.Comissao;

/**
 *
 * @author vinic_oh1fkpu
 */
public class ComissaoDAO {

    private static Comissao[] comissoes = new Comissao[5];
    private static boolean inicializado = false;

    public ComissaoDAO() {
        if (!inicializado) {

            inicializado = true;
        }

    }

    public boolean adiciona(Comissao c) {
        int proximaPosicaoLivre = this.proximaPosicaoLivre();
        if (proximaPosicaoLivre != -1) {
            comissoes[proximaPosicaoLivre] = c;
            return true;
        } else {
            return false;
        }

    }

    public Comissao[] listar() {
        return comissoes;
    }

    public void removerPorId(long id) {
        for (int i = 0; i < comissoes.length; i++) {
            if (comissoes[i] != null && comissoes[i].getId() == id) {
                comissoes[i] = null;
            }
        }
    }

    public Comissao buscaPorId(long id) {
        for (Comissao i : comissoes) {
            if (i != null && i.getId() == id) {
                return i;
            }
        }
        return null;

    }

    private int proximaPosicaoLivre() {
        for (int i = 0; i < comissoes.length; i++) {
            if (comissoes[i] == null) {
                return i;
            }

        }
        return -1;

    }
}
