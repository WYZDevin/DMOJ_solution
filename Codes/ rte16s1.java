import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class RTE16S1 {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int a = Integer.parseInt(br.readLine());
		String [] b = new String[2];
		int c,d,e,ini=1,t=1;
		for(int i = 0;i<a;i++){
			ini=1;
			b =  br.readLine().split(" ");
			c = Integer.parseInt(b[0]);
			d = Integer.parseInt(b[1]);
			e=c-d;
			for(int j =2;j<c;j++){
				ini+=j;
				t+=ini;
				if(t>e){
					t-=ini;
					System.out.println(t);
					break;
				}
			}
			ini=1;
			t=1;
		}
	}
}