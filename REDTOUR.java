package foobar;

import java.util.Scanner;

public class REDTOUR {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int t,n,i,ans,ans1;
	    t=in.nextInt();
	    while(t-->0){
	        n=in.nextInt();
	        ans=1;
	        for(i=0;i<n;i++)
	        {
	            ans1=in.nextInt();
	            if(ans1>ans) ans=ans1;
	        }
	        System.out.println(ans);
	    }
		in.close();

	}

}
