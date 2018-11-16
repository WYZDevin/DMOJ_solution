import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class ccc09j5 {
	static BufferedReader br;
	static StringTokenizer st;
	static boolean [] [] friend = new boolean [53][53];
	static void oi(int f1,int f2){
		friend[f1][f2]=true;
		friend[f2][f1]=true;
	}
	static void od(int f1,int f2){
		friend[f1][f2]=false;
		friend[f2][f1]=false;
	}
	static void on(int f1){
		int count=0;
		for(int i=1;i<52;i++){
			if(friend[f1][i]){
				count++;
			}
		}
		System.out.println(count);
	}
	static void of(int f1){
		boolean [] vist = new boolean[52];
		for(int i=0;i<52;i++){
			if(friend[f1][i])
				vist[i]=true;
		}
		LinkedList <Integer> ff = new LinkedList<Integer>();
		for(int i=1;i<52;i++){
			if(friend[f1][i]){
				for(int j=1;j<52;j++){
					if(i==f1 || j== f1)continue;
					if(friend[i][j]){
						if(!vist[j]){
							vist[j]=true;
							ff.add(j);
						}
					}
				}
			}
		}
		System.out.println(ff.size());
	}
	static void os(int f1,int f2){
		LinkedList<Integer> list = new LinkedList<Integer>();
		LinkedList<Integer> dis = new LinkedList<Integer>();
		boolean [] vist = new boolean [55];
		list.add(f1);
		dis.add(0);
		boolean check = false;
		while(!list.isEmpty()){
			int cur = list.removeFirst();
			int curd = dis.removeFirst();
			if(cur==f2){
				System.out.println(curd);
				check=true;
				break;
			}
			vist[cur]=true;
			for(int i=1;i<51;i++){
				if(friend[cur][i] && !vist[i]){
					list.add(i);
					dis.add(curd+1);
				}
			}
		}
		if(!check)System.out.println("Not connected");
	}
	public static void main(String[] args) throws IOException {
		br=new BufferedReader(new InputStreamReader(System.in));
		 friend[1][6] = friend[6][1] = true;
		    friend[2][6] = friend[6][2] = true;
		    friend[3][6] = friend[6][3] = true;
		    friend[4][6] = friend[6][4] = true;
		    friend[5][6] = friend[6][5] = true;
		    friend[7][6] = friend[6][7] = true;
		    friend[3][4] = friend[4][3] = true;
		    friend[3][5] = friend[5][3] = true;
		    friend[3][15] = friend[15][3] = true;
		    friend[4][5] = friend[5][4] = true;
		    friend[7][8] = friend[8][7] = true;
		    friend[8][9] = friend[9][8] = true;
		    friend[9][12] = friend[12][9] = true;
		    friend[9][10] = friend[10][9] = true;
		    friend[10][11] = friend[11][10] = true;
		    friend[11][12] = friend[12][11] = true;
		    friend[12][13] = friend[13][12] = true;
		    friend[13][14] = friend[14][13] = true;
		    friend[13][15] = friend[15][13] = true;
		    friend[16][18] = friend[18][16] = true;
		    friend[16][17] = friend[17][16] = true;
		    friend[17][18] = friend[18][17] = true;
		while(true){
			char operation = readChar();
			if(operation == 'i'){
				int f1 = readInt();
				int f2 = readInt();
				oi(f1,f2);
			}else if(operation == 'd'){
				int f1 = readInt();
				int f2 = readInt();
				od(f1,f2);
			}else if(operation == 'n'){
				int f1 = readInt();
				on(f1);
			}else if(operation == 'f'){
				int f1 = readInt();
				of(f1);
			}else if(operation == 's'){
				int f1 = readInt();
				int f2 = readInt();
				os(f1,f2);
			}else break;

		}
	}
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