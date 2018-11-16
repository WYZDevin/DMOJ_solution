import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int a = Integer.parseInt(br.readLine());
		String [] b = br.readLine().split(" ");
		String [] e = br.readLine().split(" ");
		int [] c = new int[a];
		int [] d = new int[a];
		for(int i =0;i<a;i++){
			c[i]=Integer.parseInt(b[i]);
			d[i]=Integer.parseInt(e[i]);
		}
		int cc=0;
		int dd=0;
		int g=0;
		boolean check=false;
		for(int i =1;i<=a;i++){
			cc+=c[i-1];
			dd+=d[i-1];
			if(cc==dd){
				g=i;
			}
		}
		System.out.println(g);

    }
}