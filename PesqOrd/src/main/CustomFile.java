package main;

import java.io.File;

public class CustomFile {
	
	private int nRegistro;
	private Status status;
	private Cliente[] clientes;
	
	public CustomFile(File file) {
		String[] infos = FileManager.getInfosFromName(file.getName());
		
		nRegistro = Integer.valueOf(infos[0]);
		switch (infos[1]) {
		case "ord":
			this.status = Status.Ordenado;
			break;
		case "inv":
			this.status = Status.Invertido;
			break;
		case "ale":
			this.status = Status.Aleatorio;
			break;
		}
		
		this.clientes  = Manipulador.gerarPessoasDeLinhas(FileManager.getRegistros(file));
		
	}
	
	public int getnRegistro() {
		return nRegistro;
	}
	
	public void setnRegistro(int nRegistro) {
		this.nRegistro = nRegistro;
	}
	
	public String getStatus() {
		return status.toString();
	}
	
	public void setStatus(String status) {
		this.status = Status.valueOf(status);
	}
	
	public Cliente[] getClientes() {
		return clientes;
	}
	
	public void setClientes(Cliente[] clientes) {
		this.clientes = clientes;
	}
	
	
	
}
