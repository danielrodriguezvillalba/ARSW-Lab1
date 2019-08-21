package edu.eci.arsw.math;

import java.util.ArrayList;
import java.util.List;

///  <summary>
///  An implementation of the Bailey-Borwein-Plouffe formula for calculating hexadecimal
///  digits of pi.
///  https://en.wikipedia.org/wiki/Bailey%E2%80%93Borwein%E2%80%93Plouffe_formula
///  *** Translated from C# code: https://github.com/mmoroney/DigitsOfPi ***
///  </summary>
public class PiDigits {

	private static int DigitsPerSum = 8;
	private static double Epsilon = 1e-17;
	private static String respuesta = "";

	/**
	 * Returns a range of hexadecimal digits of pi.
	 * 
	 * @param start The starting location of the range.
	 * @param count The number of digits to return
	 * @return An array containing the hexadecimal digits.
	 */
	public static byte[] getDigits(int start, int count) {
		if (start < 0) {
			throw new RuntimeException("Invalid Interval");
		}

		if (count < 0) {
			throw new RuntimeException("Invalid Interval");
		}

		byte[] digits = new byte[count];
		double sum = 0;

		for (int i = 0; i < count; i++) {
			if (i % DigitsPerSum == 0) {
				sum = 4 * sum(1, start) - 2 * sum(4, start) - sum(5, start) - sum(6, start);

				start += DigitsPerSum;
			}

			sum = 16 * (sum - Math.floor(sum));
			digits[i] = (byte) sum;
		}

		return digits;
	}
	
	//	not used
	public static String getDigitsSuperSplit(int start, int count, int nThreads) throws InterruptedException {		
		int countInterval;
		int nStart = start;
		String respuesta = "";
		if (count >= 10000) {
			countInterval = count / 1000;			
			for(int i = 0;i<countInterval;i++) {
				if(i==0) {
					respuesta += getDigits(start, 1000, nThreads);
				}
				else {
					start += 1000;
					respuesta += getDigits(start, 1000, nThreads);
				}
			}
			return respuesta;
		}
		else {
			return getDigits(start, count, nThreads);
		}		
	}
	
	//This method divides the load of calculate the nth digit of pi into n lightweight loads, then concatenates the result.
	public static String getDigits(int start, int count, int nThreads) throws InterruptedException {
		int interval = count / nThreads;
		int residuo = count % nThreads;
		int ini = start;
		int fin = interval;
		BBpFormulaThread thr;

		ThreadGroup tg = new ThreadGroup("pidigits");

		int ap = Runtime.getRuntime().availableProcessors();

		List<BBpFormulaThread> threadsList = new ArrayList<BBpFormulaThread>();

		for (int i = 1; i <= nThreads; i++) {
			if (i == 1) {
				thr = new BBpFormulaThread("piDigits" + i, tg, ini, fin);
				threadsList.add(thr);
				thr.start();
			} else if (i == nThreads) {
				ini += fin;
				thr = new BBpFormulaThread("piDigits" + i, tg, ini, fin + residuo);
				threadsList.add(thr);
				thr.start();
			} else {
				ini += fin;
				thr = new BBpFormulaThread("piDigits" + i, tg, ini, fin);
				threadsList.add(thr);
				thr.start();
			}
		}
		//Have the main thread to wait to the other threads
		for (int i = 0; i < threadsList.size(); i++) {
			threadsList.get(i).join();
		}

		/* finally concatenate the results */
		StringBuilder sb = new StringBuilder();
		for (int f = 0; f < threadsList.size(); f++) {
			sb.append(threadsList.get(f).getRes());
			respuesta = sb.toString();
		}
		return respuesta;
	}

	////////////////////////////
	/* getDigits method backup - not used*/
    public static String getDigits2(int start, int count, int nThreads) throws InterruptedException {
    	int interval = (count/nThreads);
    	int residuo = ((count-start)%nThreads);
    	int ini = start;
    	int fin = interval;
    	int index = 0;
    	BBpFormulaThread thr;
    	
    	ThreadGroup tg = new ThreadGroup("pidigits");
    	
    	int ap = Runtime.getRuntime().availableProcessors();
    	
    	List<BBpFormulaThread> threadsList = new ArrayList<BBpFormulaThread>();
    	
    	for(int i = 1;i<=nThreads;i++) {
    		if(i==1) {
    			thr = new BBpFormulaThread("piDigits"+i, tg, ini, fin);
    			threadsList.add(thr);
    			thr.start();
    		}
			else if (i==nThreads) {
				ini=fin+1;	
				thr = new BBpFormulaThread("piDigits"+i, tg, ini, (fin + residuo));
				threadsList.add(thr);
				thr.start();
			}
			else {
				ini=fin+1;
				thr = new BBpFormulaThread("piDigits"+i, tg, ini, fin);
				threadsList.add(thr);
				thr.start();
			}	    		
    	}
    	
//    	while (index < threadsList.size()) {
//    		if(tg.activeCount()<ap) {    			
//    			threadsList.get(index).start();
//    			index++;
//    		}else {
//    			/*wait 0.1 second before checking again*/
//    			try {Thread.sleep(100);} 
//				catch (InterruptedException e) {e.printStackTrace();}
//    		}
//    	}
    	/*wait for threads to finish -> JOIN */
//    	while(tg.activeCount()>0) {
//    		try {Thread.sleep(10);} 
//			catch (InterruptedException e) {e.printStackTrace();}
//    	}
//    	for (int i=0;i<threadsList.size();i++) {
//    		threadsList.get(i).start();
//    	}
    	for (int i=0;i<threadsList.size();i++) {
    		threadsList.get(i).join();
    	}
    	
    	/*finally concatenate the results */
    	StringBuilder sb=new StringBuilder();
    	for (int f = 0;f<threadsList.size();f++) {
    		sb.append(threadsList.get(f).getRes());
    		respuesta = sb.toString(); 
    	}
    	return respuesta;
    	
    }

	/// <summary>
	/// Returns the sum of 16^(n - k)/(8 * k + m) from 0 to k.
	/// </summary>
	/// <param name="m"></param>
	/// <param name="n"></param>
	/// <returns></returns>
	private static double sum(int m, int n) {
		double sum = 0;
		int d = m;
		int power = n;

		while (true) {
			double term;

			if (power > 0) {
				term = (double) hexExponentModulo(power, d) / d;
			} else {
				term = Math.pow(16, power) / d;
				if (term < Epsilon) {
					break;
				}
			}

			sum += term;
			power--;
			d += 8;
		}

		return sum;
	}

	/// <summary>
	/// Return 16^p mod m.
	/// </summary>
	/// <param name="p"></param>
	/// <param name="m"></param>
	/// <returns></returns>
	private static int hexExponentModulo(int p, int m) {
		int power = 1;
		while (power * 2 <= p) {
			power *= 2;
		}

		int result = 1;

		while (power > 0) {
			if (p >= power) {
				result *= 16;
				result %= m;
				p -= power;
			}

			power /= 2;

			if (power > 0) {
				result *= result;
				result %= m;
			}
		}

		return result;
	}

}
