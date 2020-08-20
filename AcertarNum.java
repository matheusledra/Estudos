package Estudos;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class AcertarNum {

	public static void main(String[] args) {

		boolean repeat = false, repeat2 = false;
		String sn;
		int chute, num;

		Random rd = new Random();
		Scanner sc = new Scanner(System.in);

		do {
			num = rd.nextInt(30) + 1;

			System.out.println("O numero e de 1 a 30!");

			do {
				System.out.println("");
				System.out.print("Digite um número: ");
				chute = sc.nextInt();

				if (chute == num) {
					System.out.println("");
					System.out.println("Parabens, voce acertou o numero!");
					System.out.println("");
					System.out.println("Deseja jogar novamente? S/N");
					sn = sc.next();

					repeat2 = false;
					if (sn.equalsIgnoreCase("S")) {
						System.out.println("");
						System.out.println("Reiniciando... Aguarde...");

						try {
							TimeUnit.SECONDS.sleep(1);
						} catch (Exception e) {
							System.out.println("");
							System.out.println("Ocorreu um erro...");
						} finally {
							repeat = true;
						}
					} else if (sn.equalsIgnoreCase("N")) {
						System.out.println("");
						System.out.println("Encerrando...");
					} else {
						System.out.println("");
						System.out.println("Erro! Opcao invalida, encerrando...");
					}
				} else {
					System.out.println("");
					System.out.println("Voce errou, que pena ;(");
					System.out.println("");
					System.out.println("Deseja tentar novamente? S/N");
					sn = sc.next();

					repeat2 = sn.equalsIgnoreCase("S") ? true : false;
					repeat = false;
				}
			} while (repeat2);
		} while (repeat);
	}
}