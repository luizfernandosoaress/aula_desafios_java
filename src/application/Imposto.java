package application;

import java.util.Locale;
import java.util.Scanner;

public class Imposto {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Renda anual com salário: ");
		double rendaAnual = sc.nextDouble();
		System.out.print("Renda anual com prestação de serviço: ");
		double prestacaoDeServico = sc.nextDouble();
		System.out.print("Renda anual com ganho de capital: ");
		double capital = sc.nextDouble();
		System.out.print("Gastos médicos: ");
		double gastosMedicos = sc.nextDouble();
		System.out.print("Gastos educacionais: ");
		double gastosEducacionais = sc.nextDouble();
		
		System.out.println();
		System.out.println("RELATÓRIO DE IMPOSTO DE RENDA");
		System.out.println();
		
		// imposto sobre salario	
		
		double salarioMensal = rendaAnual / 12;
		double impostoSalario = 0.0;
		
		if (salarioMensal < 3000) {
			impostoSalario =  0.0;
		}
		else if(salarioMensal < 5000 ) {
			impostoSalario = rendaAnual * 0.1;
		}
		else {
			impostoSalario = rendaAnual * 0.2;
		}
		
		//imposto sobre prestação de serviço	
		double impostoPrestacaoDeServico = 0.0;
		if(prestacaoDeServico > 0) {
			impostoPrestacaoDeServico = prestacaoDeServico * 0.15;
		}
		
		//imposto sobre capital	
		double impostoCapital = 0.0;		
		if(capital > 0.0) {
			impostoCapital = capital * 0.2;
		}
		
		System.out.println("CONSOLIDADO DE RENDA:");
		System.out.printf("Imposto sobre salário: %.2f%n", impostoSalario);
		System.out.printf("Imposto sobre serviços: %.2f%n", impostoPrestacaoDeServico);
		System.out.printf("Imposto sobre de capital: %.2f%n", impostoCapital);
		
		// imposto bruto total, maximoDedutivel e gastosDedutiveis		
	    double impostoBruto = impostoSalario + impostoPrestacaoDeServico + impostoCapital;
	    double maximoDedutivel = impostoBruto * 0.3;
		double gastosDedutiveis = gastosMedicos + gastosEducacionais;
		
		System.out.println();
		System.out.println("DEDUÇÕES:");
		System.out.printf("Máximo dedutível: %.2f%n", maximoDedutivel);
		System.out.printf("Gastos dedutíveis: %.2f%n", gastosDedutiveis);
		
		//abatimento, total
		double abatimento;
		if (gastosDedutiveis > maximoDedutivel) {
			abatimento = maximoDedutivel;
		}
		else {
			abatimento = gastosDedutiveis;
		}
		
		double total = impostoBruto - abatimento;
		
		System.out.println();
		System.out.println("RESUMO: ");
		System.out.printf("Imposto bruto total: %.2f%n", impostoBruto);	
		System.out.printf("Abatimento: %.2f%n", abatimento);
		System.out.printf("Imposto devido: %.2f%n", total);
		
		sc.close();
	}

}
