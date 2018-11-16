import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class ccc12s2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String [] c = br.readLine().split("");
		HashMap <String,Integer> aa = new HashMap <String,Integer> ();
		aa.put("I", 1);
		aa.put("V", 5);
		aa.put("X", 10);
		aa.put("L", 50);
		aa.put("C", 100);
		aa.put("D", 500);
		aa.put("M", 1000);
		int A=0;
		int R=1;
		int a=0,r=0,nr=0;
		int sum=0;
		int round=c.length;
		for(int i =0;i<round/2-1;i++){
			a=Integer.parseInt(c[A]);
			r=aa.get(c[R]);
			nr=aa.get(c[R+2]);
			if(nr>r){
			sum-=a*r;	
			}else{
				sum+=a*r;
			}
			A+=2;
			R+=2;
		}
		sum+=Integer.parseInt(c[c.length-2])*aa.get(c[c.length-1]);
		System.out.println(sum);
	}
	

}