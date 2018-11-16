import java.util.Scanner;

public class dmopc16c3p0 {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		double vin=sc.nextDouble();
		double rf=sc.nextDouble();
		double rg=sc.nextDouble();
		System.out.println(vin*(1+rf/rg));
	}
}