import java.io.*;
import java.util.*;

public class Main {
   public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int count=0;
		do{
		String[] s = br.readLine().split(" ");
		if(s[0].equals("0")){
			break;
		}
		Stack<String> b =new Stack<String>();	
		Stack<String> d =new Stack<String>();	
		for(int i =0;i<s.length;i++){
			b.push(s[i]);
		}

		while(b.size()!=1 ||  !d.isEmpty() ){

			String n = b.pop();
			if(n.equals("+") || n.equals("-")){
				String x=d.pop();
				String y=d.pop();
				String t = x+" "+y+" "+n;
				b.push(t);
				while(!d.isEmpty()){
					b.push(d.pop());
				}
			}else{
				d.push(n);
			}

		}
		System.out.println(b.pop());
		}while(count==0);
    }
}