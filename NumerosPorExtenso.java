package Estudos;

import java.util.Scanner;

public class NumerosPorExtenso {
	
	public static void main(String[] args) {
		
		int num = 0;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Digite um numero: ");
		num = sc.nextInt();
		
		System.out.println("Numero Digitado: " + num);
		System.out.print("Numero por Extenso: " + numExtenso(num));
	}
	
	private static String numExtenso(int num) {
		String msg = "";
		String[] unidades = {"Zero", "Um", "Dois", "Tres", "Quatro", "Cinco", "Seis", "Sete", "Oito", "Nove", "Dez",
							"Onze", "Doze", "Treze", "Quatorze", "Quinze", "Dezesseis", "Dezesete", "Dezoito", "Dezenove"};
		String[] dezenas = {"Zero", "Dez", "Vinte", "Trinta", "Quarenta", "Cinquenta", "Sessenta", "Setenta", "Oitenta", "Noventa"};
		String[] centenas = {"Zero", "Cento", "Duzentos", "Trezentos", "Quatrocentos", "Quinhentos", "Seiscentos", "Setecentos",
							"Oitocentos", "Novecentos"};

		if(num == 0) {
			msg += "Zero";
		} else if(num < 0) {
			String negativo = "" + num;
			negativo = negativo.substring(1);
			num = Integer.parseInt(negativo);
			
			return numExtenso(num) + " negativo";
		}
		if(num / 1000000000 > 0) {
			if(num / 1000000000 == 1) {
				msg += numExtenso(num / 1000000000) + " bilhao ";
				num %= 1000000000;
			} else {
				msg += numExtenso(num / 1000000000) + " bilhoes ";
				num %= 1000000000;
			}
		}
		if(num / 1000000 > 0) {
			if(num / 1000000 == 1) {
				msg += numExtenso(num / 1000000) + " milhao ";
				num %= 1000000;
			} else {
				msg += numExtenso(num / 1000000) + " milhoes ";
				num %= 1000000;
			}
		}
		if(num / 1000 > 0) {
			if(num / 1000 == 1) {
				msg += " Mil ";
				num %= 1000;
			} else {
				msg += numExtenso(num / 1000) + " mil ";
				num %= 1000;
			}
		}
		if(num / 100 > 0) {
			if(num / 100 == 1) {
				if(num % 100 > 0) {
					msg += centenas[num / 100] + " e ";
					num %= 100;
				} else {
					msg += "Cem";
				}
			} else if(num % 100 > 0) {
				msg += centenas[num / 100] + " e ";
				num %= 100;
			} else {
				msg += centenas[num / 100];
			}
		}
		
		if(num > 0) {
			if(num < 20) {
				msg += unidades[num];
			} else if(num < 100){
				msg += dezenas[num / 10];
				if((num % 10) > 0) {
					msg += " e " + unidades[num % 10];
				}
			}
		}
		return msg;
	}
}
