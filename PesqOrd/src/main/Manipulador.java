package main;

import main.listaEncadeada.ListaEncadeada;

public class Manipulador {
	
	private static long temp = -1;
	
	public static Cliente[] gerarPessoasDeLinhas(String[] linhas){
		Cliente[] out = new Cliente[linhas.length];
		
		for(int i = 0; i < out.length; i++)
			out[i] = new Cliente(linhas[i]);
		
		return out;
	}
	
	public static void QuickSort(Cliente[] vet){
		QuickSort (vet, 0, vet.length-1);
	}
	
	private static void QuickSort(Cliente[] vet, int esq, int dir) {
		int i = esq;
		int j = dir;
		Cliente pivor = vet[(int)((i+j)/2)];
		
		do {
			while(vet[i].compareTo(pivor) < 0) 
				i++;
			
			while(vet[j].compareTo(pivor) > 0)
				j--;
			
			if(i <= j) {
				Cliente temp = vet[i];
				vet[i] = vet[j];
				vet[j] = temp;
				i++;
				j--;
			}
		} while(i <= j);
		
		if(esq < j)
			QuickSort(vet, esq, j);
		if(i < dir)
			QuickSort(vet, i, dir);
	}
	
	public static void QuickSortComInsercao(Cliente[] vet) {
		
	}
	
	public static void insercaoDireta(Cliente[] vet) {
		insercaoDireta(vet, 0, vet.length-1);
	}
	
	private static void insercaoDireta(Cliente[] vet, int esq, int dir) {
		
	}
	
	public static int pesquisaBinaria() {
		return -1;
	}
	
	public static boolean iniciarContador() {
		if (temp != -1)
			return false;
		
		temp = System.nanoTime();
		
		return true;
	}
	
	public static long pararContador() {
		if(temp == -1)
			return -1;
		
		long out = System.nanoTime() - temp;
		temp = -1;
		
		return out;
		
	}
	
	public static String[] gerarOutput(String fileName, String metodo, long tempo, Cliente[] registros) {
		ListaEncadeada<String> le = new ListaEncadeada<>();
		String[] infos = FileManager.getInfosFromName(fileName);
		
		le.add("---------- Informações da execução --------------");
		le.add("");
		le.add("Quantidade de registros: " + infos[0]);
		le.add("Ordem de entrada: " + infos[1]);
		le.add("Método utilizado: " + metodo);
		le.add("Custo de tempo: " + tempo);
		le.add("");
		le.add("-------------------------------------------------");
		le.add("");
		le.add("Saida:");
		le.add("");
		for(Cliente c: registros)
			le.add(c.getAsRegister());
		
		Object[] objs = le.getInfosAsArray();
		String[] out = new String[le.getTam()];
		
		for(int i = 0; i < out.length; i++)
			out[i] = (String)objs[i];
		
		return out;

	}
	
}
