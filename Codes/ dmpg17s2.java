import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class animeConvention {
	static BufferedReader br;
	static StringTokenizer st;
	static int [] list;
	static void union(int a, int b){
		int r1 = root(a);
		int r2 = root(b);
		list[r2]=r1;
	}
	static int  root(int a){
		int k = list[a];
		while(a!=k){
			a=k;
			k=list[a];
		}
		return k;
	}
	static boolean same(int a,int b){
		if(root(a)==root(b))return true;
		else return false;
	}
	public static void main(String[] args) throws IOException {
		br=new BufferedReader(new InputStreamReader(System.in));
		int P = readInt();
		int Q = readInt();
		list = new int [P+1];
		for(int i=1;i<=P;i++)list[i]=i;
		for(int i=0;i<Q;i++){
			char op = readChar();
			int a = readInt();
			int b = readInt();
			if(op=='A'){
				union(a,b);
			}else{
				boolean c= same(a,b);
				if(c)System.out.println("Y");else System.out.println("N");
			}
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
}