package foobar;

import java.util.Scanner;

public class DSAMEX4B {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		int[][] a=new int[n][n];
		for (int i=0;i<n;i++)
			for (int j=0;j<n;j++)
				a[i][j]=in.nextInt();
		boolean x=true,y=true;
		for (int i=0;i<n/2;i++){
			for (int j=0;j<n;j++){
				if (a[i][j]==a[n-i-1][j])
					x=true;
				else {
					x=false;
					break;
				}
			}
		}
		if (x)
			System.out.println("YES");
		else System.out.println("NO");
		
		for (int i=0;i<n;i++){
			for (int j=0;j<n/2;j++){
				if (a[i][j]==a[i][n-j-1])
					y=true;
				else {
					y=false;
					break;
				}
			}
		}
		if (y)
			System.out.println("YES");
		else System.out.println("NO");
		in.close();

	}

}
