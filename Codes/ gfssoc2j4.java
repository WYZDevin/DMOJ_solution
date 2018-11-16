import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class maraton {
	static BufferedReader br;
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		br=new BufferedReader(new InputStreamReader(System.in));
		int a =readInt(),b=readInt();
		int [] list = new int[a+1];
		int [] p = new int[a+1];
		for(int i=1;i<=a;i++){
			list[i]=readInt();
			p[i]=p[i-1]+list[i];
		}
		for(int i=0;i<b;i++){
			int r1 =readInt();
			int r2 =readInt();
			System.out.println(p[a]-p[r2]+p[r1-1]);
		}
		
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
	static void print(String a){
		System.out.println(a);
	}
}