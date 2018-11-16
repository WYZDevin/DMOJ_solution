import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Queue;

import com.sun.prism.impl.QueuedPixelSource;

public class tsoc16c1p4 {
	static int counter=0;
	static boolean check = false;
	static void checker(char [][] grid,int i,int j){
		if(grid[i][j]=='M')check=true;
		grid[i][j]='#';
		if(i>0){
			if(grid[i-1][j]=='.')
				checker(grid,i-1,j);
			else if(grid[i-1][j]=='M'){
				check=true;
				checker(grid,i-1,j); 
			}
		}
		if(j>0){
			if(grid[i][j-1]=='.')
			checker(grid,i,j-1);
			else if(grid[i][j-1]=='M'){
				check=true;
				checker(grid,i,j-1);
			}
		}
		if(i<grid.length-1 ){
			if(grid[i+1][j]=='.')
			checker(grid,i+1,j);
			else if(grid[i+1][j]=='M'){
				check=true;
				checker(grid,i+1,j);
			}
		}
		if(j<grid[0].length-1){
			if(grid[i][j+1]=='.')
			checker(grid,i,j+1);
			else if(grid[i][j+1]=='M'){
				check=true;
				checker(grid,i,j+1);
			}
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String [] c= br.readLine().split(" ");
		int row=Integer.parseInt(c[0]);
		int co=Integer.parseInt(c[1]);
		char [] [] grid = new char[row][co];
		for (int i = 0; i < grid.length; i++) {
			grid[i]=br.readLine().toCharArray();
		}
		int count=0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if(grid[i][j]=='.' || grid[i][j]=='M'){
					check=false;
					checker(grid,i,j);
					if(check)count++;
				}
			}
		}
		System.out.println(count);
	}
}