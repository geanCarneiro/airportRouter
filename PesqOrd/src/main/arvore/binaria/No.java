package main.arvore.binaria;

public class No<T> {
	
	private T info;
	private No<T> esq;
	private No<T> dir;
	
	public No(T info){
		this.info = info;
		this.esq = null;
		this.dir = null;
	}
	
	public T getInfo() {
		return info;
	}
	
	public void setInfo(T info) {
		this.info = info;
	}
	
	public No<T> getEsq() {
		return esq;
	}
	
	public void setEsq(No<T> esq) {
		this.esq = esq;
	}
	
	public No<T> getDir() {
		return dir;
	}
	
	public void setDir(No<T> dir) {
		this.dir = dir;
	}
	
	
	
}
