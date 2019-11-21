package br.com.principal;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import br.com.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Room number:");
		int room = sc.nextInt();
		System.out.print("Check-in:");
		Date checkin = sdf.parse(sc.next());
		System.out.print("Check-out:");
		Date checkout = sdf.parse(sc.next());
		
		if(!checkout.after(checkin)) {
			System.out.println("Error in reservation. Check-Out cannot be before Check-In");
		} else {
			Reservation reservation = new Reservation(room, checkin, checkout);
			System.out.println("Reservation: "+ reservation);
			
			System.out.println();
			System.out.println("Enter data to update the reservation:");
			System.out.print("Check-in:");
			checkin = sdf.parse(sc.next());
			System.out.print("Check-out");
			checkout = sdf.parse(sc.next());

			String error = reservation.updateDates(checkin, checkout);
			if(error != null) {
				System.out.println("Error in reservation: " + error);
			} else {
				System.out.println("Updated: "+ reservation);
			}
			
						
		}		

		sc.close();
	}

}
