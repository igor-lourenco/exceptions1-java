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

public class Programa {

	public static void main(String[] args) throws ParseException{
	
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Número do Quarto: ");
		int number = sc.nextInt();
		System.out.print("Data do check-In (dd/mm/yyyy): ");
		Date checkIn = sdf.parse(sc.next());
		System.out.print("Data do check-Out (dd/mm/yyyy): ");
		Date checkOut = sdf.parse(sc.next());
		
		if(!checkOut.after(checkIn)) {
			System.out.println("Erro ao Reservar: Data do check-out não pode ser antes do check-in");
		}else {
			Reserva reserva = new Reserva(number, checkIn, checkOut);
			System.out.println("Reserva : " + reserva);
			
			System.out.println();
			System.out.println("Digite os dados atualizados da reserva:");
			System.out.print("Data do check-In (dd/mm/yyyy): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Data do check-Out (dd/mm/yyyy): ");
			checkOut = sdf.parse(sc.next());
			
			Date now = new Date();
			if(checkIn.before(now) || checkOut.before(now)) {
				System.out.println("Erro na reserva: Dados atualizados não pode ser anterior da data futura");
			}else if(!checkOut.after(checkIn)) {
				System.out.println("Erro na reserva: Data do check-out não pode ser antes do check-in");
				
			}else {
				reserva.atualizar(checkIn, checkOut);
				System.out.println("Reserva : " + reserva);
			}
		}
		
		sc.close();
	}
}
