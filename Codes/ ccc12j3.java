import java.util.Scanner;

public class ccc12j3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		for(int j = 0;j<a;j++){
			for(int i =0;i<a;i++){
				System.out.print("*");
			}
			for(int i =0;i<a;i++){
				System.out.print("x");
			}
			for(int i =0;i<a;i++){
				System.out.print("*");
			}
			System.out.println();
		}
		for(int j = 0;j<a;j++){
			for(int i =0;i<a;i++){
				System.out.print(" ");
			}
			for(int i =0;i<a;i++){
				System.out.print("xx");
			}
			System.out.println();
		}
		for(int j = 0;j<a;j++){
			for(int i =0;i<a;i++){
				System.out.print("*");
			}
			for(int i =0;i<a;i++){
				System.out.print(" ");
			}
			for(int i =0;i<a;i++){
				System.out.print("*");
			}
			System.out.println();
		}
	}

}