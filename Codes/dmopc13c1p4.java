import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class dmopc13c1p4 {
	static BufferedReader br;
	static StringTokenizer st;
	static int [] di = {0,1,0,-1};
	static int [] dj = {1,0,-1,0};
	public static void main(String[] args) throws IOException {
		br=new BufferedReader(new InputStreamReader(System.in));
		Scanner sc= new Scanner(System.in);
		int tc =Integer.parseInt(br.readLine());
		for(int lll=0;lll<tc;lll++)
		{
			String [] dd = br.readLine().split(" ");
			int W =Integer.parseInt(dd[1]);
			int L = Integer.parseInt(dd[0]);
			int cx=0,cy=0;
			int ex=0,ey=0;
			char [] [] grid = new char [W+2][L+2];
			for(int i=1;i<=W;i++){
				char [] c = br.readLine().toCharArray();
				for(int j=0;j<c.length;j++){
					grid[i][j+1]=c[j];
					if(c[j]=='C'){
						cx=j+1;
						cy=i;
					}
					if(c[j]=='W'){
						ex=j+1;
						ey=i;
					}
				}
			}
			LinkedList<Integer> x = new LinkedList();
			LinkedList<Integer> y = new LinkedList();
			LinkedList<Integer> d = new LinkedList();
			x.add(cx);
			y.add(cy);
			d.add(0);
			grid[cy][cx]='x';
			boolean flag=false;
			while(!x.isEmpty()){
				int curx=x.removeFirst();
				int cury=y.removeFirst();
				int curd=d.removeFirst();
				if(curd>=60){
					flag=true;
					System.out.println("#notworth");
					break;
				}
				if(curx==ex && cury==ey){
					System.out.println(curd);
					flag=true;
					break;
				}
				for(int i=0;i<4;i++){
					int nx = curx+di[i];
					int ny = cury+dj[i];
					int nd = curd+1;
					if(grid[ny][nx]=='O' || grid[ny][nx]=='W'){
						x.add(nx);
						y.add(ny);
						d.add(nd);
					}
					grid[ny][nx]='X';
				}
				if(flag)break;
			}
			if(!flag)System.out.println("#notworth");
		}
	}
	
}