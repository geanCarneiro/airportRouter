/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Gean
 */
public class CustomComboBoxModel extends DefaultComboBoxModel<String>{

    private DiasSemana[] values;
    
    public CustomComboBoxModel() {
        
        values = DiasSemana.values();
        
        for (DiasSemana value : values) {
            this.addElement(value.name());
        }
    
    }
    
    @Override
    public String getElementAt(int index) {
        return this.values[index].name(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getSelectedItem() {
        return DiasSemana.valueOf((String)super.getSelectedItem()); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
}
