import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ccc17s2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int a = Integer.parseInt(br.readLine());
		String [] c =br.readLine().split(" ");
		int [] b= new int[c.length];
		for (int i = 0; i < b.length; i++) {
			b[i]=Integer.parseInt(c[i]);
		}
		Arrays.sort(b);
		byte s =0;
		int k=0;
		if(a%2==0){
		a=b.length/2-1;
		k=b.length/2;
		}else{
			a=b.length/2;
			k=b.length/2+1;
			s=1;
		}
		
		for(int i = k;i<b.length;i++){
			System.out.print(b[a]+" ");
			System.out.print(b[i]+" ");
			a--;
		}
		if(s==1){
			System.out.print(b[a]);
		}
	}
}