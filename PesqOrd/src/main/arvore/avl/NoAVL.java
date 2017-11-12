package main.arvore.avl;

import main.arvore.binaria.No;

public class NoAVL<T> extends No<T>{
	
	private byte fator;
	
	public NoAVL(T info) {
		super(info);
		this.setFator(0);
	}
	
	public byte getFator() {
		return fator;
	}

	public void setFator(byte fator) {
		this.fator = fator;
	}
	
	
	public void setFator(int num) {
		this.fator = (byte)num;
	}
	
}
