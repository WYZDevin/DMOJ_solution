import java.io.*;
import java.util.*;

public class cco14p1 {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int a=  Integer.parseInt(br.readLine());
		int[] [] grid = new int [a+2][a+2];
		for(int i = 1;i<=a;i++){
			String []d=br.readLine().split("");
			int count=0;
			for(int j=1;j<=a;j++){
				String c= d[count++];
				if(c.equals("#"))grid[i][j]=1;
			}
		}
		int xx=0;
		for(int i = a;i>=0;i--){
			for(int j = 1;j<=a;j++){
				if(grid[i][j]>0){
				grid[i][j]=1+Math.min(grid[i+1][j], Math.min(grid[i+1][j-1], grid[i+1][j+1]));
				xx+=grid[i][j];
				}
			}
		}
		System.out.println(xx);
	}
}