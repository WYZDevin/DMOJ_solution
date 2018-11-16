import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
		int a =sc.nextInt();
		String b = sc.next();
		String c = " ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		char [] d= c.toCharArray();
		char [] e = b.toCharArray();
		for(int i =1;i<e.length+1;i++){
			int ct = 0;
			for(int j =0;j<c.length();j++){
				if(e[i-1]==d[j]){
					ct=j;
					break;
				}
			}
			ct = ct-(3*i+a);
			while(ct<1){
				ct+=26;
			}
			e[i-1]=d[ct];
		}
		System.out.println(e);
    }
}