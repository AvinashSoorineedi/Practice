package com.avinash.parking.space;

import com.avinash.parking.space.ParkingSpace.VehicleSize;

public class Car extends Vehicle{

	public Car(String vehicleName) {
		super(vehicleName, VehicleSize.MEDIUM);
	}

}
