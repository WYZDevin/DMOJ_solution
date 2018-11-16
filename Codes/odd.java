import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class theoddnumber {
	public static void main(String []args) throws IOException{ 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int a=  Integer.parseInt(br.readLine());
		int c = Integer.parseInt(br.readLine());
		for(int i=1;i<a;i++){
			c^=Integer.parseInt(br.readLine());
		}
		System.out.println(c);
	}
}