import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class dmopc14c3p6 {
	static BufferedReader br;
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		br=new BufferedReader(new InputStreamReader(System.in));
		int g = readInt();
		int C = readInt();
		int [] [] gw = new int [g+1][4];
		int [] [] gv = new int [g+1][4];
		for(int i=1;i<=g;i++){
			for(int k=1;k<=3;k++){
				gw[i][k]=readInt();
				gv[i][k]=readInt();
			}
		}
		int [] dp = new int [C+1];
		for(int w=1;w<=g;w++){
			for(int v=C;v>=0;v--){
				for(int i=1;i<=3;i++){
					if(v-gw[w][i]>=0)
					dp[v]=Math.max(dp[v], dp[v-gw[w][i]]+gv[w][i]);

				}
			}
		}
		System.out.println(dp[C]);
		
	}
	static String next () throws IOException {
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