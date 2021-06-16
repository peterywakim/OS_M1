package Main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;

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
			System.out.println(filePath + " was read succesfuly");//// comment this after being done
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


	
//	public static String Printconcatenate (String [] x ) {
//		String y = "";
//		for(int i =1 ; i<x.length;i++) {
//			y.concat(x[i]);
//			
//			
//		}
//		return y;
//	}

	public static void readFunctions(String[][] file) throws Exception {///// check if there an unknown command to give
																		///// syntax error
		for (int i = 0; i < file.length; i++) {

			try {
				switch (file[i][0]) {
				case "print":
					String y = file[i][1] + " " + file[i][2];
					//System.out.println(y);
					System.out.println("Printing ...." + y);
					String[][] x = loadFile(y);
					printArray(x);
					break;
				case "assign":
					assign(file[i][1], file[i][2]);
					break;
				case "writeFile":
					y= file[i][2]; ///This is the file name
					break;
				case "readFile":
					y = file[i][1] + " " + file[i][2];
					System.out.println("Reading .... " + y);
					x = loadFile(y);
					printArray(x);
					break;
				case "add":
					break;
				case "":
					break;
				default:
					throw new Exception("Unkown Command Please Check line : " + (i + 1));

				}
			} catch (Exception e) {
				System.out.println("Syntax Error : ....." + e.getMessage());
				break;

			}

		}
	}
	
	public static void assign (String Variable, String value) throws Exception {
		
		Hashtable <Integer, String> hash1 = new Hashtable<>();
		String assignedValue = null;
		int intValue = 0;
		
		//Get the variable's ASCII code to use it as Hash key
		char aChar = Variable.charAt(0);
		int ascii = aChar; 
		int Hashkey = ascii-96; //To start from 1 not 97
		
		//check if the value entered is a string of numbers (numeric):
		//if Numeric -> parse
		if(isNumeric(value)) {
			intValue = Integer.parseInt(value);
			assignedValue = Variable + "=" + intValue ;
		}
		else {
			if(value == "readFile") {
				//forward to readFile (-->>Mohanad<<--)
				
			}
			else {
				assignedValue = Variable + "=" + value;
			}
		}
		
        
        //insert the assignment equation in the hashtable
        hash1.put(Hashkey, assignedValue);
        
		
		System.out.println("The assigned values are: " + hash1);
		
		
	}
	
	//Check if the String is numeric
	public static boolean isNumeric(String strNum) {
	    if (strNum == null) {
	        return false;
	    }
	    try {
	        double d = Double.parseDouble(strNum);
	    } catch (NumberFormatException nfe) {
	        return false;
	    }
	    return true;
	}

	////////////////////////// Method to print 2-D array//////////////////
	public static void printArray(String[][] array) {
		System.out.println(Arrays.deepToString(array));

	}

	public static void main(String[] args) throws Exception {

		//////////////////////////////// Testing ///////////////////
		String[][] b = loadFile("Program 2.txt");// load file into 2D array
		readFunctions(b);
		/*
		 * should throw an exception and display error to the user in case of unknown
		 * command as part of compiling , first error found will be Syntax
		 */
		printArray(b);
		
		
	}

}
