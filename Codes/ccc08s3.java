import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class ccc08s3 {
	static class pair{
		int r,c,d;
		pair(int r,int c,int d){
			this.r=r;
			this.c=c;
			this.d=d;
		}
	}
	static int [] xm = {1,-1,0,0};
	static int [] ym = {0,0,1,-1};
	public static void main (String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		int k = readInt();
		for(int ll = 0;ll<3;ll++){
			int row = readInt();
			int co = readInt();
			char [] []grid = new char[row] [co];
			boolean [] []vist = new boolean[row][co];
			for(int i=0;i<row;i++)grid[i]=readLine().toCharArray();
			LinkedList<pair> q = new LinkedList();
			q.add(new pair(0,0,1));
			int dd=Integer.MAX_VALUE;
			boolean flag=false;
			while(!q.isEmpty()){
				pair cur = q.removeFirst();
				int r=cur.r;
				int c=cur.c;
				int d=cur.d;
				if(r==row-1 && c==co-1){
					flag=true;
					if(dd>d)dd=d;
				}
				vist[r][c]=true;
				char op = grid[r][c];
				grid[r][c]='*';
				if(op=='+'){
					for(int i=0;i<4;i++){
						int nr = r+ym[i];
						int nc = c+xm[i];
//						System.out.println(nr+" "+nc+" "+r+" "+c);
						int nd = d+1;
						if(nr>=row || nr<0)continue;
						if(nc>=co || nc<0)continue;
						if(vist[nr][nc])continue;
						if(grid[nr][nc]=='*')continue;
						q.add(new pair(nr,nc,nd));
					}
				}else if(op=='-'){
					for(int i=0;i<2;i++){
						int nr = r+ym[i];
						int nc = c+xm[i];
//						System.out.println(nr+" "+nc+" "+r+" "+c);
						int nd = d+1;
						if(nr>=row || nr<0)continue;
						if(nc>=co || nc<0)continue;
						if(vist[nr][nc])continue;
						if(grid[nr][nc]=='*')continue;
						q.add(new pair(nr,nc,nd));
					}
				}else if(op=='|'){
					for(int i=2;i<4;i++){
						int nr = r+ym[i];
						int nc = c+xm[i];
//						System.out.println(nr+" "+nc+" "+r+" "+c);
						int nd = d+1;
						if(nr>=row || nr<0)continue;
						if(nc>=co || nc<0)continue;
						if(vist[nr][nc])continue;
						if(grid[nr][nc]=='*')continue;
						q.add(new pair(nr,nc,nd));
					}
				}
//				for(int i=0;i<row;i++)System.out.println(grid[i]);
			}
			if(flag)
			System.out.println(dd);
			else System.out.println(-1);
		}
	}
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));;
	static PrintWriter out;
	static StringTokenizer st;
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