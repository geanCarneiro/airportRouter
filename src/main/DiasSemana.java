package main;

import java.util.Arrays;
import java.util.stream.Collectors;

public enum DiasSemana {
	
	Segunda,
	Terca,
	Quarta,
	Quinta,
	Sexta,
	Sabado,
	Domingo;
        
        public DiasSemana next(){
        	
            DiasSemana[] values = DiasSemana.values();
            
            return values[(this.ordinal()+1) % values.length];
        }
        
        public static String[] valuesAsString(){
        	
        	return Arrays.asList(DiasSemana.values())
        		.stream().map(dia -> dia.name())
        		.collect(Collectors.toList()).toArray(new String[0]);
        	
        }
	
}
