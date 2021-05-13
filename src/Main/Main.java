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
	public static String Printconcatenate (String [] x ) {
		String y = "";
		for(int i =1 ; i<x.length;i++) {
			y.concat(x[i]);
			
			
		}
		return y;
	}

	public static void readFunctions(String[][] file) throws Exception {///// check if there an unkown command to give
																		///// syntax error
		for (int i = 0; i < file.length; i++) {

			switch (file[i][0]) {
			case "print":
				String y = file[i][1]+" "+file[i][2];
				System.out.println("Printing ...."+y);
				String [] [] x =loadFile(y);
				printArray(x);
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
				throw new Exception("Unkown Command Please Check line : " + (i + 1));

			}

		}
	}
	
	//////////////////////////Method to print 2-D array//////////////////
	public static void printArray(String [] [] array) {
		System.out.println(Arrays.deepToString(array));
		
	}

	public static void main(String[] args) throws Exception { 

		//////////////////////////////// Testing ///////////////////
		String[][] b = loadFile("Program 2.txt");// load file into 2D array
		readFunctions(b);
		 /*should throw an exception and display error to the user in case of
	 	unkown command as part of compiling , first error found will be Syntax*/
		printArray(b);
	}

}
