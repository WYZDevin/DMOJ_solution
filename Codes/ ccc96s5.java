import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class ccc96s5 {
		public static void main(String []args) throws IOException{ 
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st;
			int N =Integer.parseInt(br.readLine());
			for (int i = 0; i < N; i++) {
				int length=Integer.parseInt(br.readLine());
				LinkedList <Integer> x = new LinkedList();
				LinkedList <Integer> y = new LinkedList();
				st=new StringTokenizer(br.readLine());
				for (int j = 0; j < length; j++) {
					x.add(Integer.parseInt(st.nextToken()));
				}
				st=new StringTokenizer(br.readLine());
				for (int j = 0; j < length; j++) {
					y.add(Integer.parseInt(st.nextToken()));
				}
				int xi=0,yi=0,dif=0;
				for (int j = 0; j < x.size(); j++) {
					int k=x.get(j);
					int yk=y.lastIndexOf(k);
					if(yk-j>dif) dif=yk-j;
				}
				System.out.println("The maximum distance is "+dif);
			}	
	}
}