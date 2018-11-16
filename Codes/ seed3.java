import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class battlepostion {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int sta = Integer.parseInt(br.readLine());
		int re = Integer.parseInt(br.readLine());
		int wave = Integer.parseInt(br.readLine());
		int [] tr = new int [sta+2];
		for (int i = 0; i < wave; i++) {
			String [] c=  br.readLine().split(" ");
			int a=Integer.parseInt(c[0]);
			int b=Integer.parseInt(c[1]);
			int k=Integer.parseInt(c[2]);
			tr[a]+=k;
			tr[b+1]-=k;
		}
		int [] ntr = new int [sta+2];
		int count=0;
		for (int i = 1; i <=sta; i++) {
			ntr[i]=ntr[i-1]+tr[i];
			if(ntr[i]<re)count++;
		}
		System.out.println(count);
	}
}