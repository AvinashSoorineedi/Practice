package com.avinash.transform;

public class Destination {

	String myName;
	
	String myColor;
	
	int myAge;

	public String getMyName() {
		return myName;
	}

	public void setMyName(String myName) {
		this.myName = myName;
	}

	public String getMyColor() {
		return myColor;
	}

	public void setMyColor(String myColor) {
		this.myColor = myColor;
	}

	public int getMyAge() {
		return myAge;
	}

	public void setMyAge(int myAge) {
		this.myAge = myAge;
	}

	@Override
	public String toString() {
		return "Destination [myName=" + myName + ", myColor=" + myColor + ", myAge=" + myAge + "]";
	}
	
}
