import java.util.Scanner;

public class DFSss {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a= sc.nextInt();
		
		for (int i = 0; i < a; i++) {
			int b = sc.nextInt();
			String c = Integer.toBinaryString(b);
			for (int j = 0; j < c.length(); j++) {
				if(c.charAt(j)=='1'){
					System.out.print("dank ");
				}else{
					System.out.print("meme ");
				}
			}
			System.out.println();
		}
		
	}
}