package br.com.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
	
	private int roomNumber;
	private Date checkIn;
	private Date checkOut;
	
	public static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reservation() {
		
	}

	public Reservation(int roomNumber, Date checkIn, Date checkOut) {
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public int getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}

	public long duration() {
		long diff = checkOut.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);		
	}
	
	public String updateDates(Date checkIn, Date checkOut) {
		
		Date now = new Date();	
		if(checkIn.before(now) || checkOut.before(now)) {
			return "Error in reservation. dates for update must be future dates";
		} 
		if(!checkOut.after(checkIn)) {
			return "Error in reservation. Check-Out cannot be before Check-In";
		} 
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		return null;
	}

	@Override
	public String toString() {
		return  " Room Number = " 
				+ roomNumber 
				+ ", checkIn = " 
				+ sdf.format(checkIn) 
				+ ", checkOut= " 
				+ sdf.format(checkOut)
				+ " " +  duration()
				+ " nights";
	}

	
}
