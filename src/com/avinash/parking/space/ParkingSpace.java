package com.avinash.parking.space;

public abstract class ParkingSpace {

	public enum VehicleSize {LARGE, MEDIUM, SMALL};
	
	private String vehicleNumber;
	
	private boolean isFree;
	
	public ParkingSpace(boolean isFree){
		this.isFree = isFree;
	}
	
	public void enterInParkingSpace(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
		this.isFree = false;
	}
	
	public void leaveFromParkingSpace() {
		this.vehicleNumber = null;
		this.isFree = true;
	}
	
	public boolean isParkingSpaceFree() {
		return isFree;
	}
	
	public String getVehicleNumber() {
		return vehicleNumber;
	}

}
