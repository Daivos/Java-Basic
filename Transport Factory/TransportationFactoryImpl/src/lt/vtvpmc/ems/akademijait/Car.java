package lt.vtvpmc.ems.akademijait;

import com.eisgroup.javaexam.factory.Color;
import com.eisgroup.javaexam.factory.Transportation;

public class Car extends Transportation {

	public Car(String make, String model, double price, Color color) {
		super(make, model, price, color);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double getFinalPrice() {
		// TODO Auto-generated method stub
		return getPrice()*1.21;
	}

}
