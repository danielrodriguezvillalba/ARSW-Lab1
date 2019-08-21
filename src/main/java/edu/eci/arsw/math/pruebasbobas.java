package edu.eci.arsw.math;

public class pruebasbobas {
	public static void main(String[] args) {
		pruebasbobas p = new pruebasbobas();
		p.contarraro(1, 100, 2);
	}

	public void contarraro(int start, int count, int n) {
		int interval = ((count-start)/n);
		int residuo = ((count-start)%n);
    	int ini = start;
    	int fin = start + interval;
    	System.out.println("intervalo: "+interval+" residuo : "+residuo);
		for (int i=1;i<=n;i++) {	
			if(i==1) {
				System.out.println("ini: "+ini+"fin: "+fin);
			}
			else if (i==n) {
				ini=fin+1;
				fin+=interval;
				System.out.println("ini: "+ini+"finale: "+(fin+residuo));
			}
			else {
				ini=fin+1;
				fin+=interval;
				System.out.println("ini: "+ini+"fin: "+fin);
			}	    	
		}
//		String s = "";
//		s = s + "holi,-";
//		s += "Que-tal?";
//		System.out.println(s);
	}
}
