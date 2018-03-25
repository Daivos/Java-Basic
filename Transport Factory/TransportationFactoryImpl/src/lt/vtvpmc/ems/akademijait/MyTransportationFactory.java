package lt.vtvpmc.ems.akademijait;

import com.eisgroup.javaexam.factory.Color;
import com.eisgroup.javaexam.factory.Transportation;
import com.eisgroup.javaexam.factory.TransportationFactory;

public class MyTransportationFactory implements TransportationFactory{

	@Override
	public Transportation produceBoat(String arg0, String arg1, double arg2, Color arg3, double arg4) {
		// TODO Auto-generated method stub
		return new Boat(arg0,arg1,arg2, arg3,arg4);
	}

	@Override
	public Transportation produceCar(String arg0, String arg1, double arg2, Color arg3) {
		// TODO Auto-generated method stub
		return new Car(  arg0,  arg1,  arg2,  arg3);
	}

}
