package main;

import java.io.File;
import java.util.Arrays;

public class Main {
	
	private static final boolean MODOTESTE = true;
	
	public static void main(String[] args) {
		
		FileManager.setup();
		
		File[] files = FileManager.getInputs();
		
		if(files.length == 0) {
			System.out.println("Pasta de Input vazia");
			System.exit(0);
		}
		
		if(MODOTESTE) {
			int index = 0;
			
			while (index < files.length && !files[index].getName().toLowerCase().startsWith("conta"))
				index++;
			
			if(index < files.length) {
				
				processar(files[index]);
				
			}
		}else {
			for (File file : files) {
				
				if(file.getName().toLowerCase().startsWith("conta")) {
					
					processar(file);
				}
				
			}
		}
		System.out.println("Concluido!!!");
		
	}
	
	public static void processar(File file) {
		System.out.println("Recolhendo dados de " + file.getName());
		
		Cliente[] clientes = Manipulador.gerarPessoasDeLinhas(FileManager.getRegistros(file));
		
		System.out.print("Ordenando " + file.getName() + "...");
		Manipulador.QuickSort(clientes);
		System.out.println(" Ordenado!! ");
		
		System.out.println("Gerando output em " + file.getName());
		
		
		FileManager.outputToFile(file.getName(), Manipulador.gerarOutput(file.getName(), "QuickSort", 0l, clientes));
		
	}

}
