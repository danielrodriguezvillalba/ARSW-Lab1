/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.math;

import java.util.Arrays;

/**
 *
 * @author hcadavid
 */
public class Main {

	public static void main(String a[]) throws InterruptedException {
//		System.out.println(bytesToHex(PiDigits.getDigits(1, 2500))+"/"+bytesToHex(PiDigits.getDigits(2501, 2500))+"/"+bytesToHex(PiDigits.getDigits(5001, 2500))+"/"+bytesToHex(PiDigits.getDigits(7501, 2500))); 
//		System.out.println(bytesToHex(PiDigits.getDigits(1, 6666))+"/"+bytesToHex(PiDigits.getDigits(6667, 6666))+"/"+bytesToHex(PiDigits.getDigits(13333, 6668)));
//		System.out.println(bytesToHex(PiDigits.getDigits(1, 100)));
//		System.out.println(bytesToHex(PiDigits.getDigits(51, 100)));
//        System.out.println(bytesToHex(PiDigits.getDigits(1, 50))+"/"+bytesToHex(PiDigits.getDigits(51, 100))); 
//    	long start1 = System.nanoTime();
//        System.out.println(bytesToHex(PiDigits.getDigits(1, 501)));
//        long end1 = System.nanoTime();
//        System.out.println("sequential code took :"+(double)(end1-start1)/1e9 +" seconds");
//        long start5 = System.nanoTime();
//        System.out.println(bytesToHex(PiDigits.getDigits(501, 500)));
//        long end5 = System.nanoTime();
//        System.out.println("sequential code took :"+(double)(end5-start5)/1e9 +" seconds");
//        System.out.println(bytesToHex(PiDigits.getDigits(1, 500))+"/"+bytesToHex(PiDigits.getDigits(501, 500)));
//		long start2 = System.nanoTime();
//		System.out.println(PiDigits.getSubSubDigits(1, 1000, 1));
//		long end2 = System.nanoTime();
//		System.out.println("parallel code took :" + (double) (end2 - start2) / 1e9 + " seconds");
//		long start4 = System.nanoTime();
//		System.out.println(PiDigits.getDigits(1, 100, 1));
//		long end4 = System.nanoTime();
//		System.out.println("parallel code took :" + (double) (end4 - start4) / 1e9 + " seconds");
//		long start7 = System.nanoTime();
//		System.out.println(PiDigits.getDigits(1, 10000, 2));
//		long end7 = System.nanoTime();
//		System.out.println("parallel code took :" + (double) (end7 - start7) / 1e9 + " seconds");
//		long start8 = System.nanoTime();
//		System.out.println(PiDigits.getDigits(1, 20000, 3));
//		long end8 = System.nanoTime();
//		System.out.println("parallel code took :" + (double) (end8 - start8) / 1e9 + " seconds");
//        long start3 = System.nanoTime();
        System.out.println(PiDigits.getDigits(1, 1000000, 500));
//        long end3 = System.nanoTime();
//        System.out.println("parallel code took :"+(double)(end3-start3)/1e9 +" seconds");
//		String s1 = new String(bytesToHex(PiDigits.getDigits(1, 100)));
//    	String s2 = new String(PiDigits.getDigits(1, 100, 1));
//        System.out.println(s1.equals(s2));
	}

	private final static char[] hexArray = "0123456789ABCDEF".toCharArray();

	public static String bytesToHex(byte[] bytes) {
		char[] hexChars = new char[bytes.length * 2];
		for (int j = 0; j < bytes.length; j++) {
			int v = bytes[j] & 0xFF;
			hexChars[j * 2] = hexArray[v >>> 4];
			hexChars[j * 2 + 1] = hexArray[v & 0x0F];
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < hexChars.length; i = i + 2) {
			// sb.append(hexChars[i]);
			sb.append(hexChars[i + 1]);
		}
		return sb.toString();
	}
}
