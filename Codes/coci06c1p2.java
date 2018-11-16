import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		double na=Math.PI*Math.pow(a, 2);
		double nar=0;
		for(int i = 1;i<a;i++){
			nar=nar+i;
		}
		nar=nar*2+a;
		double sa=nar*2;
		System.out.println(na);
		System.out.println(sa);
    }
}