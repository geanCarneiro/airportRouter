package grafo;

import java.util.ArrayList;
import java.util.List;

public class Grafo {
	
	private List<Vertice> vertices;
	private List<Aresta> arestas;
	
	public Grafo(){
		this.vertices = new ArrayList<Vertice>();
		this.arestas = new ArrayList<Aresta>();
	}

	public int[][] getMatrizAdjacencia(){
		int[][] out = new int[this.vertices.size()][this.vertices.size()];
		
		int o;
		int d;
		for(Aresta a: this.arestas){
			o = getVerticeIndex(a.getOrigem());
			d = getVerticeIndex(a.getDestino());
			
			out[o][d] += 1;
			if(!a.isDirecionado())
				out[d][o] += 1;
		}
		
		return out;
	}
	
	public boolean addVertice(Vertice inVertice){
		if(this.vertices.contains(inVertice))
			return false;
		
		this.vertices.add(inVertice);
		return true;
	}
	
	public int getArestaIndex(Aresta inAresta){
		if(this.arestas.contains(inAresta))
			return this.arestas.indexOf(inAresta);
		else 
			return -1;
	}
	
	public Aresta getAresta(Aresta inAresta){
		int i = getArestaIndex(inAresta);
		if(i == -1) return null;
		return this.arestas.get(i);
	}

	public int getVerticeIndex(Vertice inVertice){
		if(this.vertices.contains(inVertice))
			return this.vertices.indexOf(inVertice);
		else
			return -1;
	}
	
	public Vertice getVertice(Vertice inVertice){
		int i = getVerticeIndex(inVertice);
		if(i == -1) return null;
		return this.vertices.get(i);
	}
	public boolean addAresta(Aresta inAresta){
		try{
			if(!this.vertices.contains(inAresta.getOrigem()))
				this.addVertice(inAresta.getOrigem());
			
			if(!this.vertices.contains(inAresta.getDestino()))
				this.addVertice(inAresta.getDestino());
			
			this.arestas.add(inAresta);
			
			return true;
		}catch(Exception ex){
			ex.printStackTrace();
			return false;
		}
	}
	
	public List<Vertice> getVertices() {
		return vertices;
	}
	
	public void setVertices(List<Vertice> vertices) {
		for(Vertice v: vertices)
			this.vertices.add(v);
	}
	
	public List<Aresta> getArestas() {
		return arestas;
	}
	
	public void setArestas(List<Aresta> arestas) {
		for(Aresta a: arestas)
			this.arestas.add(a);
	}
	
	
	
}
