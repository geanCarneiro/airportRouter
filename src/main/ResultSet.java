/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Gean
 */
public class ResultSet {
    
    private List<Voo> list;
    private List<Voo> original;

    public ResultSet(List<Voo> list) {
        this.original = list;
        this.list = new ArrayList<>();
        limparFiltro();
    }
    
    public void filtraCodVoo(String cod){
        
        if(cod == null || cod.isEmpty())
            return;
            
        Iterator<Voo> it = this.list.iterator();
        while(it.hasNext()){
            Voo voo = it.next();
            if(!voo.getCodVoo().toUpperCase().contains(cod.toUpperCase())){
                it.remove();
            }
        }
        
    }
    
    public void filtraCodAviao(String cod){
        
        if(cod == null || cod.isEmpty())
            return;
            
        Iterator<Voo> it = this.list.iterator();
        while(it.hasNext()){
            Voo voo = it.next();
            if(!voo.getCodAviao().toUpperCase().contains(cod.toUpperCase())){
                it.remove();
            }
        }
        
    }
    
    public void filtraAeroPartida(String name){
        
        if(name == null || name.isEmpty())
            return;
            
        Iterator<Voo> it = this.list.iterator();
        while(it.hasNext()){
            Voo voo = it.next();
            if((!voo.getAeroportoSaida().getIcao().toUpperCase().contains(name.toUpperCase()))
            && (!voo.getAeroportoSaida().getName().toUpperCase().contains(name.toUpperCase()))){
                it.remove();
            }
        }
        
    }
    
    public void filtraAeroChegada(String name){
        
        if(name == null || name.isEmpty())
            return;
            
        Iterator<Voo> it = this.list.iterator();
        while(it.hasNext()){
            Voo voo = it.next();
            if((!voo.getAeroportoChegada().getIcao().toUpperCase().contains(name.toUpperCase()))
            && (!voo.getAeroportoChegada().getName().toUpperCase().contains(name.toUpperCase()))){
                it.remove();
            }
        }
        
    }
    
    public List<Voo> getList() {
        return list;
    }
    
    public List<Voo> getOriginal() {
        return original;
    }

    public void setOriginal(List<Voo> original) {
        this.original = original;
        limparFiltro();
    }
    
    public void limparFiltro(){
        this.list.clear();
        this.list.addAll(this.original);
    }
    
    
    
}
