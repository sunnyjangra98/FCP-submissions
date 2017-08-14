package foobar;

import java.util.Scanner;

public class PS49F {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		String k1,k2;
		char[] res=new char[61];
		int n1=in.nextInt();
		int n2=in.nextInt();
		k1=in.next();
		k2=in.next();
		int t=in.nextInt();
		int P=0;
		for(int i=0;i<n1;i++) {
		      P = n1-i-1;
		      P += Math.min( Math.max(t-i,0), n2 );
		      res[P] = k1.charAt(i);
		   }
		for(int i=0;i<n2;i++) {
			P = n1+i;
		    P -= Math.min( Math.max(t-i,0), n1 );
		    res[P] = k2.charAt(i);
		}
		int i=0;
		while (i<(n1+n2)){
			System.out.print(res[i]);
			i++;
		}
		in.close();

	}

}
