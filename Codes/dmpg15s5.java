import java.io.*;
import java.util.*;

public class balckWhite {
	public static void main(String []args) throws IOException{ 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String [] c;
		c=br.readLine().split(" ");
		int N = Integer.parseInt(c[0]);
		int M = Integer.parseInt(c[1]);
		char [] [] grid = new char[N+2][N+2];
		for (int i = 0; i < M; i++) {
			c=br.readLine().split(" ");
			int x1= Integer.parseInt(c[0])+1;
			int y1= Integer.parseInt(c[1])+1;
			int x2= Integer.parseInt(c[2])+x1;
			int y2= Integer.parseInt(c[3])+y1;
			grid[x1][y1]++;
			grid[x2][y2]++;
			grid[x1][y2]--;
			grid[x2][y1]--;
		}
		int count = 0;
		for (int i = 1; i <=N; i++) {
			for (int j = 1; j <=N; j++) {
				grid[i][j]+=grid[i-1][j];
				grid[i][j]+=grid[i][j-1];
				grid[i][j]-=grid[i-1][j-1];
				if(grid[i][j]%2!=0)count++;
			}
		}
		System.out.println(count);
	}
}