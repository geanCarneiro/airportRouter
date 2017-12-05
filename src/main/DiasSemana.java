package main;

public enum DiasSemana {
	
	Segunda,
	Terça,
	Quarta,
	Quinta,
	Sexta,
	Sabado,
	Domingo;
        
        public DiasSemana next(){
            DiasSemana[] values = DiasSemana.values();
            
            return values[(this.ordinal()+1)%values.length];
        }
        
        public static String[] valuesAsString(){
            DiasSemana[] values = DiasSemana.values();
            String[] out = new String[values.length];
            for(int i = 0; i < out.length; i++){
                out[i] = values[i].name();
            }
            
            return out;
        }
	
}
