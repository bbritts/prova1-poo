package prova2;

public class Paciente {
	
	private static final int MAX = 10;
	
	String nome;
	int idade;
	Comorbidade[] listaComorbidade;
	int quantComorbidades = 0;
	
	public Paciente(String nome, int idade) {
		setNome(nome);
		setIdade(idade);
		listaComorbidade = new Comorbidade[MAX];
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}
	
	public int getQuantComorbidades() {
		return this.quantComorbidades;
	}

	public Comorbidade[] getListaComorbidade() {
		return listaComorbidade;
	}

	public void setListaComorbidade(Comorbidade[] listaComorbidade) {
		this.listaComorbidade = listaComorbidade;
	}
	
	public void addComorbidades(String comorbidade, int anosAcometido) {
		
		if (quantComorbidades < MAX) {
			listaComorbidade[quantComorbidades] = new Comorbidade(comorbidade, anosAcometido);
			quantComorbidades++;
		} else
			System.out.println("Limite de registro atingido");
	}
	
	public void imprimeObjeto() {
		System.out.print("Nome do Paciente: " + getNome() + "\n");
		System.out.print("Idade: " + getIdade() + "\n");
		
		if(quantComorbidades == 0)
			System.out.print("Possui comorbidades? Não\n\n");
		else {
			System.out.println("Possui comorbidades? Sim\n");
			
			for (Comorbidade obj : listaComorbidade) {
				if (obj != null)
					obj.imprimeComorbidades();					
			}
		}
	}
	
	public Paciente buscaComorbidade(String busca) {
		
		for (Comorbidade obj : listaComorbidade) {
			if(obj != null && busca.equalsIgnoreCase(obj.getNomeComorbidade()))
				return this;
		}
		
		return null;
	}
}