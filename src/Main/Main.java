package Main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
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
	public static void readFile(String[][] file) {
		for (int i = 0; i < file.length; i++) {
			String y = file[i][1] + " " + file[i][2];
			String[][] x = loadFile(y);
			y = file[i][1] + " " + file[i][2];
			System.out.println("Reading .... " + y);
			x = loadFile(y);
		
		}
	
	}

	public void writeFile(String StrFile,String StrData) {
		try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(StrFile,true))){
			bufferedWriter.write(StrData);
		} catch( IOException e) {
			
		e.printStackTrace();
			
		}
				
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
	public static int add( int x, int y ) {
		x+=y;
		return x;
		
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
		
		
		// you should inislize operating system here

		//////////////////////////////// Testing ///////////////////
		String[][] b = loadFile("Program 2.txt");// load file into 2D array
		readFunctions(b);
		/*
		 * should throw an exception and display error to the user in case of unknown
		 * command as part of compiling , first error found will be Syntax
		 */
		printArray(b);
		int i,j,k,q,sum=0;
		// n # of processes = 3
		// bt burst time ( assume it is 5 )
		//wt waiting time 
		// tat turn around time
		
		
		int n=3;
		int bt[]=new int[n];
		int wt[]=new int[n];
		int tat[]=new int[n];
		int a[]=new int[n];
		
		for(i=0;i<n;i++){
			
			bt[i]=5 + (i+1);
		}
		//q time quantam
		 q=2;
		for(i=0;i<n;i++)
			a[i]=bt[i];
		for(i=0;i<n;i++)
			wt[i]=0;
		do{
		for(i=0;i<n;i++){
			if(bt[i]>q){
				bt[i]-=q;
				for(j=0;j<n;j++){
					if((j!=i)&&(bt[j]!=0))
					wt[j]+=q;
				}
			}
			else{
				for(j=0;j<n;j++){
					if((j!=i)&&(bt[j]!=0))
					wt[j]+=bt[i];
				}
				bt[i]=0;
			}
		}
		sum=0;
		for(k=0;k<n;k++)
			sum=sum+bt[k];
		}
		while(sum!=0);
		for(i=0;i<n;i++)
			tat[i]=wt[i]+a[i];
		System.out.println("process\t\tBT\tWT\tTAT");
		for(i=0;i<n;i++){
			System.out.println("process"+(i+1)+"\t"+a[i]+"\t"+wt[i]+"\t"+tat[i]);
		}
		float avg_wt=0;
		float avg_tat=0;
		for(j=0;j<n;j++){
			avg_wt+=wt[j];
		}
		for(j=0;j<n;j++){
			avg_tat+=tat[j];
		}
		System.out.println("average waiting time "+(avg_wt/n)+"\n Average turn around time"+(avg_tat/n));
	}
		
	}


