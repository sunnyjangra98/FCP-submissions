package foobar;

import java.util.Scanner;

class FIND {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		int[] a=new int[n];
		for (int i=0;i<n;i++)
			a[i]=in.nextInt();
		int q=in.nextInt();
		while (q-->0){
			int x=in.nextInt();
			int y=in.nextInt();
			if (a[x-1]%2==0){
				if (x==n)
					System.out.println("Even");
				else if (a[x]!=0 || x==y)
					System.out.println("Even");
				else
					System.out.println("Odd");
			}
			else
				System.out.println("Odd");
		}
		in.close();
	}

}
