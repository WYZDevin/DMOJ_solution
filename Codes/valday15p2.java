import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class dp_bag_01 {
	static int N;
	static int C;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		C=Integer.parseInt(st.nextToken());
		int [] dp = new int [C+1];
		int [] t= new int [N+1];
		int [] pr= new int [N+1];
		for (int i = 1; i < N+1; i++) {
			st= new StringTokenizer(br.readLine());
			pr[i]=Integer.parseInt(st.nextToken());
			t[i]=Integer.parseInt(st.nextToken());
		}
		for (int i = 1; i <=N; i++) {
			for (int j = C; j >=t[i]; j--) {
				dp[j]=Math.max(dp[j], dp[j-t[i]]+pr[i]);
			}
		}
		System.out.println(dp[C]);
		
		
	}
}