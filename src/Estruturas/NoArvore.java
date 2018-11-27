/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Estruturas;

/**
 *
 * @author kaio_
 */

public class NoArvore {
    int informacao; // será a chave do nó, o valor interno do objeto
    NoArvore proximoEsquerda; // apontador para o próximo objeto a esquerda
    NoArvore proximoDireita; // apontador para o próximo objeto a direita
    int balanceamentoNo; // tera o valor de identificação de que esse nó árvore está ou não necessitando de balanceamento

    public int getInformacao() {
        return informacao;
    }

    public void setInformacao(int informacao) {
        this.informacao = informacao;
    }

    public NoArvore getProximoEsquerda() {
        return proximoEsquerda;
    }

    public void setProximoEsquerda(NoArvore proximoEsquerda) {
        this.proximoEsquerda = proximoEsquerda;
    }

    public NoArvore getProximoDireita() {
        return proximoDireita;
    }

    public void setProximoDireita(NoArvore proximoDireita) {
        this.proximoDireita = proximoDireita;
    }

    public int getBalanceamentoNo() {
        return balanceamentoNo;
    }

    public void setBalanceamentoNo(int balanceamentoNo) {
        this.balanceamentoNo = balanceamentoNo;
    }
}