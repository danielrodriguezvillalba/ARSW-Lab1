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
public class CountThreadsMain {

	public static void main(String a[]) {
//    	long starttime = System.nanoTime();
//        CountThread c1 = new CountThread(0, 99);
//        CountThread c2 = new CountThread(100, 199);
//        CountThread c3 = new CountThread(200, 299);
//        long endtime = System.nanoTime();  
		ThreadGroup tg = new ThreadGroup("main");
		System.out.println("valor:" + tg.activeCount() );
		System.out.println("valor: "+ Runtime.getRuntime().availableProcessors());
	}
}
