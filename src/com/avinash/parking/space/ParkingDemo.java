package com.avinash.parking.space;

public class ParkingDemo {

	public static void main(String[] args) {
		
		ParkingLot parkingLot = ParkingLot.getParkingLotInstance();

		System.out.println(parkingLot.parkVehicle(new Car("abc")));
		System.out.println(parkingLot.parkVehicle(new Car("123")));
		System.out.println(parkingLot.parkVehicle(new Car("67")));
		System.out.println(parkingLot.parkVehicle(new Car("1")));
//		System.out.println(parkingLot.parkVehicle(new Car("2")));
		
	}

}
