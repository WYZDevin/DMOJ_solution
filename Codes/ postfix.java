import java.io.*;
import java.util.*;

public class Main {
    
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner (System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		Stack <String> b = new Stack<String>();
		Stack <String> c = new Stack<String>();
		for(int i = s.length-1;i>=0;i--){
			b.push(s[i]);
		}
		do{
			String n=b.pop();
			double t=0;
			if(n.equals("+")){
				t=Double.parseDouble(c.pop())+Double.parseDouble(c.pop());
				c.push(Double.toString(t));
			}else if(n.equals("-")){
				double x = Double.parseDouble(c.pop());
				double y = Double.parseDouble(c.pop());
				t=y-x;
				c.push(Double.toString(t));
			}else if(n.equals("*")){
				double x = Double.parseDouble(c.pop());
				double y = Double.parseDouble(c.pop());
				t=y*x;
				c.push(Double.toString(t));
			}else if(n.equals("/")){
				double x = Double.parseDouble(c.pop());
				double y = Double.parseDouble(c.pop());
				t=y/x;
				c.push(Double.toString(t));
			}else if(n.equals("%")){
				double x = Double.parseDouble(c.pop());
				double y = Double.parseDouble(c.pop());
				t=y%x;
				c.push(Double.toString(t));
			}else if(n.equals("^")){
				double x = Double.parseDouble(c.pop());
				double y = Double.parseDouble(c.pop());
				t=Math.pow(y, x);
				c.push(Double.toString(t));
			}else{
				c.push(n);
			}
		}while(!b.isEmpty());
		System.out.println(c.pop());
    }
}