import java.io.*;
import java.util.*;

public class Main {
   public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int a = Integer.parseInt(br.readLine());
		String [] b = br.readLine().split(" ");
		int [] c = new int[b.length];
		for(int i = 0;i<b.length;i++){
			c[i]=Integer.parseInt(b[i]);
		}
		Arrays.sort(c);
		int g= c[c.length-1];
		int count=0;
		int [] cc = new int [g+1];
		for(int i = 0;i<c.length;i++){
			cc[c[i]]++;
		}
		Arrays.sort(cc);
		for(int i = 0;i<cc.length;i++){
			if(cc[i]!=0){
				count++;
			}
		}
		System.out.println(count);
		
	}

}