package agh_lab8;

import java.util.List;
import java.util.Map;

public class Chapter {
	
	private List<String> constitutionList;
	private Map<Integer, Integer> constitutionMap;
	private int chapterNumber;
	private String chapter = new String();
	
	public Chapter(List<String> cList, Map<Integer, Integer> cMap, int chNum) throws IllegalArgumentException {
		if(cMap.get(chNum)==null) {
			throw new IllegalArgumentException("Chapter " + chNum + " does not exist!");
		}
		this.constitutionList=cList;
		this.constitutionMap=cMap;
		this.chapterNumber=chNum;
	}
	
	public String getChapter() {
		for(int i=constitutionMap.get(chapterNumber); i<constitutionMap.get(chapterNumber+1); i++) {
			String line = constitutionList.get(i);
			if(line.charAt(line.length()-1)!='-') {
				chapter = chapter + line + '\n';
			}
			else {
				chapter = chapter + line.substring(0, line.lastIndexOf(" ")) + '\n'
						+ line.substring(line.lastIndexOf(" ")+1,line.length()-1);	
			}
		}
		return chapter;
	}
	
}
