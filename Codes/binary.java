import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		for(int i = 0;i<a;i++){
			Stack<Character> d =new Stack<Character>();	
			int c = sc.nextInt();
			int count=0;
			String b = Integer.toBinaryString(c);
			for(int j=b.length()-1;j>-1;j--){
				d.push(b.charAt(j));
			}
			if(b.length()%4!=0){
				int g = 4-b.length()%4;
				for(int j=0;j<g;j++){
					d.push('0');
				}
			}
			for(int j = d.size()-1;j>=0;j--){
				System.out.print(d.get(j));
				count++;
				if(count==4){
					count=0;
					System.out.print(" ");
				}
			}
			System.out.println();
		}
    }
}