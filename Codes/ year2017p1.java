import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.StringTokenizer;

public class year2017p1 {
	static BufferedReader br;
	static StringTokenizer st;
	static class pair{
		int f,s;
		pair(int f,int s){
			this.f=f;
			this.s=s;
		}
	}
	public static void main(String[] args) throws IOException {
		br=new BufferedReader(new InputStreamReader(System.in));
		int a= readInt();
		LinkedList<pair> q = new LinkedList();
		Map<Integer,Integer> m = new HashMap();
		for(int i=0;i<a;i++){
			char o=readChar();
			int k = readInt();
			if(o=='F'){
				m.put(k, i);
				q.addFirst(new pair(k,i));
			}else if(o=='E'){
				m.put(k, i);
				q.addLast(new pair(k,i));
			}
			else{
				m.put(k, -1);
			}
		}
		while(!q.isEmpty()){
			pair np=q.removeFirst();
			if(m.get(np.f)==np.s)
				System.out.println(np.f);
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