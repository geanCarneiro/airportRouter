package main;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main2 {
	
	
	
	public static void main2(String[] args) throws Exception {
		
		Cliente.carregarNomes("nomes.txt");
		Cliente.carregarSobrenomes("sobrenomes.txt");
		
		int[] tams = {500, 1000, 5000, 10000, 50000};
		Cliente[] out;
		
		for(int tam: tams) {
			
			out = new Cliente[tam];
			
			for(int i = 0; i < tam; i++) {
				out[i] = new Cliente();
			}
			
			System.out.println("gerando cliente" + tam + "ale.txt");
			gravar("/out/cliente" + tam + "ale.txt", out);
			
			QuickSort(out);
			
			System.out.println("gerando cliente" + tam + "ord.txt");
			gravar("/out/cliente" + tam + "ord.txt", out);
			
			inverterArray(out);
			
			System.out.println("gerando cliente" + tam + "inv.txt");
			gravar("/out/cliente" + tam + "inv.txt", out);
		}
		
		System.out.println("pronto");

	}
	
	private static void inverterArray(Cliente[] out) {
		Cliente t;
		for(int i = 0; i < out.length/2; i++) {
			t = out[i];
			out[i] = out[out.length-1-i];
			out[out.length-1-i] = t;
		}
			
		
	}

	public static void QuickSort(Cliente[] vet){
		QuickSort(vet, 0, vet.length-1);
	}
	
	private static void QuickSort(Cliente[] vet, int esq, int dir) {
		int i = esq;
		int j = dir;
		Cliente pivor = vet[i+(j-i)/2];
		
		while(i <= j) {
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
		}
		
		if(esq < j)
			QuickSort(vet, esq, j);
		if(i < dir)
			QuickSort(vet, i, dir);
	}
		
	private static void gravar(String string, Cliente[] out) throws Exception{
		
		File file = new File(ClassLoader.getSystemResource("").getPath(), string);
		
		BufferedWriter writer = new BufferedWriter(new FileWriter(file));
		
		writer.flush();
		
		for(Cliente o: out)
			writer.write(o + System.lineSeparator());
		
		writer.close();
		
	}

}
