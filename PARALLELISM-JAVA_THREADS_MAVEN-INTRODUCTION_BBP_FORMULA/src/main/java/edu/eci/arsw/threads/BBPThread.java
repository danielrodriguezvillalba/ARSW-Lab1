package edu.eci.arsw.threads;

import edu.eci.arsw.math.PiDigits;

public class BBPThread extends Thread{
	int inicio, count;
	byte[] arreglo;
	
	public BBPThread(double inicio, double count) {
		this.inicio = (int)inicio;
		this.count = (int)count;
	}
	@Override
	public void run() {
		arreglo = PiDigits.getDigits(inicio, count);
	}
	
	public byte[] getRes() {
		return arreglo;
	}
}
