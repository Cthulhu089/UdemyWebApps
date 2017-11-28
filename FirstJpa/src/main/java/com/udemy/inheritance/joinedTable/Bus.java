package com.udemy.inheritance.joinedTable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue (value = "B")
public class Bus extends Vehicle{
	private int numberOfPassenger;

	public Bus() {
		
	}

	public Bus(String name, int numberOfPassenger) {
		super(name);
		this.numberOfPassenger = numberOfPassenger; 
	}

	public int getNumberOfPassenger() {
		return numberOfPassenger;
	}

	public void setNumberOfPassenger(int numberOfPassenger) {
		this.numberOfPassenger = numberOfPassenger;
	}
	
	
}
