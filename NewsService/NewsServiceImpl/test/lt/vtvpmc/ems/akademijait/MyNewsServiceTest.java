package lt.vtvpmc.ems.akademijait;

import lt.vtvpmc.BaseNewsServiceTest;
import lt.vtvpmc.NewsService;

public class MyNewsServiceTest extends BaseNewsServiceTest {

	@Override
	protected NewsService getNewsService() {
		// TODO Auto-generated method stub
		return new MyNewsService();
	}

	
	
}
