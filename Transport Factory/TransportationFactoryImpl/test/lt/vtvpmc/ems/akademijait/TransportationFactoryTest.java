package lt.vtvpmc.ems.akademijait;

import com.eisgroup.javaexam.factory.TransportationFactory;
import com.eisgroup.javaexam.factory.test.BaseTransportationFactoryTest;

public class TransportationFactoryTest extends BaseTransportationFactoryTest{

	@Override
	protected TransportationFactory getTransportationFactory() {
		// TODO Auto-generated method stub
		return new MyTransportationFactory();
	}

}
