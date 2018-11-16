import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class dmopc15c3p2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int a = Integer.parseInt(br.readLine());
		String [] c=  br.readLine().split(" ");
		long [] list = new long [a];
		long count=0;
		for(int x=0;x<a;x++){
			list[x]=Long.parseLong(c[x]);
			count+=list[x];
		}
		long sc=0;
		if(count%a==0){
			long avg=count/a;
			for(int x=0;x<a;x++)
				if(list[x]>avg)
					sc+=(list[x]-avg);
			System.out.println(sc);
		}else System.out.println("Impossible");

	}
}