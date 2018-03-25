package lt.vtvpmc.ems.akademijait;

import com.eisgroup.javaexam.factory.Color;
import com.eisgroup.javaexam.factory.Transportation;

public class Boat extends Transportation{
private double length;
	public Boat(String make, String model, double price, Color color,double length) {
		super(make, model, price, color);
		this.length=length;
		// TODO Auto-generated constructor stub
	}

	@Override
	public double getFinalPrice() {
		// TODO Auto-generated method stub
		return getPrice()*1.21;
	}
	
	public double getLength() {
		return length;
	}

}
