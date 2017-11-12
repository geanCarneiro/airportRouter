package main.listaEncadeada;

public class No<T> {
	
	private T info;
	private No<T> prox;
	
	public No(T elem){
		this.info = elem;
		this.prox = null;
	}
	
	public No(T elem, No<T> prox){
		this(elem);
		this.prox = prox;
	}
	
	public T getInfo() {
		return info;
	}
	public void setInfo(T info) {
		this.info = info;
	}
	public No<T> getProx() {
		return prox;
	}
	public void setProx(No<T> prox) {
		this.prox = prox;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((info == null) ? 0 : info.hashCode());
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
		No other = (No) obj;
		if (info == null) {
			if (other.info != null)
				return false;
		} else if (!info.equals(other.info))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return this.info.toString();
	}
	
	
	
}
