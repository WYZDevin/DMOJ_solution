import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        
		// TODO Auto-generated method stub
		Scanner sc = new Scanner (System.in);
		int a = sc.nextInt();
		for(int i = 1;i<=a;i+=2){
			int b = 2*a-2*i;
			int c = (b-1)/2;
			for(int j = 0;j<i;j++){
				System.out.print("*");
			}
			for(int j = 0;j<b;j++){
				System.out.print(" ");
			}
			for(int j = 0;j<i;j++){
				System.out.print("*");
			}
			System.out.println();
		}
		for(int i = a-2;i>=0;i-=2){
			int b = 2*a-2*i;
			for(int j = 0;j<i;j++){
				System.out.print("*");
			}
			for(int j = 0;j<b;j++){
				System.out.print(" ");
			}
			for(int j = 0;j<i;j++){
				System.out.print("*");
			}
			System.out.println();
		}
	

    }
}