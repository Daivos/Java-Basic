package lt.vtvpmc.ems.akademijait;

import lt.infobalt.itakademija.javalang.exam.socialnetwork.BaseSocialNetworkTest;
import lt.infobalt.itakademija.javalang.exam.socialnetwork.SocialNetwork;

public class SocialNetworkTest extends BaseSocialNetworkTest{

	
	
	@Override
	protected SocialNetwork getSocialNetwork() {
		// TODO Auto-generated method stub
		return new MySocialNetwork();
	}

}
