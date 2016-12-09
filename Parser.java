package agh_lab8;

import java.util.ArrayList;
import java.util.List;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;

public class Parser {
	
	private List<String> constitutionList = new ArrayList<String>();
	int argNum;
	String readingMode;
	int chapterNumber;
	int articleNumber;
	int firstArticleNumber;
	int lastArticleNumber;
	
	public List<String> parse(String[] args) throws IllegalArgumentException, IOException {
		argNum = args.length;
		switch(argNum) {
		case 3: switch(args[1]) {
				case "a": 	readingMode = "a";
							articleNumber = Integer.parseInt(args[2]);
							break;
				case "c": 	readingMode = "c";
							chapterNumber = Integer.parseInt(args[2]);
							break;
				default:	throw new IllegalArgumentException("Second argument must be: a or c");	
				}
				break;
				
		case 4: if(args[1].equals("a")) {
					readingMode = "a";
					firstArticleNumber = Integer.parseInt(args[2]);
					lastArticleNumber = Integer.parseInt(args[3]);
				}
				else {
					throw new IllegalArgumentException("Second argument must be: a");
				}
				break;
				
		default: throw new IllegalArgumentException("Invalid number of arguments! Must be 3 or 4!");
		}
		
		BufferedReader constitutionReader = new BufferedReader(new FileReader(args[0]));
		String fileLine;
		while((fileLine=constitutionReader.readLine())!=null) {
			if(!(fileLine.equals("©Kancelaria Sejmu") || fileLine.equals("2009-11-16"))) {
				constitutionList.add(fileLine);
			}
		}
		constitutionReader.close();
		return constitutionList;
	}
	
}
