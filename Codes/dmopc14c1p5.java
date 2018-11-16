import java.io.*;
import java.util.*;

public class dmopc14c1p5 {
	static class pair{
		int f,s;
		pair(int f,int s){
			this.f=f;
			this.s=s;
		}
	}
	static int big=Integer.MAX_VALUE-1000;
	static int dx[] = {0, 0, 1, -1}, dy[] = {1, -1, 0, 0};
	static BufferedReader br;
	static PrintWriter out;
	static StringTokenizer st;
	static boolean [] [] grid=new boolean[1002][1002];
	static boolean [] [] tl=new boolean [1002][1002];
	static int R,C,t,tr,tc,cr,cc;
	static int [][]dist=new int [1002][1002];
	static Vector <pair> tel = new Vector();
	static LinkedList<pair> q = new LinkedList();
	public static void main (String[] args) throws IOException {
		br=new BufferedReader(new InputStreamReader(System.in));
		R=readInt();
		C=readInt();
		cr=readInt();
		cc=readInt();
		tr=readInt();
		tc=readInt();
		for(int i=0;i<R;i++){
			String rd = br.readLine();
			for(int j=0;j<C;j++){
				grid[i][j]=(rd.charAt(j)=='X');
			}
		}
		t=readInt();
		for(int i=0;i<t;i++){
			 int nr = readInt();
			 int nc = readInt();
			 tel.add(new pair(nr,nc));
			 tl[nr][nc]=true;
		}
		for(int i=0;i<1002;i++)
			for(int j=0;j<1002;j++)
				dist[i][j]=big;
		q.add(new pair(cr,cc));
		dist[cr][cc]=0;
		while(!q.isEmpty()){
			int r =q.getFirst().f;
			int c =q.getFirst().s;
			q.removeFirst();
			if(tl[r][c])continue;
			if(r==tr && c==tc)break;
			for(int i=0;i<4;i++){
				int nr=r+dx[i],nc=c+dy[i];
				if(nr<0 || nr>=R || nc<0 || nc>=C)continue;
				if(grid[r][c])continue;
				if(dist[r][c]+1>dist[nr][nc])continue;
				dist[nr][nc]=Math.min(dist[nr][nc], dist[r][c]+1);
				q.add(new pair(nr,nc));
			}
		}
		int mindist=Integer.MAX_VALUE;
		for(int i=0;i<tel.size();i++){
			mindist=Integer.min(mindist, dist[tel.get(i).f][tel.get(i).s]);
		}
		if(dist[tr][tc]==big){
			System.out.println(2);
			return;
		}
		if(dist[tr][tc]-mindist<0)System.out.println(dist[tr][tc]);
		else
			System.out.println(dist[tr][tc]-mindist);
		
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