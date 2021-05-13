package Main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

	private static String[][] loadFile(String filePath) {
		ArrayList<String[]> lines = new ArrayList<>();

		BufferedReader reader = null;
		String line = null;
		try {
			reader = new BufferedReader(new FileReader(filePath));
			while ((line = reader.readLine()) != null) {
				lines.add(line.split(" "));
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (reader != null) {
					reader.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return lines.toArray(new String[][] {});
	}

	public static void readFunctions(String[][] file) throws Exception {///// check if there an unkown command to give
																		///// syntax error
		for (int i = 0; i < file.length; i++) {

			switch (file[i][0]) {
			case "print":
				break;
			case "assign":
				break;
			case "writeFile":
				break;
			case "add":
				break;
			case "":
				break;
			default:
				throw new Exception("Unkown command Please check line number " + (i + 1));

			}

		}
	}
	
	//////////////////////////Method to print 2-D array
	public static void printArray(String [] [] array) {
		System.out.println(Arrays.deepToString(array));
		
	}

	public static void main(String[] args) throws Exception {

		//////////////////////////////// Testing ///////////////////
		String[][] b = loadFile("Program 1.txt");// load file into 2D array
		readFunctions(b);
		 /*should throw an exception and display error to the user in case of
	 unkown command as part of compiling , first error found will be Syntax*/
		printArray(b);
	}

}
