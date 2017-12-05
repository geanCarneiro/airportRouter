package main;

public class Aeroporto implements Comparable<Aeroporto>{

    private String icao;
    private String name;
    
    private int distancia;
    private boolean visitado;
    private Voo via;
    private DiasSemana diaChegada;
    private DiasSemana diaPartida;

    public DiasSemana getDiaChegada() {
        return diaChegada;
    }

    public void setDiaChegada(DiasSemana diaChegada) {
        this.diaChegada = diaChegada;
    }

    public DiasSemana getDiaPartida() {
        return diaPartida;
    }

    public void setDiaPartida(DiasSemana diaPartida) {
        this.diaPartida = diaPartida;
    }

    public int getDistancia() {
        return distancia;
    }

    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }

    public boolean isVisitado() {
        return visitado;
    }

    public void setVisitado(boolean visitado) {
        this.visitado = visitado;
    }

    public Voo getVia() {
        return via;
    }

    public void setVia(Voo via) {
        this.via = via;
    }

    public Aeroporto() {
        this.icao = "";
        this.name = "";
    }

    public Aeroporto(String cod) {
            this();
            this.icao = cod;
    }

    public Aeroporto(String cod, String name) {
            this(cod);
            this.name = name;
    }

    public String getIcao() {
            return icao;
    }

    public void setIcao(String icao) {
            this.icao = icao;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((icao == null) ? 0 : icao.hashCode());
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
            Aeroporto other = (Aeroporto) obj;
            if (icao == null) {
                    if (other.icao != null)
                            return false;
            } else if (!icao.equals(other.icao))
                    return false;
            if (name == null) {
                    if (other.name != null)
                            return false;
            } else if (!name.equals(other.name))
                    return false;
            return true;
    }

    @Override
    public String toString() {
        return "(" + this.icao + ") " + this.name;
    }

    @Override
    public int compareTo(Aeroporto o) {
        return Integer.compare(this.distancia, o.distancia);
    }
    
    
	
}
