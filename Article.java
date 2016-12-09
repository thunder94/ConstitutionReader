package agh_lab8;

import java.util.List;
import java.util.Map;

public class Article {
	
	private List<String> constitutionList;
	private Map<Integer, Integer> constitutionMap;
	private int articleNumber;
	private int firstArticleNumber;
	private int lastArticleNumber;
	private String article = new String();
	private String articles = new String();
	
	public Article (List<String> cList, Map<Integer, Integer> cMap, int artNum) throws IllegalArgumentException {
		if(cMap.get(artNum)==null) {
			throw new IllegalArgumentException("Article " + artNum + " does not exist!");
		}
		this.constitutionList=cList;
		this.constitutionMap=cMap;
		this.articleNumber=artNum;
	}
	
	public Article (List<String> cList, Map<Integer, Integer> cMap, int fArtNum, int lArtNum) throws IllegalArgumentException {
		if(cMap.get(fArtNum)==null) {
			throw new IllegalArgumentException("Article " + fArtNum + " does not exist!");
		}
		if(cMap.get(lArtNum)==null) {
			throw new IllegalArgumentException("Article " + lArtNum + " does not exist!");
		}
		if(lArtNum<=fArtNum) {
			throw new IllegalArgumentException("Second article number must be greater than first!");
		}
		this.constitutionList=cList;
		this.constitutionMap=cMap;
		this.firstArticleNumber=fArtNum;
		this.lastArticleNumber=lArtNum;
	}
		
	public String getArticle() {
		for(int i=constitutionMap.get(articleNumber); i<constitutionMap.get(articleNumber+1); i++) {
			String line = constitutionList.get(i);
			if(line.charAt(line.length()-1)!='-') {
				article = article + line + '\n';
			}
			else {
				article = article + line.substring(0, line.lastIndexOf(" ")) + '\n'
						+ line.substring(line.lastIndexOf(" ")+1,line.length()-1);	
			}
		}
		return article;
	}
	
	public String getArticles() {
		for(int i=constitutionMap.get(firstArticleNumber); i<constitutionMap.get(lastArticleNumber+1); i++) {
			String line = constitutionList.get(i);
			if(line.charAt(line.length()-1)!='-') {
				articles = articles + line + '\n';
			}
			else {
				articles = articles + line.substring(0, line.lastIndexOf(" ")) + '\n'
						+ line.substring(line.lastIndexOf(" ")+1,line.length()-1);	
			}
		}
		return articles;
	}
	
}
