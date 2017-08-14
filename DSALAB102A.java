package dsa_labs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Read10 {
    static BufferedReader reader;
    static StringTokenizer tokenizer;
    static void init(InputStream input) {
        reader = new BufferedReader(
                     new InputStreamReader(input) );
        tokenizer = new StringTokenizer("");
    }
    static String next() throws IOException {
        while ( ! tokenizer.hasMoreTokens() ) {
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

class gnode{
	int data;
	gnode link;
	gnode()
	{
		data=0;
		link=null;
	}
}
class graph{
	int[] a;
	
	boolean[] visited;
	gnode[] arr;
	
	graph(int web)
	{
		a=new int[web+1];
		visited=new boolean[web + 1];
		arr=new gnode[web + 1];
		for(int i=0;i<web+1;i++)
		{
			arr[i]=new gnode();
		}
		visited[0]=true;
		for(int i=1;i<web+1;i++)
		{
			visited[i]=false;
		}
	}
	
	public void insert(int x,int y)
	{
		gnode temp=new gnode();
		temp.data=x;
		gnode temp2=new gnode();
		temp2.data=y;
		gnode t=arr[x];
		while(t.link!=null)
		{
			t=t.link;
		}
		t.link=temp2;
		gnode t1=arr[y];
		while(t1.link!=null)
		{
			t1=t1.link;
		}
		t1.link=temp;
	}
	
	public void dfs(int s,int y)
	{
		a[y]++;
		visited[s]=true;
		gnode t=arr[s];
		while(t.link!=null)
		{
			t=t.link;
			if(visited[t.data]==false)
			{
				dfs(t.data,y);
			}
		}
	}
	public int[] sort(int[] array,int size)
	{
		for(int i=1;i<size+1;i++)
		{
			int min=i;
			for(int j=i+1;j<size+1;j++)
			{
				if(array[j]<array[min])
				{
					min=j;
				}
			}
			int t=array[min];
			array[min]=array[i];
			array[i]=t;
		}
		return array;
	}
	
}

public class lab_10 {

	public static void main(String[] args) throws IOException {
		int domain=0;
		Read10.init(System.in);
		int n=Read10.nextInt();
		int d=Read10.nextInt();
		graph obj=new graph(n);
		for(int i=0;i<d;i++)
		{
			int x=Read10.nextInt();
			int y=Read10.nextInt();
			obj.insert(x, y);
		}
		for(int i=1;i<=n;i++)
		{
			if(obj.visited[i]==false)
			{
				domain++;
				obj.dfs(i,domain);
			}
		}
		obj.a=obj.sort(obj.a, domain);
		
		System.out.println(domain);
		for(int i=1;i<domain+1;i++)
		{
			System.out.print(obj.a[i] + " ");
		}
	}
}
