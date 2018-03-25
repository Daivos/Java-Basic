package lt.vtvpmc.ems.akademijait;

import java.util.ArrayList;
import java.util.List;

import lt.vtvpmc.Article;
import lt.vtvpmc.NewsService;
import lt.vtvpmc.NewsServiceImpl;

public class MyNewsService implements NewsService {

	public List<Article> articles;
	public List<Article> newArticles = new ArrayList<Article>();

	public MyNewsService() {
		NewsServiceImpl newsService = new NewsServiceImpl();
		articles = newsService.getArticles();

	}

	@Override
    public List<Article> getArticles() {
        String myHeading = null;
        String myBrief = null;
       
        for (Article article : articles) {
            myBrief = article.getBrief();  // pirma priskiri mybriefa, o toliau jį keiti
            Boolean goodHeading = true;
            for (SwearWords swearWord : SwearWords.values()) {
                if (article.getHeading().toLowerCase().contains(swearWord.getSwearWord()) ) {
                    goodHeading = false;   
                } else {
                    myHeading = article.getHeading();
                    myBrief = myBrief.replaceAll("(?i)"+swearWord.getSwearWord(), "***"); // nes tavo atveju vis iškvieti pe naują ir dėl to ne visur pakeičia
                    //myBrief = article.getBrief().toLowerCase().replaceAll(swearWord.getSwearWord(), "***");
                    }
                }
            if (goodHeading) {
                System.out.println(myHeading + "\n\t" + myBrief);
                newArticles.add(new ArticleImpl(myHeading, myBrief));
            }
        }
   
        return newArticles;
    }
	
}

//package lt.vtvpmc.ems.akademijait;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//import com.sun.istack.internal.logging.Logger;
//
//import lt.vtvpmc.Article;
//import lt.vtvpmc.NewsService;
//import lt.vtvpmc.NewsServiceImpl;
//
///**
// * 
// * @author daiva
// *
// */
//public class MyNewsService implements NewsService {
//
//	private static final List<String> SWEAR_WORDS = Arrays.asList("rupūs miltai", "velniai rautų", "velnias",
//			"velniais");
//
//	final static Logger logger = Logger.getLogger(MyNewsService.class);
//
//	protected List<Article> correctArticleList = new ArrayList<Article>();
//	protected List<Article> articleList;
//
//	public MyNewsService() {
//		NewsServiceImpl newsSercice = new NewsServiceImpl();
//		articleList = newsSercice.getArticles();
//	}
//
//	public List<Article> getArticles() {
//        String myHeading = null;
//        String myBrief = null;
//       
//        for (Article article : articleList) {
//            myBrief = article.getBrief();  // pirma priskiri mybriefa, o toliau jį keiti
//            Boolean goodHeading = true;
//            for (String swearWord : SWEAR_WORDS) {
//                if (article.getHeading().toLowerCase().contains(swearWord) ) {
//                    goodHeading = false;   
//                } else {
//                    myHeading = article.getHeading();
//                    myBrief = myBrief.replaceAll("(?i)"+swearWord, "***"); // nes tavo atveju vis iškvieti pe naują ir dėl to ne visur pakeičia
//                    //myBrief = article.getBrief().toLowerCase().replaceAll(swearWord.getSwearWord(), "***");
//                    }
//                }
//            if (goodHeading) {
//                System.out.println(myHeading + "\n\t" + myBrief);
//                correctArticleList.add(new ArticleImpl(myHeading, myBrief));
//            }
//        }
//   
//        return correctArticleList;
//    }
//}
//
////	@Override
////	public List<Article> getArticles() {
////
////		for (Article article : articleList) {
////			String myBrief = article.getBrief();
////			String myHeading = article.getHeading();
////			Boolean correctHeading = true;
////
////			for (String sw : SWEAR_WORDS) {
////				if (myHeading.toLowerCase().contains(sw)) {
////					correctHeading = false;
////				} else {
////					myBrief = myBrief.replaceAll(sw, "***");
////				}
////			}
////
////			if (correctHeading) {
////				System.out.println("my Heading: " + myHeading + ". Briefing: " + myBrief);
////				correctArticleList.add(new ArticleImpl(myHeading, myBrief));
////			}
////		}
////
////			return correctArticleList;
////	}
////}
