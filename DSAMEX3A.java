package dsa_labs;

import java.util.Scanner;

public class Set3_clever_method {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int sizeOfA=in.nextInt();
		int sizeOfB=in.nextInt();
		int[] a=new int[sizeOfA];
		int[] b=new int[sizeOfB];
		for (int i=0;i<sizeOfA;i++)
			a[i]=in.nextInt();
		for (int i=0;i<sizeOfB;i++)
			b[i]=in.nextInt();
		int j=0,k=0;
		for (int i=0;i<(sizeOfA+sizeOfB);i++){
			if (i<sizeOfA)
				System.out.print(a[i]+" ");
			if (i<sizeOfB)
				System.out.print(b[i]+" ");
		}
		in.close();

	}

}
