package foobar;

import java.util.Scanner;

public class VECTOR {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int t,n,sx,sy,sz,t1,t2,t3;
	    t=in.nextInt();
	    while(t-->0)
	    {
	        n=in.nextInt();
	        sx=sy=sz=0;
	        for(int i=0;i<n;i++)
	        {
	            t1=in.nextInt();
	            t2=in.nextInt();
	            t3=in.nextInt();
	            sx+=t1;
	            sy+=t2;
	            sz+=t3;
	        }
	        if(prime(sx) && prime(sy) && prime(sz)) 
	        	System.out.println("YES");
	        else System.out.println("NO");

	    }
		in.close();

	}
	public static boolean prime(int n){
	    for(int i=2;i<=(n/2);i++)
	    {
	        if(n%i==0) {return false;}
	    }
	    if(n==1 || n==0) {return false;}
	    return true;
	}

}
