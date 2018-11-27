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

public class ABB extends NoArvore{
    private NoArvore raizPrincipal;
    private boolean alturaModificada = false;

    public boolean isAlturaModificada() {
        return alturaModificada;
    }

    public void setAlturaModificada(boolean alturaModificada) {
        this.alturaModificada = alturaModificada;
    }

    public NoArvore getRaizPrincipal() {
        return raizPrincipal;
    }

    public void setRaizPrincipal(NoArvore raizPrincipal) {
        this.raizPrincipal = raizPrincipal;
    }

    public NoArvore buscarRecursivamente(NoArvore t, int x){
        if( t == null ){
            return null;
        }else{
            if( t.getInformacao() == x ){
                return t;
            }else{
                if( t.getInformacao() > x ){
                    return buscarRecursivamente(t.getProximoEsquerda(), x);
                }else{
                    return buscarRecursivamente(t.getProximoDireita(), x);
                }
            }
        }
    }

    public void inicializa(){
        // perguntar
    }

    public void inserirRecursivamente(NoArvore p, int valor){
        // h só é verdadeiro se a altura da árvore de raiz p for alterada
        if( p == null ){
            gerarNovoNoArvore(p, valor);
            this.setAlturaModificada(true);
            // perguntar
        }else if( valor < p.getInformacao() ){
            inserirRecursivamente(p.getProximoEsquerda(), valor);
            if( this.isAlturaModificada() ){ // sub árvore a esqueda teve alteração de altura
               if( p.getBalanceamentoNo() == 1 ){
                   p.setBalanceamentoNo(0);
                   this.setAlturaModificada(false);
               }else if( p.getBalanceamentoNo() == 0 ){
                   p.setBalanceamentoNo(-1);
               }else if( p.getBalanceamentoNo() == -1 ){
                   rotacionarArvoreParaDireita(p);
               }
            }
        }else if( valor > p.getInformacao() ){
            inserirRecursivamente(p.getProximoDireita(), valor);
            if( this.isAlturaModificada() ){
                if( p.getBalanceamentoNo() == -1 ){
                     p.setBalanceamentoNo(0);
                     this.setAlturaModificada(false);
                 }else if( p.getBalanceamentoNo() == 0 ){
                     p.setBalanceamentoNo(1);
                 }else if( p.getBalanceamentoNo() == 1 ){
                     rotacionarArvoreParaEsquerda(p);
                 }
            }
        }
    }

    public void rotacionarArvoreParaDireita(NoArvore p){
        NoArvore u = p.getProximoEsquerda();
        if( u.getBalanceamentoNo() == -1 ){
            p.setProximoEsquerda(u.getProximoDireita());
            u.setProximoDireita(p);
            p.setBalanceamentoNo(0);
            p = u;
        }else{
            NoArvore v = u.getProximoDireita();
            u.setProximoDireita(v.getProximoEsquerda());
            v.setProximoEsquerda(u);
            p.setProximoEsquerda(v.getProximoDireita());
            v.setProximoDireita(p);
            if( v.getBalanceamentoNo() == 0 ){
                u.setBalanceamentoNo(0);
                p.setBalanceamentoNo(0);
            }else if( v.getBalanceamentoNo() == -1 ){
                u.setBalanceamentoNo(0);
                p.setBalanceamentoNo(1);
            }else{
                u.setBalanceamentoNo(-1);
                p.setBalanceamentoNo(0);
            }
            p = v;
        }
        p.setBalanceamentoNo(0);
        this.setAlturaModificada(false);
    }

    public void rotacionarArvoreParaEsquerda(NoArvore p){
        NoArvore u = p.getProximoDireita();
        if( u.getBalanceamentoNo() == 1 ){
            p.setProximoDireita(u.getProximoEsquerda());
            u.setProximoEsquerda(p);
            p.setBalanceamentoNo(0);
            p = u;
        }else{
            NoArvore v = u.getProximoEsquerda();
            u.setProximoEsquerda(v.getProximoDireita());
            v.setProximoDireita(u);
            p.setProximoDireita(v.getProximoEsquerda());
            v.setProximoEsquerda(p);
            if( v.getBalanceamentoNo() == 1 ){
                u.setBalanceamentoNo(-1);
                p.setBalanceamentoNo(0);
            }else if( v.getBalanceamentoNo() == 0 ){
                u.setBalanceamentoNo(0);
                p.setBalanceamentoNo(1);
            }else{
                u.setBalanceamentoNo(0);
                p.setBalanceamentoNo(1);
            }
            p = v;
        }
        p.setBalanceamentoNo(0);
        
        this.setAlturaModificada(false);
    }

    public void gerarNovoNoArvore(NoArvore p, int x){
        p.setInformacao(x);
        p.setProximoDireita(null);
        p.setProximoEsquerda(null);
        p.setBalanceamentoNo(0);
    }

    public NoArvore removerRecursivamente(NoArvore t, int x){
        if( t != null ){
            if( x < t.getInformacao() ){
                return removerRecursivamente(t.getProximoEsquerda(), x);
            }else{
                if( x > t.getInformacao() ){
                    return removerRecursivamente(t.getProximoDireita(), x);
                }else{
                    if( t.getProximoEsquerda() == null ){
                        t = t.getProximoDireita();
                    }else{
                        if( t.getProximoDireita() == null ){
                            t = t.getProximoEsquerda();
                        }else{
                            NoArvore p, r;
                            r = t;
                            p = t.getProximoDireita();

                            while( p.getProximoEsquerda() != null ){
                                r = p;
                                p = p.getProximoEsquerda();
                            }

                            t.setInformacao(p.getInformacao());

                            if( t == r ){
                                r.setProximoDireita(p.getProximoDireita());
                            }else{
                                r.setProximoEsquerda(p.getProximoEsquerda());
                            }
                        }
                    }
                }
            }
            return null;
        }else{
            return null;
        }
    }

    public void imprimir(){
        
    }

    public ABB(){
        this.inicializa();
    }
}