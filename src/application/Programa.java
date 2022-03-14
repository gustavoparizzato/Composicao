package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Departamento;
import entities.HoraContrato;
import entities.Trabalhador;
import entities.enums.TrabalhadorLevel;

public class Programa {

	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Digite o nome do departamento: ");
		String departamentoNome = sc.nextLine();
		System.out.println("Insira os dados do trabalhador:");
		System.out.print("Nome: ");
		String trabalhadorNome = sc.nextLine();
		System.out.print("Level: ");
		String trabalhadorLevel = sc.nextLine();
		System.out.print("Base salario: ");
		double baseSalario = sc.nextDouble();
		Trabalhador trabalhador = new Trabalhador(trabalhadorNome, TrabalhadorLevel.valueOf(trabalhadorLevel), baseSalario, new Departamento(departamentoNome));
		
		System.out.print("Quantos contratos para esse trabalhador? ");
		int n = sc.nextInt();
		
		for (int i=1; i<=n; i++) {
			System.out.println("Digite o contrato #" + i + " data:");
			System.out.print("Date (DD/MM/YYYY): ");
			Date contratoData = sdf.parse(sc.next());
			System.out.print("Valor por hora: ");
			double valorPorHora = sc.nextDouble();
			System.out.print("Duração (Horas): ");
			int horas = sc.nextInt();
			HoraContrato contrato = new HoraContrato(contratoData, valorPorHora, horas);
			trabalhador.addContrato(contrato);
		}
		
		System.out.println();
		System.out.print("Insira o mês e o ano para calcular a renda (MM/YYYY): ");
		String mesEAno = sc.next();
		int mes = Integer.parseInt(mesEAno.substring(0, 2));
		int ano = Integer.parseInt(mesEAno.substring(3));
		System.out.println("Nome: " + trabalhador.getNome());
		System.out.println("Departamento " + trabalhador.getDepartamento().getNome());
		System.out.println("Renda para " + mesEAno + ": " + String.format("%.2f", trabalhador.income(ano, mes)));
		
		sc.close();
	}
}