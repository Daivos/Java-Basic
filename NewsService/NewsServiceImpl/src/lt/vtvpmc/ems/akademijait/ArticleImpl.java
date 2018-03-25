package lt.vtvpmc.ems.akademijait;

import lt.vtvpmc.Article;

public class ArticleImpl implements Article {
	private String heading;
	private String brief;
	
	public ArticleImpl (String heading, String brief) {
		this.brief=brief;
		this.heading=heading;
	}

	@Override
	public String getBrief() {
		// TODO Auto-generated method stub
		return brief;
	}

	@Override
	public String getHeading() {
		// TODO Auto-generated method stub
		return heading;
	}

}
