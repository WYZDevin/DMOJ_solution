import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class dmopc15c6p3 {
	static BufferedReader br;
	static PrintWriter out;
	static StringTokenizer st;
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		int N= sc.nextInt();
		int M= sc.nextInt();
		long K= sc.nextLong();
		long [] list = new long[N+2];
		for(int i=0;i<M;i++){
			int a = sc.nextInt();
			int b = sc.nextInt();
			list[a]--;
			list[b+1]++;
		}
		list[0]=M;
		for(int i=1;i<=N;i++)
			list[i]+=list[i-1];
		long sum=0;
		long ans =N+1;
		for(int r=1,l=0 ;r<=N;r++){
			sum+=list[r];
			while(l<=r && sum>=K){
				ans=Math.min(ans, r-l);
				l++;
				sum-=list[l];
			}
		}
		if(ans>N)
			System.out.println(-1);
		else
			System.out.println(ans);
	}
	
}