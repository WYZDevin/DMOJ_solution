import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class groupedKnapsack_Algorithm {
	static BufferedReader br;
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		br=new BufferedReader(new InputStreamReader(System.in));
		int g = readInt();
		int p = readInt();
		int [] [] gv = new int [g+1][p+1];
		int [] [] gw = new int [g+1][p+1];
		int [] pi = new int[g+1];
		for(int i = 0;i<p;i++){
			int w = readInt();
			int v = readInt();
			int place = readInt();
			gv[place][pi[place]]=v;
			gw[place][pi[place]]=w;
			pi[place]++;
		}
		int V = readInt();
		int []fv = new int [V+1];
		for(int pack=1;pack<=g;pack++){
			for(int v=V;v>=0;v--){
				for(int i=0;i<=p;i++){
					if(v-gw[pack][i]>=0)
					fv[v]=Math.max(fv[v], fv[v-gw[pack][i]]+gv[pack][i]);
				}
			}
		}
		System.out.println(fv[V]);
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

	static char readCharacter () throws IOException {
		return next().charAt(0);
	}

	static String readLine () throws IOException {
		return br.readLine().trim();
	}
}