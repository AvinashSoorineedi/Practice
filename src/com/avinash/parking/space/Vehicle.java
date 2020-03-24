package com.avinash.parking.space;

import com.avinash.parking.space.ParkingSpace.VehicleSize;

public class Vehicle {

	private String vehicleName;

	private VehicleSize vehicleSize;

	public Vehicle(String vehicleName, VehicleSize vehicleSize) {
		this.vehicleName = vehicleName;
		this.vehicleSize = vehicleSize;
	}

	public VehicleSize getVehicleSize() {
		return this.vehicleSize;
	}

	public String getVehicleName() {
		return this.vehicleName;
	}
}
