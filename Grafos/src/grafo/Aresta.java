package grafo;

public class Aresta {
	
	private String label;
	private Vertice origem;
	private Vertice destino;
	private boolean direcionado;
	private double peso;
	
	public Aresta(Vertice origem, Vertice destino){
		this.label = null;
		this.origem = origem;
		this.destino = destino;
		this.direcionado = false;
		this.peso = 1;
	}
	
	public Aresta(String inLabel, Vertice inOrigem, Vertice inDestino){
		this.label = inLabel;
		this.origem = inOrigem;
		this.destino = inDestino;
		this.direcionado = false;
		this.peso = 1;
	}
	
	public Aresta(String inLabel, Vertice inOrigem, Vertice inDestino,
			boolean inDirecionado){
		this.label = inLabel;
		this.origem = inOrigem;
		this.destino = inDestino;
		this.direcionado = inDirecionado;
		this.peso = 1;
	}
	
	public Aresta(String inLabel, Vertice inOrigem, Vertice inDestino,
			boolean inDirecionado, double inPeso){
		this.label = inLabel;
		this.origem = inOrigem;
		this.destino = inDestino;
		this.direcionado = inDirecionado;
		this.peso = inPeso;
	}
	
	public String getLabel() {
		return label;
	}
	
	public void setLabel(String label) {
		this.label = label;
	}
	
	public Vertice getOrigem() {
		return origem;
	}
	
	public void setOrigem(Vertice origem) {
		this.origem = origem;
	}
	
	public Vertice getDestino() {
		return destino;
	}
	
	public void setDestino(Vertice destino) {
		this.destino = destino;
	}
	
	public boolean isDirecionado() {
		return direcionado;
	}
	
	public void setDirecionado(boolean direcionado) {
		this.direcionado = direcionado;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((destino == null) ? 0 : destino.hashCode());
		result = prime * result + (direcionado ? 1231 : 1237);
		result = prime * result + ((label == null) ? 0 : label.hashCode());
		result = prime * result + ((origem == null) ? 0 : origem.hashCode());
		long temp;
		temp = Double.doubleToLongBits(peso);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Aresta other = (Aresta) obj;
		
		if (destino == null) {
			if (other.destino != null)
				return false;
		} else if (!destino.equals(other.destino) || (!this.direcionado && this.destino.equals(other.origem)))
			return false;
		
		if (direcionado != other.direcionado)
			return false;
		if (label == null) {
			if (other.label != null)
				return false;
		} else if (!label.equals(other.label))
			return false;
		
		if (origem == null) {
			if (other.origem != null)
				return false;
		} else if (!origem.equals(other.origem) || (!this.direcionado && this.origem.equals(other.destino)))
			return false;
		
		if (Double.doubleToLongBits(peso) != Double
				.doubleToLongBits(other.peso))
			return false;
		return true;
	}
	
	 

}
