package agh_lab8;

import java.io.FileNotFoundException;
import java.util.List;

public class Reader {
	private static List<String> constitution;

	public static void main(String[] args) {
		Parser parser = new Parser();
		try {
		constitution=parser.parse(args);
		} catch (FileNotFoundException e) {
			System.out.println(e);
		}
	}

}
