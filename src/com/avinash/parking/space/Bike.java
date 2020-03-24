package com.avinash.parking.space;

import com.avinash.parking.space.ParkingSpace.VehicleSize;

public class Bike extends Vehicle{

	public Bike(String vehicleName) {
		super(vehicleName, VehicleSize.SMALL);
	}

}
