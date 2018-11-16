import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ccc07s3 {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int [] g = new int[10001];
		for (int i = 1; i < g.length; i++) {
			g[i]=i;
		}
		int a = Integer.parseInt(br.readLine());
		String [] c;
		for (int i = 0; i < a; i++) {
			c=br.readLine().split(" ");
			g[Integer.parseInt(c[0])]=Integer.parseInt(c[1]);
		}
		String []d= {"",""};
		int i,x,y,count;
		while(true){
			d=br.readLine().split(" ");
			if(d[0].equals("0") && d[1].equals("0")) break;
			x= Integer.parseInt(d[0]);
			y=Integer.parseInt(d[1]);
			i=x;
			count=0;
			boolean ch = true;
			while(true){
				i=g[i];
				if(i==y){
					break;
				}else if(i==x){
					ch=false;
					break;
				}
				count++;
			}
			if(ch==true){
				System.out.println("Yes "+count);
			}else{
				System.out.println("No");
			}
		}
	}
}