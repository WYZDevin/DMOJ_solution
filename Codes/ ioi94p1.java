import java.util.Scanner;

public class ioi94p1 {
	static int [] [] grid;
	static int [] [] sum;
	static int length;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		length = sc.nextInt();
		grid = new int [length+1][length+1];
		sum = new int[length+1][length+1];
		for (int i = 1; i <=length; i++) {
			for (int j = 1; j <=i; j++) {
				grid[i][j]=sc.nextInt();
			}
		}
		for (int x = length-1; x>=1; x--) {
			for (int y = 1; y <=x; y++) {
			grid[x][y]+=Math.max(grid[x+1][y+1],grid[x+1][y]);	
			}
		}
		System.out.println(grid[1][1]);
	}
}