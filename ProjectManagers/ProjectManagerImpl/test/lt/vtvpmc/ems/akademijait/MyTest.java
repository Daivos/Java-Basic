package lt.vtvpmc.ems.akademijait;

import lt.itakademija.exam.ProjectManager;
import lt.itakademija.exam.test.BaseTest;

public class MyTest extends BaseTest {

	@Override
	protected ProjectManager createProjectTracker() {
		
		return new ProjectTracker();
	}

}
