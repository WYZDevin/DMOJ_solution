import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class NM7WC16Q3 {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner sc=  new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int A = sc.nextInt();
		int B = sc.nextInt();
		N+=1;
		boolean matrix[][] = new boolean[N][N];
		boolean visited[] = new boolean[N];
		
		for (int i = 0; i < M; i++){
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			matrix[a][b] = true;
			matrix[b][a] = true;
		}
		
		LinkedList<Integer> q = new LinkedList<Integer>();
		q.add(A);
		while(!q.isEmpty()){
			int cur = q.poll();
			
//			if (visited[cur]) continue;
			visited[cur] = true;
			
			for (int i = 0; i < N; i++){
				if (matrix[cur][i] && !visited[i]){
					q.add(i);
				}
			}
		}
		
		if (visited[B]){
			System.out.println("GO SHAHIR!");
		} else {
			System.out.println("NO SHAHIR!");
		}
	}
}