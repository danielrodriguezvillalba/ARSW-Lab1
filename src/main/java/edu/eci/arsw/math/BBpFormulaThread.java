package edu.eci.arsw.math;

/* this class is used to calculate a portion of the nth digit of pi */

public class BBpFormulaThread extends Thread{
	
	private String res;
	private String nameTh;
	private ThreadGroup tg;
	private  int start, end;
	private PiDigits gDigits;
//	private Main aHexa;
	
	public BBpFormulaThread(String name, ThreadGroup tg, int start, int end) {
		super(tg, name);
		this.nameTh = name;
		this.tg = tg;
		this.start = start;
		this.end = end;
		gDigits = new PiDigits();
//		aHexa = new Main();
		
	}	
	@Override
	public void run() {	
//		res = nameTh+"////////"+start+"//"+end+"/////////"+ Main.bytesToHex(PiDigits.getDigits(start, end));
		res = Main.bytesToHex(PiDigits.getDigits(start, end));
	}

	public String getRes() {return res;}
	public String getNameTh() {return nameTh;}
	public ThreadGroup getTg() {return tg;}	

}
