package agh_lab8;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Reader {

	private static File constitution;
	private static Scanner constitutionScanner;

	public static void main(String[] args) throws FileNotFoundException {
		constitution = new File(args[0]);
		constitutionScanner = new Scanner(constitution);
		for(int i=1; i<=2014; i++)
		System.out.println(constitutionScanner.nextLine());
	}

}
