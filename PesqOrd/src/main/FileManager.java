package main;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Scanner;

import main.listaEncadeada.ListaEncadeada;

public class FileManager {
	
	private static File bin = new File(ClassLoader.getSystemResource("").getPath());
	
	public static final File PASTAIN = new File(bin.getAbsolutePath() + "/input");
	public static final File PASTAOUT = new File(bin.getAbsolutePath() + "/output");
	public static final String identificadorDeDados = "conta";
	private static Scanner scan;
	
	public static String[] getInfosFromName(String fileName){
		if(!fileName.contains("conta"))
			return new String[]{"", ""};
		
		String[] out = new String[2];
		out[0] = "";
		
		String temp = fileName.substring(identificadorDeDados.length());
		if(temp.isEmpty())
			return null;
		
		int i = 0;
		
		while(Character.isDigit(temp.charAt(i))) {
			out[0] += temp.charAt(i);
			i++;
		}
		
		if(out[0].isEmpty())
			out[0] = "?";
		
		String ordem = temp.substring(i);
		switch (ordem) {
		case "ale":
			out[1] = Status.Aleatorio.name();
			break;
		case "ord":
			out[1] = Status.Ordenado.name();
			break;
		case "inv":
			out[1] = Status.Invertido.name();
			break;
		default:
			out[1] = "Desconhecido";
			break;
		}
		
		return out;
	}
	
	public static File[] getInputs() {
		return PASTAIN.listFiles(new FilenameFilter() {
			
			@Override
			public boolean accept(File arg0, String arg1) {
				// TODO Auto-generated method stub
				return arg1.endsWith(".txt");
			}
		});
	}
	
	public static String[] getRegistros(File file) {
		try{
			ListaEncadeada<String> le = new ListaEncadeada<String>(true);			
			scan = new Scanner(file);
			String[] infos = getInfosFromName(file.getName());
			
			while(scan.hasNextLine()){
				le.add(scan.nextLine());
				System.out.println(le.getTam() + "/" + infos[0] + " dados recolhidos em " + file.getName());
			}
			
			String[] out = new String[le.getTam()];
			
			Object[] linhas = le.getInfosAsArray();
			for(int i = 0; i < out.length; i++)
				out[i] = (String)linhas[i];
			
			return out;
		}catch(FileNotFoundException fNFEx){
			return null;
		}
	}

	public static boolean outputToFile(String fileName, String[] linhas){
		if(fileName == null || fileName.isEmpty())
			return false;
		
		String temp = "";
		
		if(fileName.contains("/") || fileName.contains("\\")) {
			
			int index = Math.max(fileName.lastIndexOf("/"), fileName.lastIndexOf("\\"))+1;
			
			temp = fileName.substring(0, index);
			fileName = fileName.substring(index);
			
		}
		
		return outputToFile(temp, fileName, linhas);
	}
	
	public static boolean outputToFile(String pasta, String fileName, String[] linhas){
		if(fileName == null || fileName.isEmpty())
			return false;
		
		if(pasta == null)
			pasta = "";
		
		pasta = pasta.trim();
		if(!pasta.isEmpty() && (!pasta.startsWith("/") || !pasta.startsWith("\\"))) 
			pasta = "/" + pasta;
		
		File file = new File(PASTAOUT + pasta, fileName);
		BufferedWriter w = null;
		
		try{
			w = new BufferedWriter(new FileWriter(file));
			w.flush();
			for(String obj: linhas){
				w.append(obj + System.lineSeparator());
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				w.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return false;
		} 
		
		try {
			w.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return true;
	}

	public static void setup() {
		
		System.out.println("Realizando Setup...");
		
		if(PASTAIN.exists())
			System.out.println("Pasta de Input exstente!");
		else 
			if(PASTAIN.mkdir())
				System.out.println("Pasta de Input criada");
			else
				System.out.println("Não foi possivel criar a pasta de Input");
		
		if(PASTAOUT.exists())
			System.out.println("Pasta de Output existente!");
		else
			if(PASTAOUT.mkdir())
				System.out.println("Pasta de Output criada");
			else
				System.out.println("Não foi possivel criar a pasta de Output");
		
		System.out.println("Setup realizado!!!");
		
	}
	
}
