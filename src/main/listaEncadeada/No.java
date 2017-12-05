/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.listaEncadeada;

import main.Voo;

/**
 *
 * @author Gean
 */
public class No<T> {
    
    private T info;
    private No prox;

    public No(T info) {
        this.info = info;
    }
    
    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public No getProx() {
        return prox;
    }

    public void setProx(No prox) {
        this.prox = prox;
    }
    
    
    
}
