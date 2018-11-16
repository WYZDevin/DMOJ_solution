import java.util.Scanner;

public class bts17p2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int g = sc.nextInt();
		double t =1;
		for(int i=0;i<g;i++){
			double e = sc.nextDouble();
			double p = sc.nextDouble();
			t*=(p-e)/p;
		}
		System.out.println(t);
	}
}