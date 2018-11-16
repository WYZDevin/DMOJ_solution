import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bts17p1 {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String [] a = br.readLine().split(" ");
		System.out.print(a[0]);
		for(int i=1;i<a.length;i++){
			if(Character.isUpperCase(a[i].charAt(0))){
				System.out.print(".");
			}
			System.out.print(" "+a[i]);
		}
		System.out.print(".");
	}
}