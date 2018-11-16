import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Integer a =Integer.parseInt(br.readLine());
		Integer b =Integer.parseInt(br.readLine());
		String [] d=br.readLine().split(" ");
		String [] p=br.readLine().split(" ");
		Integer [] dd = new Integer [d.length];
		Integer [] pp = new Integer [d.length];
		
		for(int i = 0;i<d.length;i++){
			dd[i]=Integer.parseInt(d[i]);
			pp[i]=Integer.parseInt(p[i]);
		}
		Arrays.sort(pp);
		Arrays.sort(dd);
		int speed=0;
		if(a==1){
			for(int i = dd.length-1;i>=0;i--){
				if(dd[i]>pp[i]){
					speed+=dd[i];
				}else{
					speed+=pp[i];
				}
			}
		}else{
			int s=dd.length-1;
			for(int i = 0;i<pp.length;i++){
				if(pp[i]>dd[s]){
					speed+=pp[i];
				}else{
					speed+=dd[s];
				}
				s--;
			}
		}
		System.out.println(speed);
		
	}
}