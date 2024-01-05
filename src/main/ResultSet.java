/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

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
    
    public static String deAccent(String str) {
        String nfdNormalizedString = Normalizer.normalize(str, Normalizer.Form.NFD); 
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        return pattern.matcher(nfdNormalizedString).replaceAll("");
    }
    
    public void filtraCodVoo(String cod){
        
        if(cod == null || cod.isEmpty())
            return;
            
        Iterator<Voo> it = this.list.iterator();
        while(it.hasNext()){
            Voo voo = it.next();
            if(!deAccent(voo.getCodVoo()).toUpperCase().contains(deAccent(cod).toUpperCase())){
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
            if(!deAccent(voo.getCodAviao()).toUpperCase().contains(deAccent(cod).toUpperCase())){
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
            if((!deAccent(voo.getAeroportoSaida().getIcao()).toUpperCase().contains(deAccent(name).toUpperCase()))
            && (!deAccent(voo.getAeroportoSaida().getName()).toUpperCase().contains(deAccent(name).toUpperCase()))){
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
            if((!deAccent(voo.getAeroportoChegada().getIcao()).toUpperCase().contains(deAccent(name).toUpperCase()))
            && (!deAccent(voo.getAeroportoChegada().getName()).toUpperCase().contains(deAccent(name).toUpperCase()))){
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
