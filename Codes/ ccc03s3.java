import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;

public class ccc03s3 {
	static int counter=0;
	static int checker(char [][] grid,int i,int j){
		grid[i][j]='I';
		 if(i>0&&grid[i-1][j]=='.'){
			 counter++;
			 checker(grid,i-1,j);
		 }
		 if(j>0&&grid[i][j-1]=='.'){
			 counter++;
			 checker(grid,i,j-1);
		 }
		 if(i<grid.length-1 &&grid[i+1][j]=='.'){
			 counter++;
			 checker(grid,i+1,j);
		 }
		 if(j<grid[0].length-1 &&grid[i][j+1]=='.'){
			 counter++;
			 checker(grid,i,j+1);
		 }
		 return counter;
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N =Integer.parseInt(br.readLine());
		int row=Integer.parseInt(br.readLine());
		int co=Integer.parseInt(br.readLine());
		ArrayList<Integer> list =new ArrayList<Integer>();
		char [] [] grid = new char[row][co];
		for (int i = 0; i < grid.length; i++) {
			grid[i]=br.readLine().toCharArray();
		}
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if(grid[i][j]=='.'){
					counter=1;
					list.add(checker(grid,i,j));
				}
			}
		}
		Integer [] go = new Integer [list.size()];
		list.toArray(go);
		Arrays.sort(go);
		int c=0;
		for (int i = go.length-1; i>=0; i--) {
			if(N>=go[i]){
				N-=go[i];
				c++;
			}else break;
		}
		if(c!=1){
		System.out.println(c+" rooms, "+N+" square metre(s) left over");
		}else{
			System.out.println(c+" room, "+N+" square metre(s) left over");
		}
	}
}