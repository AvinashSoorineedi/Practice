package com.avinash.parking.space;

import com.avinash.parking.space.ParkingSpace.VehicleSize;

public class Truck extends Vehicle{

	public Truck(String vehicleName) {
		super(vehicleName, VehicleSize.LARGE);
	}

}
