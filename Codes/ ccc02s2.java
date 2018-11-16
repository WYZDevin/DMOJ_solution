import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
				Scanner sc = new Scanner(System.in);
		int t=sc.nextInt();
		int b = sc.nextInt();
		int min;
		if(t==0){
			System.out.println(0);
		}else{
			if(Math.abs(t)>Math.abs(b)){
				min=t;
			}else{
				min=b;
			}
			for(int i=1;i<=min;i++){
				if(t%i==0 && b%i==0){
					t=t/i;
					b=b/i;
					min=min/i;
				}
			}
			if(t%b==0){
				System.out.println(t/b);
			}else if(t<b){
				System.out.println(t+"/"+b);
			}else{
				System.out.println((int)t/b+" "+(t-b*((int)t/b))+"/"+b);
			}
		}
    }
}