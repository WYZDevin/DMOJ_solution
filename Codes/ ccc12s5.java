import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ccc12s5 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String [] c=  br.readLine().split(" ");
		int n = Integer.parseInt(br.readLine());
		int R =Integer.parseInt(c[0]);
		int C = Integer.parseInt(c[1]);
		int [] [] grid = new int [R+1][C+1];
		for(int i = 0 ;i<n;i++){
			c=br.readLine().split(" ");
			int rr = Integer.parseInt(c[0]);
			int cc = Integer.parseInt(c[1]);
			grid[rr][cc]=-1;
		}
		grid[1][1]=1;
		for(int r = 1;r<grid.length;r++){
			for(int co = 1;co<grid[0].length;co++){
				if(grid[r][co]==-1)continue;
				int r1 =grid[r-1][co];
				int c1 =grid[r][co-1];
				if(r1==-1)r1=0;
				if(c1==-1)c1=0;
				grid[r][co]=Math.max(grid[r][co],r1+c1);
			}
		}
		System.out.println(grid[R][C]);
	}
}