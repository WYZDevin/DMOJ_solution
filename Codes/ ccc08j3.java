import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
		char [] l1= {'A','B','C','D','E','F'};
		char [] l2= {'G','H','I','J','K','L'};
		char [] l3= {'M','N','O','P','Q','R'};
		char [] l4= {'S','T','U','V','W','X'};
		char [] l5= {'Y','Z',' ','-','.',']'};
		char [] [] key = {l1,l2,l3,l4,l5};
		String s =sc.nextLine();
		int step=0;
		int ox=0;
		int oy=0;
		int nx=0;
		int ny=0;
		for(int i =0;i<s.length();i++){
			
			for(int i1 =0;i1<key.length;i1++){
				for(int i2=0;i2<l2.length;i2++){
					if(key[i1][i2] == s.charAt(i)){
						nx=i2;
						ny=i1;
						step=step+Math.abs(nx-ox)+Math.abs(ny-oy);
						ox=i2;
						oy=i1;
					}
				}
			}
		}
		step=step+(4-ny)+(5-nx);
		System.out.println(step);
    }
}