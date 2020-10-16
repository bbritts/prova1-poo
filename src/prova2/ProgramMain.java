package prova2;

import java.util.Scanner;

public class ProgramMain {

	public static void main(String[] args) {

		Paciente[] paciente = new Paciente[10];
		int quantPacientes = 0;
		byte repeteMenu = 1;

		Scanner sc = new Scanner(System.in);

		System.out.println("Bem vindo ao Sistema de Registro de Pacientes - COVID19");
		System.out.println();

		do {

			System.out.println("Escolha uma opção no menu:");
			System.out.println();
			System.out.println("1 - Cadastrar paciente");
			System.out.println("2 - Listar pacientes");
			System.out.println("3 - Listar pacientes de acordo com comorbidade");
			System.out.println("4 - Listar pacientes sem comorbidades");
			System.out.println("-------------------------------------");
			System.out.println("0 - Para sair do programa");

			repeteMenu = sc.nextByte();
			sc.nextLine();

			switch (repeteMenu) {

			case 0:
				System.out.println("Saindo do programa...");
				break;
				
			case 1:
				System.out.println("Cadastro de pacientes:");
				System.out.println();
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

				if (resposta == 1) {
					do {
						System.out.print("Digite o nome da comorbidade: ");
						String nomeCom = sc.nextLine();
						System.out.print("Há quantos anos tem a doença? ");
						int anos = sc.nextInt();
						paciente[quantPacientes].addComorbidades(nomeCom, anos);

						System.out.println("Deseja cadastrar outra comorbidade?");
						System.out.println("0 - Não");
						System.out.println("1 - Sim");
						resposta = sc.nextByte();
						sc.nextLine();

					} while (resposta != 0);
				}
				quantPacientes++;
				
				System.out.println();
				break;

			case 2:
				System.out.println("Lista de Pacientes\n");

				for (Paciente obj : paciente) {
					if (obj != null)
						obj.imprimeObjeto();
				}
				
				System.out.println();
				break;
				
			case 3:
				System.out.println("Lista de pacientes por comorbidade\n");
				System.out.print("Digite o nome da comorbidade buscada: ");
				String buscaComorbidade = sc.nextLine();
				
				System.out.println("Pacientes com " + buscaComorbidade + ":\n");

				for (Paciente obj : paciente) {
					if (obj != null && obj.buscaComorbidade(buscaComorbidade) != null)
						System.out.println("Nome do paciente: " + obj.getNome());
				}
				
				System.out.println();
				break;

			case 4:

				System.out.println("Lista de pacientes sem comorbidades\n");
				for (Paciente obj : paciente) {
					if (obj != null && obj.getQuantComorbidades() == 0)
						System.out.println(obj.getNome());
				}
				
				System.out.println();
				break;

			default:
				System.out.println("Opção inválida");
				System.out.println();
				break;				
			}

		} while (repeteMenu != 0);
		
		sc.close();
	}
}
