package foobar;

import java.util.Scanner;

public class GUTR {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int t=in.nextInt();
		while (t-->0){
			int fret=in.nextInt();
			int stringnumber=in.nextInt();
			switch (fret){
			case 1:	fret=5; break;
			case 2: fret=2; break;
			case 3: fret=0; break;
			case 4: fret=4; break;
			case 5: fret=1; break;
			case 6: fret=5; break;
			}
			switch((fret+stringnumber)%7){
			case 0: System.out.println("G"); break;
			case 1: System.out.println("A"); break;
			case 2: System.out.println("B"); break;
			case 3: System.out.println("C"); break;
			case 4: System.out.println("D"); break;
			case 5: System.out.println("E"); break;
			case 6: System.out.println("F"); break;
			}
		}
		in.close();

	}

}
