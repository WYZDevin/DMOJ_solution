import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class ccc17s3 {
	static BufferedReader br;
	static StringTokenizer st;
	public static void main(String[] args) throws Exception{
		br=new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		long [] count = new long [2005];
		long [] pair = new long [4005];
		int g=  sc.nextInt();
		for(long i=0;i<g;i++)
			count[sc.nextInt()]++;
		for(int i=0;i<=2000;i++){
			for(int j=i;j<=2000;j++){
				long a = count[i];
				long b = count[j];
				long f = Math.min(a, b);
				if(j!=i)
				pair[i+j]+=f;
				else
				pair[i+j]+=f/2;
			}
		}
		long max = 0;
		long c=0;
		for(int i=0;i<=4000;i++){
			if(pair[i]>max){
				max=pair[i];
				c=1;
			}else if(pair[i]==max){
				c++;
			}
		}
		System.out.println(max+" "+c);
//		System.out.prlongln(Arrays.toString(pair));

	}
	static String next () throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		while (st == null || !st.hasMoreTokens())
			st = new StringTokenizer(br.readLine().trim());
		return st.nextToken();
	}

	static long readLong () throws IOException {
		return Long.parseLong(next());
	}

	static int readInt () throws IOException {
		return Integer.parseInt(next());
	}

	static double readDouble () throws IOException {
		return Double.parseDouble(next());
	}

	static char readChar () throws IOException {
		return next().charAt(0);
	}

	static String readLine () throws IOException {
		return br.readLine().trim();
	}
}