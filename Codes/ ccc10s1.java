import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;

public class ccc10s1 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int a = Integer.parseInt(br.readLine());
		String [] name = new String [a];
		int [] per = new int [a];
		String [] c;
		int max=0,smax=0;
		String tn="",tn2="";
		if(a>1){
			for (int i = 0; i < a; i++) {
				c=br.readLine().split(" ");
				int perf=2*Integer.parseInt(c[1])+3*Integer.parseInt(c[2])+Integer.parseInt(c[3]);
				if(perf>max){
					smax=max;
					max=perf;
					tn2=tn;
					tn=c[0];
				}else if(perf>smax){
					tn2=c[0];
					smax=perf;
				}
				if(perf==max){
					if(c[0].compareTo(tn)<0){
						tn2=tn;
						smax=max;
						tn=c[0];
					}
				}
				else if(perf==smax){
					if(c[0].compareTo(tn2)<0){
						tn2=c[0];
					}
				}
			}
			System.out.println(tn);
			System.out.println(tn2);
		}else if(a==1){
			c=br.readLine().split(" ");
			System.out.println(c[0]);
		}


	}
}