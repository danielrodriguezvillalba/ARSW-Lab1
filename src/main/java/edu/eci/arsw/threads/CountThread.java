/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.threads;

/**
 *
 * @author hcadavid
 */
public class CountThread implements Runnable{
    
	Thread t;
	int inicio;
	int fin;
	
	public CountThread(int A, int B) {
		inicio = A;
		fin = B;
		t = new Thread(this, "nuevo hilo");
		t.start();
//		try {
//			t.join();
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

	@Override
	public void run() {
		long starttime = System.nanoTime();
		for (int contador = inicio;contador<=fin;contador++) {
			System.out.println("num: "+contador);
		}
		long endtime = System.nanoTime();
		System.out.println("tiempo: "+(starttime-endtime));     
	}	
}
