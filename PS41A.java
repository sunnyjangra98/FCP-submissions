package foobar;

import java.util.Scanner;

class PS41A {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		int[] a=new int[n];
		for (int i=0;i<n;i++)
			a[i]=in.nextInt();
		int max=a[0]+a[1];
		for (int i=1;i<n-1;i++){
			if (max<(a[i]+a[i+1]))
				max=a[i]+a[i+1];
		}
		System.out.println(max);
		in.close();

	}

}
