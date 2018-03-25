package lt.vtvpmc.ems.akademijait;

import lt.vtvpmc.java.postoffice.AbstractPostOfficeTest;
import lt.vtvpmc.java.postoffice.PostOffice;

public class MyPostOfficeTest extends AbstractPostOfficeTest {

	@Override
	protected PostOffice getPostOffice() {
		// TODO Auto-generated method stub
		return new MyPostOffice();
	}

}
