import java.util.Arrays;
import java.util.Scanner;

public class fhc15c1p1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int max = 10000002;
		int [] n = new int [max];
		for(int i=2;i<max;i++){
			if(n[i]==0)
				for(int j=i;j<max;j+=i)
					n[j]++;
		}
		int N = sc.nextInt();
		for(int ll=1;ll<=N;ll++){
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			int count=0;
			for(int i=a;i<=b;i++){
				if(n[i]==c)
					count++;
			}
			System.out.println("Case #"+ll+":"+count);
		}
	}
}