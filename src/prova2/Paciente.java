package prova2;

import java.util.Scanner;

public class Paciente {

	Scanner sc = new Scanner(System.in);

	private static final int MAX = 10;

	private String nome;
	private int idade;
	private Comorbidade[] listaComorbidade;
	private int quantComorbidades;

	public Paciente(String nome, int idade) {
		setNome(nome);
		setIdade(idade);
		listaComorbidade = new Comorbidade[MAX];
		this.quantComorbidades = 0;
	}

	public int getMax() {
		return MAX;
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
		if (idade >= 0)
			this.idade = idade;
	}

	public int getQuantComorbidades() {
		return this.quantComorbidades;
	}

	public void addComorbidades() {

		System.out.println("Registre até " + (MAX - quantComorbidades) + " doenças\n");

		System.out.print("Digite o nome da comorbidade: ");
		String nomeCom = sc.nextLine();
		System.out.print("Há quantos anos tem a doença? ");
		int anosAcometido = sc.nextInt();
		sc.nextLine();

		listaComorbidade[quantComorbidades] = new Comorbidade(nomeCom, anosAcometido);
		quantComorbidades++;
	}

	public Paciente buscaComorbidade(String busca) {

		for (Comorbidade obj : listaComorbidade) {
			if (obj != null && busca.equalsIgnoreCase(obj.getNomeComorbidade()))
				return this;
		}

		return null;
	}

	public void imprimeObjeto() {
		System.out.print("Nome do Paciente: " + getNome() + "\n");
		System.out.print("Idade: " + getIdade() + "\n");

		if (quantComorbidades == 0)
			System.out.print("Possui comorbidades? Não\n\n");
		else {
			System.out.println("Possui comorbidades? Sim\n");

			for (Comorbidade obj : listaComorbidade) {
				if (obj != null)
					obj.imprimeComorbidades();
			}
		}
	}
}