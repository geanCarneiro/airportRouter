package main;

import java.io.File;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Scanner;

public class Cliente implements Comparable<Cliente> {
	
	public static ArrayList<String> NOMES = new ArrayList<>();
	
	public static ArrayList<String> SOBRENOMES = new ArrayList<>();
	
	private String conta = "";
	private String agencia = "";
	private String nome = "";
	private String cpf = "";
	
	public Cliente() {
		for(int i = 0; i < 5; i++) {
			this.conta += (int)(Math.random()*10);
		}
		
		for(int i = 0; i < 7; i++) {
			this.agencia += (int)(Math.random()*10);
		}
		
		this.nome += Cliente.NOMES.get((int)(Math.random()*Cliente.NOMES.size()));
		this.nome += " " + Cliente.SOBRENOMES.get((int)(Math.random()*Cliente.SOBRENOMES.size()));
		
		for(int i = 0; i < 11; i++) {
			this.cpf += (int)(Math.random()*10);
		}
	}
	
	public String getConta() {
		return conta;
	}
	
	public void setConta(String conta) {
		this.conta = conta;
	}
	
	public String getAgencia() {
		return agencia;
	}
	
	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	@Override
	public String toString() {
		return this.conta + ";" + this.agencia + ";" + this.nome + ";" + this.cpf;
	}

	public static void carregarNomes(String string) throws Exception{

		File file = new File(ClassLoader.getSystemResource(string).getFile());
		
		Scanner scan = new Scanner(file);
		
		while(scan.hasNextLine())
			NOMES.add(removerAcentos(scan.nextLine()));
		
		
		
	}

	public static void carregarSobrenomes(String string) throws Exception {

		File file = new File(ClassLoader.getSystemResource(string).getFile());
		
		Scanner scan = new Scanner(file);
		
		while(scan.hasNextLine())
			SOBRENOMES.add(removerAcentos(scan.nextLine()));
		
	}
	
	public static String removerAcentos(String str) {
		return Normalizer.normalize(str, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
	}

	@Override
	public int compareTo(Cliente o) {
		
		int comp = this.nome.compareToIgnoreCase(o.getNome());
		
		if(comp == 0)
			comp = this.cpf.compareToIgnoreCase(o.getCpf());
		
		return comp;
	}
	
	
}
