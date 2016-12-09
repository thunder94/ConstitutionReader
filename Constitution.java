package agh_lab8;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Constitution {
	
	private int key=1;
	private Map<Integer, Integer> constitutionHashMap = new HashMap<>();
	
	public Map<Integer, Integer> getHashMap (List<String> constitutionList, String readingMode) {
		
		if(readingMode.equals("a")) {
			for(int value=0; value<constitutionList.size(); value++) {
				if(constitutionList.get(value).length()>=7 && constitutionList.get(value).substring(0,4).equals("Art.")) {
					constitutionHashMap.put(key, value);
					key++;
				}
			}
		}
		
		else {
			for(int value=0; value<constitutionList.size(); value++) {
				if(constitutionList.get(value).length()>=10 && constitutionList.get(value).substring(0,8).equals("Rozdzia³")) {
					constitutionHashMap.put(key, value);
					key++;
				}
			}		
		}
		
		return constitutionHashMap;
	
	}
	
}
