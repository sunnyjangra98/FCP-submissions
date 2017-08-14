package foobar;

import java.util.Scanner;

public class PS49E {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		int res=0;
		for (int i=2;i<n-1;i++)
			res+=(i-1)*(n-1-i);
		res*=n;
		res/=4;
		System.out.println(res);
		in.close();

	}

}
