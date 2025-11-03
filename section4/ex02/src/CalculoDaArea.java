

/*
 Faça um programa para ler o valor do raio de um círculo, e depois mostrar o valor da área deste círculo com quatro
casas decimais conforme exemplos.
 */
import java.util.Scanner;

public class CalculoDaArea {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        double pi = 3.14159;

        System.out.print("Digite o raio: ");
        double raio = scan.nextDouble();

        double area = pi * Math.pow(raio, 2);

        System.out.printf("A area do circulo com raio %.2f é igual a %.4f.\n", raio, area);

    }
}
