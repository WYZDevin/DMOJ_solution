import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class mec16p3 {
	static BufferedReader br;
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		br=new BufferedReader(new InputStreamReader(System.in));
		int tc =readInt();
		int C = readInt();
		int [][] w=  new int [102][102];
		int [][] ex= new int[102][102];
		for(int i=0;i<tc;i++){
			int tt = readInt();
			for(int j=1;j<=tt;j++){
				int t =readInt();
				int e=readInt();
				w[i][j]=t+w[i][j-1];
				ex[i][j]=e+ex[i][j-1];
			}
		}
		int [] f = new int[C+1];
		for(int i=0;i<tc;i++){
			for(int v=C;v>=0;v--){
				for(int j=0;j<101;j++){
					if(v-w[i][j]>=0)
						f[v]=Math.max(f[v], f[v-w[i][j]]+ex[i][j]);
				}
			}
		}
		System.out.println(f[C]);
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