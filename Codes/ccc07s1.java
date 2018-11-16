import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ccc07s1 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int a= Integer.parseInt(br.readLine());
		String [] c;
		for (int i = 0; i < a; i++) {
			c=br.readLine().split(" ");
			int y = Integer.parseInt(c[0]);
			int m = Integer.parseInt(c[1]);
			int d = Integer.parseInt(c[2]);
			if(2007-y<18){
				System.out.println("No");
			}else if(2007-y==18){
				if(2-m<0){
					System.out.println("No");
				}else if(2-m==0){
					if(27-d<0){
						System.out.println("No");
					}else{
						System.out.println("Yes");
					}
				}else{
					System.out.println("Yes");
				}
			}else{
				System.out.println("Yes");
			}
		}
	}
}