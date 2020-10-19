package prova2;

import java.util.Scanner;

public class Registro {

	Scanner sc = new Scanner(System.in);

	private Paciente[] paciente;
	private int quantPacientes;

	public Registro() {
		this.paciente = new Paciente[2];
		this.quantPacientes = 0;
	}

	public int getQuantPacientes() {
		return quantPacientes;
	}

	public void cadastraPaciente() {

		System.out.println("Cadastro de pacientes:\n");
		System.out.print("Por favor, informe o nome completo do paciente: ");
		String nome = sc.nextLine();
		System.out.print("Informe a idade do paciente: ");
		int idade = sc.nextInt();
		sc.nextLine();
		paciente[quantPacientes] = new Paciente(nome, idade);
		System.out.println();
		System.out.println("O paciente possui comorbidades?");
		System.out.println("0 - Não");
		System.out.println("1 - Sim");
		byte resposta = sc.nextByte();
		sc.nextLine();

		if (resposta == 1) 
			cadastraComorbidades(resposta);

		quantPacientes++;

		if (quantPacientes == paciente.length)
			aumentaVetor();
	}
	
	public void cadastraComorbidades(int resposta) {
		
		while (paciente[quantPacientes].getQuantComorbidades() < paciente[quantPacientes].getMax()
				&& resposta == 1) {
			
			paciente[quantPacientes].addComorbidades();
			
			if (paciente[quantPacientes].getQuantComorbidades() < paciente[quantPacientes].getMax()) {
				
				System.out.println("Deseja cadastrar outra comorbidade?");
				System.out.println("0 - Não");
				System.out.println("1 - Sim");
				resposta = sc.nextByte();
				sc.nextLine();
			}
		}
	}

	public void aumentaVetor() {

		Paciente[] novoVetor = new Paciente[paciente.length * 2];
		for (int i = 0; i < paciente.length; i++)
			novoVetor[i] = paciente[i];
		paciente = novoVetor;
	}	

	public void listaPacientes() {
		System.out.println("Lista de Pacientes");
		System.out.println("----------------------------------------\n");

		if (quantPacientes == 0)
			System.out.println("Nenhum paciente cadastrado até o momento\n");
		else {
			for (Paciente obj : paciente) {
				if (obj != null)
					obj.imprimeObjeto();
			}
		}
	}

	public void listaPorComorbidade() {

		System.out.println("Lista de pacientes por comorbidade");
		System.out.println("----------------------------------------\n");

		if (quantPacientes == 0)
			System.out.println("Nenhum paciente cadastrado até o momento\n");
		else {
			System.out.print("Digite o nome da comorbidade buscada: ");
			String buscaComorbidade = sc.nextLine();

			System.out.println("Pacientes com " + buscaComorbidade + ":\n");

			boolean encontrado = false;

			for (Paciente obj : paciente) {
				if (obj != null && obj.buscaComorbidade(buscaComorbidade) != null) {
					System.out.println("Nome do paciente: " + obj.getNome() + "\n");
					encontrado = true;
				}
			}

			if (!encontrado)
				System.out.println("Não foram encontrados pacientes com " + buscaComorbidade + "\n");
		}
	}

	public void listaSemComorbidade() {
		System.out.println("Lista de pacientes sem comorbidades");
		System.out.println("----------------------------------------\n");

		if (quantPacientes == 0)
			System.out.println("Nenhum paciente cadastrado até o momento\n");
		else {
			boolean encontrado = false;

			for (Paciente obj : paciente) {
				if (obj != null && obj.getQuantComorbidades() == 0) {
					System.out.println("Nome do paciente: " + obj.getNome() + "\n");
					encontrado = true;
				}
			}

			if (!encontrado)
				System.out.println("Não foram encontrados pacientes sem comorbidades\n");
		}
	}
}
