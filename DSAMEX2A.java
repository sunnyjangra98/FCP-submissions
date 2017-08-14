package dsa_labs;

import java.util.Scanner;

public class Set2_clever_method {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		int[] a=new int[n];
		int[] b,c=new int[n/2];
		if (n%2==0)
			b=new int[n/2];
		else
			b=new int[n/2+1];
		int j=0,k=0;
		for (int i=0;i<n;i++){
			int element=in.nextInt();
			if ((i+1)%2!=0){
				b[j]=element;
				j++;
			}
			else{
				c[k]=element;
				k++;
			}
		}
		for (int i=0;i<b.length;i++)
			System.out.print(b[i]+" ");
		System.out.println();
		for (int i=0;i<c.length;i++)
			System.out.print(c[i]+" ");
		in.close();

	}

}
