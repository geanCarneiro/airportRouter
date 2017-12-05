/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.listaEncadeada;

import java.util.ArrayList;
import java.util.List;
import main.Voo;

/**
 *
 * @author Gean
 */
public class ListaEncadeada<T>{
    
    private No prim;
    private No ult;
    
    public void add(T info){
        No novo = new No(info);
        
        if(this.prim == null)
            this.prim = novo;
        else
            this.ult.setProx(novo);
        
        this.ult = novo;        
    }
    
    public void addInicio(Voo info){
        No novo = new No(info);
        
        novo.setProx(this.prim);
        this.prim = novo;
        if(this.ult == null)
            this.ult = novo;
    }
    
    
    public No getUlt() {
        return ult;
    }

    public void setUlt(No ult) {
        this.ult = ult;
    }
    
    public No getPrim() {
        return prim;
    }

    public void setPrim(No prim) {
        this.prim = prim;
    }
    
    public boolean isVazio(){
        return this.prim == null;
    }
    
    public List<Object> getAsList(){
        
        List<Object> out = new ArrayList<>();
        
        No atual = this.prim;
        
        while(atual != null){
            out.add(atual.getInfo());
            atual = atual.getProx();
        }
        
        return out;
    }
    
    public void limpar(){
        this.prim = null;
    }

    
    
}
