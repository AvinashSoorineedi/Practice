package com.avinash.parking.space;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ParkingLot {

	private static ParkingLot parkingLot;
	Map<String, ParkingSpace> occupiedParkingSpaces;

	List<ParkingSpace> smallParkingSpaces;
	List<ParkingSpace> mediumParkingSpaces;
	List<ParkingSpace> largeParkingSpaces;

	ParkingLot() {
		occupiedParkingSpaces = new HashMap<String, ParkingSpace>();
		smallParkingSpaces = new LinkedList<>();
		mediumParkingSpaces = new LinkedList<>();
		largeParkingSpaces = new LinkedList<>();

		// 5 small parking spaces
		for (int i = 0; i < 5; i++) {
			smallParkingSpaces.add(new SmallParkingSpace(true));
		}

		// 3 medium parking spaces
		for (int i = 0; i < 3; i++) {
			mediumParkingSpaces.add(new MediumParkingSpace(true));
		}

		// 2 medium parking spaces
		for (int i = 0; i < 2; i++) {
			largeParkingSpaces.add(new LargeParkingSpace(true));
		}
	}

	public String parkVehicle(Vehicle vehicle) {

		ParkingSpace parkingSpace = findParkingSpace(vehicle);

		if (parkingSpace != null) {
			parkingSpace.enterInParkingSpace(vehicle.getVehicleName());
			occupiedParkingSpaces.put(vehicle.getVehicleName(), parkingSpace);
		} else {
			return "No Available Parking Slots";
		}

		return "Vehicle Parked Successfully";
	}

	public String unParkVehicle(Vehicle vehicle) {
		if (null == occupiedParkingSpaces.get(vehicle.getVehicleName())) {
			return "No Such Vehicle Present";
		}

		ParkingSpace parkedSpace = occupiedParkingSpaces.remove(vehicle.getVehicleName());
		parkedSpace.leaveFromParkingSpace();

		switch (vehicle.getVehicleSize().toString()) {
		case "LARGE":
			largeParkingSpaces.add(parkedSpace);
			break;
		case "MEDIUM":
			mediumParkingSpaces.add(parkedSpace);
			break;
		case "SMALL":
			smallParkingSpaces.add(parkedSpace);
			break;
		default:
			break;
		}

		return "Vehicle Unparked Successfully";
	}

	private ParkingSpace findParkingSpace(Vehicle vehicle) {

		ParkingSpace parkingSpace = null;
		
		try {
		
		switch (vehicle.getVehicleSize().toString()) {
		case "LARGE":
			parkingSpace = largeParkingSpaces.remove(0);
			break;
		case "MEDIUM":
			parkingSpace = mediumParkingSpaces.remove(0);
			break;
		case "SMALL":
			parkingSpace = smallParkingSpaces.remove(0);
			break;
		default:
			break;
		}
		}catch(Exception e){
			System.out.println("Exception while removing element "+e.getMessage());
		}
		return parkingSpace;
	}

	public static ParkingLot getParkingLotInstance() {
		if (parkingLot == null) {
			parkingLot = new ParkingLot();
		}
		return parkingLot;

	}
}
