package prova2;

import java.util.Scanner;

public class ProgramMain {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Registro registro = new Registro();
		byte repeteMenu;

		imprimeCabecalho();

		do {
			imprimeMenu();
			repeteMenu = sc.nextByte();
			sc.nextLine();

			switch (repeteMenu) {

			case 0:
				System.out.println("Saindo do programa...");
				break;

			case 1:
				registro.cadastraPaciente();
				System.out.println();
				break;

			case 2:
				registro.listaPacientes();
				System.out.println();
				break;

			case 3:
				registro.listaPorComorbidade();
				System.out.println();
				break;

			case 4:
				registro.listaSemComorbidade();
				System.out.println();
				break;

			default:
				System.out.println("Opção inválida!");
				System.out.println();
				break;
			}

		} while (repeteMenu != 0);

		sc.close();
	}
	
	private static void imprimeCabecalho() {
		System.out.println("---------------------------------------------------------");
		System.out.println(" Bem vindo ao Sistema de Registro de Pacientes - COVID19 ");
		System.out.println("---------------------------------------------------------\n");		
	}

	public static void imprimeMenu() {
		System.out.println("                Escolha uma opção no menu:               \n");
		System.out.println("---------------------------------------------------------");
		System.out.println("-     1 - Cadastrar paciente                            -");
		System.out.println("-     2 - Listar pacientes                              -");
		System.out.println("-     3 - Listar pacientes de acordo com comorbidade    -");
		System.out.println("-     4 - Listar pacientes sem comorbidades             -");
		System.out.println("---------------------------------------------------------\n");
		System.out.println("                0 - Para sair do programa");
	}
}
