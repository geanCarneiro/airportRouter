package main.listaEncadeada;

public class ListaEncadeada<T> {

	private No<T> raiz;
	private int tam;
	private boolean repeticao;
	
	public ListaEncadeada(){
		this.raiz = null;
		this.tam = 0;
		this.repeticao = false;
	}
	
	public ListaEncadeada(boolean repeticao){
		this();
		this.repeticao = repeticao;
	}
	
	public No<T> add(T elem){
		
		No<T> novo = new No<T>(elem);
		
		if(this.raiz == null) {
			this.raiz = novo;
		} else {
			No<T> atual = this.raiz;
			
			if(!repeticao && atual.equals(novo))
				return null;
			
			while(atual.getProx() != null)
				atual = atual.getProx();
			
			atual.setProx(novo);
				
			
		}
		
		this.tam++;
		return novo;
		
	}
	
	public void remover(T elem){
		No<T> no;
	}
	
	
	
	public Object[] getInfosAsArray(){
		Object[] out = new Object[this.tam];
		No<T> atual = this.raiz;
		
		for(int i = 0; i < this.tam; i++){
			out[i] = atual.getInfo();
			atual = atual.getProx();
		}

		return out;
	}
	
	public No<T> getRaiz() {
		return raiz;
	}
	
	public void setRaiz(No<T> raiz) {
		this.raiz = raiz;
	}
	
	public int getTam() {
		return tam;
	}
	
	public void setTam(int tam) {
		this.tam = tam;
	}

	@Override
	public String toString() {
		
		String out = "{ ";
		No<T> atual = this.raiz;
		while(atual != null){
			out += atual.toString();
			if(atual.getProx() != null)
				out += ", ";
			atual = atual.getProx();
		}
		out += " }";
		
		return out;
		
	}
	
	
	
}
