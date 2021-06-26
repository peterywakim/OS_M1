package Main;

public class PCB {
	String process_Id;
	int pc;
	boolean state = false;// default is false then it is not running
	int begin;
	int end;

	public PCB(String process_Id, int pc, boolean state, int begin, int end) {
		this.process_Id = process_Id;
		this.pc = pc;
		this.begin = begin;
		this.end = end;

	}

	public String getProcess_Id() {
		return process_Id;
	}

	public void setProcess_Id(String process_Id) {
		this.process_Id = process_Id;
	}

	public int getPc() {
		return pc;
	}

	public void setPc(int pc) {
		this.pc = pc;
	}

	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}

	public int getBegin() {
		return begin;
	}

	public void setBegin(int begin) {
		this.begin = begin;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

}
