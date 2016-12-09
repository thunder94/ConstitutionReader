package agh_lab8;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Reader {
	
	private static List<String> constitutionList;
	private static Map<Integer, Integer> constitutionMap;
	private static String reader;

	public static void main(String[] args) {
		try {
		Parser constitutionParser = new Parser();
		constitutionList = constitutionParser.parse(args);
		constitutionMap = new Constitution().getHashMap(constitutionList, constitutionParser.readingMode);
			if(constitutionParser.argNum==3) {
				if(constitutionParser.readingMode.equals("c")) {
					reader = new Chapter(constitutionList,constitutionMap,constitutionParser.chapterNumber).getChapter();
					System.out.println(reader);
				}
				else {
					reader = new Article(constitutionList,constitutionMap,constitutionParser.articleNumber).getArticle();
					System.out.println(reader);
				}
			}
			else {
				reader = new Article(constitutionList,constitutionMap,constitutionParser.firstArticleNumber,constitutionParser.lastArticleNumber).getArticles();
				System.out.println(reader);
			}
		} catch (IOException | IllegalArgumentException e) {
			System.out.println(e);
		}
	}

}
