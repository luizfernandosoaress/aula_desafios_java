package application;

import java.util.Locale;
import java.util.Scanner;

public class Atletas {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		String nome;
		char sexo;
		double altura;
		double peso;
		String nomeAltura = null;
		int qtdMulher = 0;
		int qtdHomem = 0;
		double somaPesoAtletas = 0;
		double maiorAtleta = 0;
		double alturaMulheres = 0;
		
		System.out.print("Qual a quantidade de atletas? ");
		int n = sc.nextInt();
		
		for(int i=0; i<n; i++) {
			sc.nextLine();
			System.out.println("Digite os dados do atleta numero " + (i+1) + ":");
			System.out.print("Nome: ");
			nome = sc.nextLine();
			System.out.print("Sexo: ");
			sexo = sc.next().charAt(0);
			
			//validação
			while(sexo != 'M' && sexo != 'F') {
				System.out.print("Valor inválido! Favor digitar F ou M: ");
				sexo = sc.next().charAt(0);
			}
			
			if(sexo == 'M') {
				qtdHomem++;
			}
			
			//validação
			System.out.print("Altura: ");
			altura = sc.nextDouble();	
			while(altura <= 0) {
				System.out.print("Valor inválido! Favor digitar um valor positivo: ");
				altura = sc.nextDouble();
			}
			
			if(maiorAtleta < altura) {
				maiorAtleta = altura;;
				nomeAltura = nome;
			}
			
			if(sexo == 'F') {
				alturaMulheres += altura;
				qtdMulher++;
			}
			
			//validação
			System.out.print("Peso: ");
			peso = sc.nextDouble();
			while(peso <= 0) {
				System.out.print("Valor inválido! Favor digitar um valor positivo: ");
				peso = sc.nextDouble();	
			}
			
			somaPesoAtletas += peso;
		}
				
				
		System.out.println();
		double calcPeso = somaPesoAtletas / n; //Cálculo peso médio
		System.out.println("RELATÓRIO:");
		System.out.printf("Peso médio dos atletas: %.2f%n", calcPeso);
		System.out.printf("Atleta mais alto: %s%n", nomeAltura);
		
		double porcentagemHomens = (double) qtdHomem * 100 / n; //Cálculo porcentagem de homens
		System.out.printf("Porcentagem de homens: %.1f %%%n", porcentagemHomens);
		
		//Estrutura condicional
		if(qtdMulher > 0) { 
			double mediaAltura = (double) alturaMulheres / qtdMulher; //Cálculo média altura de mulheres
			System.out.printf("Altura média das mulheres: %.2f%n", mediaAltura);
		}
		else {
			System.out.println("Não há mulheres cadastradas");
		}
			
	}
}

