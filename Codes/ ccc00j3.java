import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
Scanner sc = new Scanner (System.in);
		int q =sc.nextInt();
		int r1=sc.nextInt();
		int r2=sc.nextInt();
		int r3=sc.nextInt();
		int count=0;
		for(int i =q;i>0;){
			
			r1++;
			q--;
			count++;
			if(r1==35){
				q=q+30;
				r1=0;
			}
			if (q==0){
				break;
			}
			r2++;
			q--;
			count++;
			if(r2==100){
				q=q+60;
				r2=0;
			}
			if (q==0){
				break;
			}
			r3++;
			q--;
			count++;
			if(r3==10){
				q=q+9;
				r3=0;
			}
			if (q==0){
				break;
			}
		
		}
		System.out.println("Martha plays "+count+" times before going broke.");
    }
}