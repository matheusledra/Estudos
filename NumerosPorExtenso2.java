package Estudos;

import java.util.Scanner;

public class NumerosPorExtenso2 {
	
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

            /*
             *  Se o número for negativo, significa que anteriormente ao número existe 
             * o sinal de negativo "-", então o número é convertido em String, e depois
             * removido o sinal de negativo "-" usando o substring, como o indice passado
             * é 1, então de "-129" o número passa a ser "129" e é chamado novamente o 
             * metódo para escrever o "129" por extenso e é adicionado a palavra
             * "negativo" ao final do número por extenso.
            */
			String negativo = "" + num;
			negativo = negativo.substring(1);
			num = Integer.parseInt(negativo);
			
			return numExtenso(num) + " negativo";
		}

        /*
        *   Se o número dividido por 1 bilhão obter o resultado maior ou igual a 1 então
        * irá verificar se o número é somente 1 bilhão (tirando o restante) ou se é de 2 bilhões
        * pra cima, e então ele define o número como somente o restante da divisão por 1 bilhão com
        * o sinal de "%=", que por exemplo com o número "12.982.934.556" irá ter o resto de "982.934.556"
        * e após continuará verificando o restante do número e o escrevendo por extenso.
        */
		if(num / 1000000000 >= 1) {
			if(num / 1000000000 == 1) {
				msg += numExtenso(num / 1000000000) + " bilhao ";
				num %= 1000000000;
			} else {
				msg += numExtenso(num / 1000000000) + " bilhoes ";
				num %= 1000000000;
			}
		}
        // Se o número dividido por 1 milhão obter o resultado maior ou igual a 1 então...
		if(num / 1000000 >= 1) {
			if(num / 1000000 == 1) {
				msg += numExtenso(num / 1000000) + " milhao ";
				num %= 1000000;
			} else {
				msg += numExtenso(num / 1000000) + " milhoes ";

                // "982.934.556" vira "934.556"
				num %= 1000000;
			}
		}
        // Se o número dividido por mil obter o resultado maior ou igual a 1 então...
		if(num / 1000 >= 1) {
			if(num / 1000 == 1) {
				msg += " Mil ";
				num %= 1000;
			} else {
				msg += numExtenso(num / 1000) + " mil ";

                // "934.556" vira "556"
				num %= 1000;
			}
		}
        // Se o número dividido por 1 milhão obter o resultado maior ou igual a 1 então...
		if(num / 100 >= 1) {
			if(num / 100 == 1) {

                /*
                *   Essa verificação existe para saber se irá usar "Cento" ou "Cem", usando o resto ("%")
                * se o resto for maior que 0 então irá usar o "Cento", se for igual a 0 então irá usar "Cem"
                */
				if(num % 100 > 0) {
					msg += centenas[num / 100] + " e ";

                    // "556" vira "56"
					num %= 100;
				} else {
					msg += "Cem";
				}
			} else if(num % 100 > 0) {
				msg += centenas[num / 100] + " e ";

                // "556" vira "56"
				num %= 100;
			} else {
				msg += centenas[num / 100];
			}
		}
		
        // Se o número for maior que zero...
		if(num > 0) {

            // Se o número for menor que 20...
			if(num < 20) {
				msg += unidades[num];

                // Se não, se for menor que 100 (porém maior que 20)...
			} else if(num < 100){
				msg += dezenas[num / 10];

                // Se o resto da divisão do número por 10 for maior que zero... 
				if((num % 10) > 0) {
                /*
                *   Aqui é usado o resto pois como está pegando do Array de unidades irá
                * pegar somente o último digito, "56" vai pegar o indíce "6"
                */
					msg += " e " + unidades[num % 10];
				}
			}
		}
		return msg;
	}
}