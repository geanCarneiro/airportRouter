package main;

import java.time.LocalTime;
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
	private LocalTime horaDeSaida = null;
	private Aeroporto aeroportoSaida;
	private LocalTime horaDeChegada = null;
	private Aeroporto aeroportoChegada;

	public Voo() {
		
	}

	public Voo(List<DiasSemana> diasDisponives, String codVoo, String codAviao, LocalTime horaDeSaida,
			Aeroporto aeroportoSaida, LocalTime horaDeChegada, Aeroporto aeroportoChegada) {
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
		this.horaDeSaida = LocalTime.of(
				Integer.valueOf(horaDeSaida.substring(0, 2)), 
				Integer.valueOf(horaDeSaida.substring(2))
						);
		
		this.aeroportoSaida = aeroportoSaida;
		this.horaDeChegada = LocalTime.of(
				Integer.valueOf(horaDeChegada.substring(0, 2)),
				Integer.valueOf(horaDeChegada.substring(2))
				);
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
            out[3] = horaDeSaida.format(Main.timeFormatter);
            out[4] = aeroportoSaida.toString();
            out[5] = horaDeChegada.format(Main.timeFormatter);
            out[6] = aeroportoChegada.toString();
            
            return out;
        }
        
	public LocalTime getTempoDeVoo() {
		
            if(this.horaDeChegada.isAfter(horaDeSaida)){
                return horaDeChegada
                		.minusHours(horaDeSaida.getHour())
                		.minusMinutes(horaDeSaida.getMinute());
            } else {
                return horaDeSaida
                		.plusHours(24)
                		.minusHours(horaDeChegada.getHour())
                		.minusMinutes(horaDeChegada.getMinute());
            }
	}
	
	public int getTempoDeVooInMinutes() {
		
        LocalTime tempoDeVoo = getTempoDeVoo();
        
        return tempoDeVoo.getHour()*60 + tempoDeVoo.getMinute();
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

    public LocalTime getHoraDeSaida() {
            return horaDeSaida;
    }

    public void setHoraDeSaida(LocalTime horaDeSaida) {
            this.horaDeSaida = horaDeSaida;
    }

    public Aeroporto getAeroportoSaida() {
            return aeroportoSaida;
    }

    public void setAeroportoSaida(Aeroporto aeroportoSaida) {
            this.aeroportoSaida = aeroportoSaida;
    }

    public LocalTime getHoraDeChegada() {
            return horaDeChegada;
    }

    public void setHoraDeChegada(LocalTime horaDeChegada) {
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
            result = prime * result + ((horaDeChegada == null) ? 0 : horaDeChegada.hashCode());
            result = prime * result + ((horaDeSaida == null) ? 0 : horaDeSaida.hashCode());
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
            if (!horaDeChegada.equals(other.horaDeChegada))
                    return false;
            return horaDeSaida.equals(other.horaDeSaida);
    }

    @Override
    public String toString() {
        return String.format("(%s) %02d:%02d em %s => %02d:%02d em %s",
                                codVoo,
                                horaDeSaida.getHour(),
                                horaDeSaida.getMinute(),
                                aeroportoSaida,
                                horaDeChegada.getHour(),
                                horaDeChegada.getMinute(),
                                aeroportoChegada);
    }
    
    
	
	
}
