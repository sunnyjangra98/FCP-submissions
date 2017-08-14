package dsa_labs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Read9f {
    static BufferedReader reader;
    static StringTokenizer tokenizer;

    /** call this method to initialize reader for InputStream */
    static void init(InputStream input) {
        reader = new BufferedReader(
                     new InputStreamReader(input) );
        tokenizer = new StringTokenizer("");
    }

    /** get next word */
    static String next() throws IOException {
        while ( ! tokenizer.hasMoreTokens() ) {
            //TODO add check for eof if necessary
            tokenizer = new StringTokenizer(
                   reader.readLine() );
        }
        return tokenizer.nextToken();
    }

    static int nextInt() throws IOException {
        return Integer.parseInt( next() );
    }
	
    static double nextDouble() throws IOException {
        return Double.parseDouble( next() );
    }
}

class minheap1{
	int[] h=new int[256];
	int size=-1;
	int n=256;
	
	public void minheapify(int i)
	{
		int flag=1;
		
		while(i<=(size-1)/2  &&  flag==1)
		{
			int min=i;
			if(h[i]>h[2*i+1])
			{
				min=2*i +1;
			}
			if((2*i +2 <=size) && h[min]>h[2*i+2])
			{
				min=2*i+2;
				
			}
			if(min!=i)
			{
				int temp=h[min];
				h[min]=h[i];
				h[i]=temp;
				minheapify(min);	
			}
			else
				flag=0;
		}
		
	}
	
	public int deletemin()
	{
		int x=h[0];
		h[0]=h[size];
		
		size--;
		if(size>-1)
		{
		minheapify(0);
		}
		return x;
	}
	
	public void insert(int x)     
	{
		size++;
		h[size]=x;
		int i=size;
		if(size>0){
		while(h[i]<h[(i-1)/2])
		{
			int temp=h[i];
			h[i]=h[(i-1)/2];
			h[(i-1)/2]=temp;
			i=(i-1)/2;
		}}
	}
}



public class lab_9 {
	
	public static void main(String[] args) throws IOException {
	minheap1 obj=new minheap1();
	minheap1 obj1=new minheap1();
	int[] arr=new int[256];
	Read9f.init(System.in);
	int x=Read9f.nextInt();
	int y=Read9f.nextInt();
	int sum=0;
	for(int i=0;i<y;i++)
	{
		for(int j=0;j<x;j++)
		{
			int z=Read9f.nextInt();
			arr[z]++;
		}
	}
	for(int i=0;i<256;i++)
	{
		if(arr[i]>0)
		{
			
			obj.insert(arr[i]);
		}
	}
	if(obj.size>0){
	while(obj.size>0)
	{
		int a1=obj.deletemin();
		
		int a2=obj.deletemin();
		
		int a3=a2+a1;
		sum+=a3;
		obj.insert(a3);
		
	}}
	else
	{
		sum=x*y;
	}
	
	float ans1=(float)(x*y*8)/sum;
	
	ans1=Math.round(ans1*10);
	System.out.println(ans1/10);
	
	int[] arr2=new int[26];
	int k=0;
	for(int i=0;i<241;i+=10)
	{
		for(int j=0;j<10;j++)
		{
			arr2[k]+=arr[i+j];
		}
		k++;
	}
	k--;
	arr2[k]=arr[250]+arr[251]+arr[252] +arr[253]+arr[254]+arr[255];
	
	for(int i=0;i<25;i++)
	{
		if(arr2[i]>0)
		{
			obj1.insert(arr2[i]);
		}
	}
	int sum2=0;
	
	if(obj1.size>0)
	{
		
	while(obj1.size>0)
	{
		int b1=obj1.deletemin();
	
		int b2=obj1.deletemin();
		
		int b3=b2+b1;
		sum2+=b3;
		obj1.insert(b3);
		
	}}
	else{
		sum2=x*y;
	}
	
	float ans2=(float)(x*y*8)/sum2;
	ans2=Math.round(ans2*10);
	System.out.println(ans2/10);
	}

}
