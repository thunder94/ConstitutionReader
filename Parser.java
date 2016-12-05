package agh_lab8;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Parser {
	private static File constitutionFile;
	private static Scanner constitutionScanner;
	private List<String> constitutionList = new ArrayList<String>();
	
	public List<String> parse(String[] args) throws IllegalArgumentException, FileNotFoundException {
		if(args.length!=4 && args.length!=3) throw new IllegalArgumentException("Invalid number of arguments!");
		constitutionFile = new File(args[0]);
		constitutionScanner = new Scanner(constitutionFile);
		while(constitutionScanner.hasNext()) {
			if(!(constitutionScanner.hasNext("©Kancelaria Sejmu") || constitutionScanner.hasNext("2009-11-16"))) {
				constitutionList.add(constitutionScanner.nextLine());
			}	
		}
		return constitutionList;
	}
	
}
