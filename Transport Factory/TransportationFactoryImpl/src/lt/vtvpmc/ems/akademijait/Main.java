package lt.vtvpmc.ems.akademijait;

import com.eisgroup.javaexam.factory.Color;
import com.eisgroup.javaexam.factory.Transportation;

public class Main {



	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyTransportationFactory myCar =new MyTransportationFactory ();
		MyTransportationFactory myBoat =new MyTransportationFactory (); 
		
		myCar.produceCar("Skoda", "Fabia", 12000, Color.RED );
		myBoat.produceBoat("Valtis", "medinė", 2000, Color.RED, 4 );
	}

	
	}


