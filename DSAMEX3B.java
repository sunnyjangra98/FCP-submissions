package dsa_labs;

import java.util.Scanner;

public class Set3_repeattwice {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		int[] a=new int[n];
		for (int i=0;i<n;i++)
			a[i]=in.nextInt();
		for (int i=0;i<n;i++){
			int count=1,element=0;
			for (int j=i+1;j<n;j++){
				if (a[i]==a[j]){
					element=a[i];
					count++;
				}
			}
			if (count==2)
				System.out.print(element+" ");
		}
		in.close();

	}

}
