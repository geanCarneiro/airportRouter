package main;

public class Cliente implements Comparable<Cliente>{

	private String nome;
	private String cpf;
	private String nomeAgencia;
	private String nConta;
	
	public Cliente(){
		this.nome = "";
		this.cpf = "";
		this.nomeAgencia = "";
		this.nConta = "";
	}
	
	public Cliente(String inNome, String inCpf, String inNomeAgencia, String inConta){
		this.nome = inNome;
		this.cpf = inCpf;
		this.nomeAgencia = inNomeAgencia;
		this.nConta = inConta;
	}
	
	public Cliente(String registro){
		this();
		String[] infos = registro.split(";");
		
		for(int i = 0; i < infos.length; i++) {
			switch (i) {
			case 0:
				this.nome = infos[0];
				break;
			case 1:
				this.cpf = infos[1];
				break;
			case 2:
				this.nomeAgencia = infos[2];
				break;
			case 3:
				this.nConta = infos[3];
				break;
			}
		}
		
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

	public String getAgencia() {
		return nomeAgencia;
	}

	public void setAgencia(String agencia) {
		this.nomeAgencia = agencia;
	}

	public String getNConta() {
		return nConta;
	}

	public void setNConta(String nConta) {
		this.nConta = nConta;
	}
	
	public String getAsRegister() {
		return this.nome + ";" + this.cpf + ";" + this.nomeAgencia + ";" + this.nConta;
	}
		
	public int compareTo(Cliente other) {
		
		int out = this.nome.compareToIgnoreCase(other.getNome());
		
		if(out == 0)
			out = this.cpf.compareToIgnoreCase(other.getCpf());
		
		return out;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((nConta == null) ? 0 : nConta.hashCode());
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result + ((nomeAgencia == null) ? 0 : nomeAgencia.hashCode());
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
		Cliente other = (Cliente) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (nConta == null) {
			if (other.nConta != null)
				return false;
		} else if (!nConta.equals(other.nConta))
			return false;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		if (nomeAgencia == null) {
			if (other.nomeAgencia != null)
				return false;
		} else if (!nomeAgencia.equals(other.nomeAgencia))
			return false;
		return true;
	}

	@Override
	public String toString() {
		String out = "";
		
		out += "{\n";
		out += "   Nome: " + this.nome + "\n";
		out += "   CPF: " + this.cpf + "\n";
		out += "   Agencia: " + this.nomeAgencia + "\n";
		out += "   Conta: " + this.nConta + "\n";
		out += "}";
		
		return out;
	}
	
	

	
	
}
