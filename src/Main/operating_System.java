package Main;

public class operating_System {
	
	 static Object [] memory = new Object [1024];// 1 GB and you should distribite the PCBs and instruction on the memory
	 
	 
	 static String NewPCB(String filepath) {
		 
		 int begin = 0;
		 int end = 0;
		 int pc = 0;
		 String MemLocation = " ";
//		 Main main = new Main();
		 String[][] b =  Main.loadFile(filepath);
		 Main.readFile(b);
		 
		 if(filepath == "Program 1.txt") {
			 begin = (int)memory[0];
			 end = (int)memory[340];
			 PCB one = new PCB("1", pc, true, begin, end);
			 MemLocation = one.toString();
			 
		 }
		 
		 else if(filepath == "Program 2.txt") {
			 begin = (int)memory[341];
			 end = (int)memory[680];
			 PCB two = new PCB("2", 0, true, begin, end);
			 MemLocation = two.toString();
			 
		 }
		 else {
			 begin = (int)memory[681];
			 end = (int)memory[1020];
			 PCB three = new PCB("3", 0, true, begin, end);
			 MemLocation = three.toString();
			 
		 }
 
		 return MemLocation;
		 
	 }

	 
	 
	 
	 
	 
	public static void main(String[] args) {
		String newPCB = NewPCB("Program 1.txt");
		System.out.println("New Location" + newPCB);

		 
		
	}
	

}
