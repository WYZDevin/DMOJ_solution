import java.util.Arrays;
import java.util.Scanner;

public class test {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int [] q= new int [a];
		for(int i=0;i<q.length;i++)
			q[i]=sc.nextInt();
		Arrays.sort(q);
		for(int i:q)
			System.out.println(i);
	
		
	}
}