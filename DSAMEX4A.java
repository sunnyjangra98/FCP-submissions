package foobar;

import java.util.Scanner;

public class DSAMEX4A {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int m=in.nextInt();
		int n=in.nextInt();
		int[] a=new int[m];
		int[] b=new int[n];
		for (int i=0;i<m;i++)
			a[i]=in.nextInt();
		for (int i=0;i<n;i++)
			b[i]=in.nextInt();
		boolean flag=false;
		int count=0;
		if (m<n){
			int count_max=0;
			for (int i=0;i<m;i++){
				//System.out.println("a[i] : "+a[i]);
				for (int j=count_max;j<n;j++){
					//System.out.println("b[j] : "+b[j]);
					if (a[i]==b[j]){
						System.out.print(b[j]+" ");
						count_max=j+1;
						count++;
						//System.out.println("count_max : "+count_max);
						break;
					}
				}
			}
			flag=true;
		}
		else if (m>n){
			int count_max=0;
			for (int i=0;i<n;i++){
				//System.out.println("b[i] : "+b[i]);
				for (int j=count_max;j<m;j++){
					//System.out.println("a[j] : "+a[j]);
					if (b[i]==a[j]){
						System.out.print(a[j]+" ");
						count_max=j+1;
						count++;
						//System.out.println("count_max : "+count_max);
						break;
					}
				}
			}
			flag=true;
		}
		else {
			int count_max=0;
			for (int i=0;i<m;i++){
				//System.out.println("a[i] : "+a[i]);
				for (int j=count_max;j<m;j++){
					//System.out.println("b[j] : "+b[j]);
					if (a[i]==b[j]){
						System.out.print(b[j]+" ");
						count_max=j+1;
						count++;
						//System.out.println("count_max : "+count_max);
						break;
					}
				}
			}
			flag=true;
		}
		if (count==0)
			System.out.println("NULL");
		in.close();
	}

}
