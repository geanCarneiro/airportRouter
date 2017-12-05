package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Voo{
	
        public static final String[] INFOSDISPONIVEIS = {
                "Dias Disponives",
                "Codigo do Voo",
                "Codigo do Aviao",
                "Hora de Saida",
                "Aeroporto de Saida",
                "Hora de Chegada",
                "Aeroporto de Chegada"
        };
    
	private List<DiasSemana> diasDisponives = new ArrayList<>();
	private String codVoo;
	private String codAviao;
	private int[] horaDeSaida = new int[2];
	private Aeroporto aeroportoSaida;
	private int[] horaDeChegada = new int[2];
	private Aeroporto aeroportoChegada;

	public Voo() {
		
	}

	public Voo(List<DiasSemana> diasDisponives, String codVoo, String codAviao, int[] horaDeSaida,
			Aeroporto aeroportoSaida, int[] horaDeChegada, Aeroporto aeroportoChegada) {
		this();
		this.diasDisponives = diasDisponives;
		this.codVoo = codVoo;
		this.codAviao = codAviao;
		this.horaDeSaida = horaDeSaida;
		this.aeroportoSaida = aeroportoSaida;
		this.horaDeChegada = horaDeChegada;
		this.aeroportoChegada = aeroportoChegada;
	}


	public Voo(String diasDisponives, String codVoo, String codAviao, String horaDeSaida,
			Aeroporto aeroportoSaida, String horaDeChegada, Aeroporto aeroportoChegada) {
		this();
		for(char c: diasDisponives.toCharArray()) {
			int i = Integer.valueOf(c + "");
			
			if(i != 0)
				this.diasDisponives.add(DiasSemana.values()[i-1]);
		}
		
		this.codVoo = codVoo;
		this.codAviao = codAviao;
		this.horaDeSaida = new int[]{
				Integer.valueOf(horaDeSaida.substring(0, 2)),
				Integer.valueOf(horaDeSaida.substring(2))
		};
		this.aeroportoSaida = aeroportoSaida;
		this.horaDeChegada = new int[] {
				Integer.valueOf(horaDeChegada.substring(0, 2)),
				Integer.valueOf(horaDeChegada.substring(2))
		};
		this.aeroportoChegada = aeroportoChegada;
	}
	
        public String[] getInfos(){
            String[] out = new String[7];
            
            out[0] = "";
            diasDisponives.forEach((dia) -> {
                if(dia != diasDisponives.get(0))
                    out[0] += ", ";
                    
                out[0] += dia.name().substring(0, 3);
            });
            out[1] = codVoo;
            out[2] = codAviao;
            out[3] = String.format("%02d:%02d", horaDeSaida[0], horaDeSaida[1]);
            out[4] = aeroportoSaida.toString();
            out[5] = String.format("%02d:%02d", horaDeChegada[0], horaDeChegada[1]);
            out[6] = aeroportoChegada.toString();
            
            return out;
        }
        
	public int getTempoDeVoo() {
		
            if(this.horaDeChegada[0] > this.horaDeSaida[0]){
                int horaSaida = Manipulador.getTimeInMin(this.horaDeSaida);
                int horaChegada = Manipulador.getTimeInMin(this.horaDeChegada);
                
                return horaChegada - horaSaida;
            } else {
                return 24*60 - Manipulador.getTimeInMin(subTempo(horaDeSaida, horaDeChegada));
            }
	}
       
	public int[] subTempo(int[] t1, int[] t2) {
		
            int difHora = t1[0] - t2[0];
            int difMin = t1[1] - t2[1];
            
            if(difMin < 0){
                difHora--;
                difMin += 60;
            }
            
            return new int[]{difHora, difMin};
	}


    public List<DiasSemana> getDiasDisponives() {
            return diasDisponives;
    }

    public void setDiasDisponives(List<DiasSemana> diasDisponives) {
            this.diasDisponives = diasDisponives;
    }

    public String getCodVoo() {
            return codVoo;
    }

    public void setCodVoo(String codVoo) {
            this.codVoo = codVoo;
    }

    public String getCodAviao() {
            return codAviao;
    }

    public void setCodAviao(String codAviao) {
            this.codAviao = codAviao;
    }

    public int[] getHoraDeSaida() {
            return horaDeSaida;
    }

    public void setHoraDeSaida(int[] horaDeSaida) {
            this.horaDeSaida = horaDeSaida;
    }

    public Aeroporto getAeroportoSaida() {
            return aeroportoSaida;
    }

    public void setAeroportoSaida(Aeroporto aeroportoSaida) {
            this.aeroportoSaida = aeroportoSaida;
    }

    public int[] getHoraDeChegada() {
            return horaDeChegada;
    }

    public void setHoraDeChegada(int[] horaDeChegada) {
            this.horaDeChegada = horaDeChegada;
    }

    public Aeroporto getAeroportoChegada() {
            return aeroportoChegada;
    }

    public void setAeroportoChegada(Aeroporto aeroportoChegada) {
            this.aeroportoChegada = aeroportoChegada;
    }

    @Override
    public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((aeroportoChegada == null) ? 0 : aeroportoChegada.hashCode());
            result = prime * result + ((aeroportoSaida == null) ? 0 : aeroportoSaida.hashCode());
            result = prime * result + ((codAviao == null) ? 0 : codAviao.hashCode());
            result = prime * result + ((codVoo == null) ? 0 : codVoo.hashCode());
            result = prime * result + ((diasDisponives == null) ? 0 : diasDisponives.hashCode());
            result = prime * result + Arrays.hashCode(horaDeChegada);
            result = prime * result + Arrays.hashCode(horaDeSaida);
            return result;
    }

    @Override
    public boolean equals(Object obj) {
            if (this == obj)
                    return true;
            if (obj == null)
                    return false;
            if (getClass() != obj.getClass())
                    return false;
            Voo other = (Voo) obj;
            if (aeroportoChegada == null) {
                    if (other.aeroportoChegada != null)
                            return false;
            } else if (!aeroportoChegada.equals(other.aeroportoChegada))
                    return false;
            if (aeroportoSaida == null) {
                    if (other.aeroportoSaida != null)
                            return false;
            } else if (!aeroportoSaida.equals(other.aeroportoSaida))
                    return false;
            if (codAviao == null) {
                    if (other.codAviao != null)
                            return false;
            } else if (!codAviao.equals(other.codAviao))
                    return false;
            if (codVoo == null) {
                    if (other.codVoo != null)
                            return false;
            } else if (!codVoo.equals(other.codVoo))
                    return false;
            if (diasDisponives == null) {
                    if (other.diasDisponives != null)
                            return false;
            } else if (!diasDisponives.equals(other.diasDisponives))
                    return false;
            if (!Arrays.equals(horaDeChegada, other.horaDeChegada))
                    return false;
            return Arrays.equals(horaDeSaida, other.horaDeSaida);
    }

    @Override
    public String toString() {
        return String.format("(%s) %02d:%02d em %s => %02d:%02d em %s",
                                codVoo,
                                horaDeSaida[0],
                                horaDeSaida[1],
                                aeroportoSaida,
                                horaDeChegada[0],
                                horaDeChegada[1],
                                aeroportoChegada);
    }
    
    
	
	
}
