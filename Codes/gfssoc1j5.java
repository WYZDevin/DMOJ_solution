import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class gfssoc1j5 {	
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
		Scanner sc= new Scanner(System.in);
		int rooms=sc.nextInt();
		int ways=sc.nextInt();
		int t=sc.nextInt();
		int max=1002;
		boolean [] []grid =new boolean[max][max];
		int [] [] mins = new int [max][max];
		int inf=1000000000;
		for(int i=0;i<max;i++)
			Arrays.fill(mins[i], inf);
		for(int i=0;i<ways;i++){
			int r1=sc.nextInt();
			int r2=sc.nextInt();
			grid[r1][r2]=true;
		}
		int [] [] ans = new int [max][max];
		for(int i=1;i<=1000;i++){
			boolean [] v = new boolean[max];
			LinkedList <pair>q = new LinkedList();
			q.add(new pair(i,0));
			v[i]=true;
			while(!q.isEmpty()){
				int cp = q.peek().f;
				int cd = q.peek().s;
				v[cp]=true;
				q.poll();
				for(int j=1;j<=1000;j++)
					if(!v[j] && grid[cp][j])
						q.add(new pair(j,cd+1));
				mins[i][cp]=Math.min(mins[i][cp], cd);
			}
		}
		int qe=sc.nextInt();
		for(int i=0;i<qe;i++){
			int r1=sc.nextInt(),r2=sc.nextInt();
			if(mins[r1][r2]==inf)System.out.println("Not enough hallways!");
			else System.out.println(mins[r1][r2]*t);
			
		}
		

	}
}