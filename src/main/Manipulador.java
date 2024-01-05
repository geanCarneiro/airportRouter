/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.awt.Container;
import java.util.List;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Gean
 */
public class Manipulador {
    
    public static PlanoDeVoo planoDeVooFromVooInList(List<VooIn> vooList) {
    	PlanoDeVoo out = new PlanoDeVoo();
        
        for(VooIn reg: vooList) {
            
            out.addVoo(reg.getDiasDisponives(),
            		reg.getCodVoo(),
            		reg.getCodAviao(),
            		reg.getHoraDeSaida_aeroportoSaida(),
            		reg.getHoraDeChegada_aeroportoChegada()
            );
            
        }
        
        return out;
    }
    
    public static int getTimeInMin(int[] time){
        return time[0]*60 + time[1];
    }
    
    public static int[] getMinInTime(int time){
        return new int[]{time/60, time%60};
    }
    
    public static DefaultTableModel tableModelFromPlano(PlanoDeVoo plano){
        
        return tableModelFromVoos(plano.getVoos());
        
    }
    
    public static DefaultTableModel tableModelFromVoos(List<Voo> voos){
        
        String[][] data = new String[voos.size()][Voo.INFOSDISPONIVEIS.length];
        int pos = 0;
        
        for(Voo voo: voos){
            data[pos] = voo.getInfos();
            pos++;
        }
        
        DefaultTableModel out = new DefaultTableModel(data, Voo.INFOSDISPONIVEIS){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; //To change body of generated methods, choose Tools | Templates.
            }
            
        };
        
        
        return out;
        
    }
    
}
