/*Fazer um programa para ler os dados de uma reserva de hotel (número do quarto, data
 *de entrada e data de saída) e mostrar os dados da reserva, inclusive sua duração em
 *dias. Em seguida, ler novas datas de entrada e saída, atualizar a reserva, e mostrar 
 *novamente a reserva com os dados atualizados. O programa não deve aceitar dados
 *inválidos para a reserva, conforme as seguintes regras:
 *- Alterações de reserva só podem ocorrer para datas futuras
 *- A data de saída deve ser maior que a data de entrada
 */

package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reserva;
import model.exeption.DomainException;

public class Programa {

	public static void main(String[] args)  {

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		try {
		System.out.print("Número do Quarto: ");
		int number = sc.nextInt();
		System.out.print("Data do check-In (dd/mm/yyyy): ");
		Date checkIn = sdf.parse(sc.next());
		System.out.print("Data do check-Out (dd/mm/yyyy): ");
		Date checkOut = sdf.parse(sc.next());

			Reserva reserva = new Reserva(number, checkIn, checkOut);
			System.out.println("Reserva : " + reserva);

			System.out.println();
			System.out.println("Digite os dados atualizados da reserva:");
			System.out.print("Data do check-In (dd/mm/yyyy): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Data do check-Out (dd/mm/yyyy): ");
			checkOut = sdf.parse(sc.next());

			reserva.atualizar(checkIn, checkOut);
			System.out.println("Reserva : " + reserva);
		}
		catch(ParseException e) {
			System.out.println("Data Inválida");
		}
		catch(DomainException e) {
			System.out.println("Erro: " + e.getMessage());
		}
		catch(RuntimeException e) {
			System.out.println("Erro inesperado");
		}
		
		sc.close();
	}
}
