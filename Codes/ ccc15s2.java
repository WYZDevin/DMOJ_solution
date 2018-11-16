import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class ccc15s2 {
	static BufferedReader br;
	static int convert(char a){
		if(a=='L')return 3;
		if(a=='M')return 2;
		return 1;
	}
	public static void main (String[] args) throws IOException {
	    br = new BufferedReader(new InputStreamReader(System.in));
	   Scanner sc = new Scanner(System.in);
	    int N = Integer.parseInt(br.readLine());
	    int M = Integer.parseInt(br.readLine());
	    int [] size =  new int [N+1];
	    for(int i=1;i<=N;i++){
	    	size[i]=convert(br.readLine().charAt(0));
	    }
	    int count=0;
	    for(int i=0;i<M;i++){
	    	String [] d=  br.readLine().split(" ");
	    	int si=convert(d[0].charAt(0));
	    	int num=Integer.parseInt(d[1]);
	    	if(num>=1 && num<=N &&size[num]>=si){
	    		size[num]=0;
	    		count++;
	    	}
	    }
	    System.out.println(count);
	
	}
}