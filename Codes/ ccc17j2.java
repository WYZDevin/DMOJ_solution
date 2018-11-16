import java.util.Scanner;

public class test {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt(),b=sc.nextInt(),sum=0;
		for(int i=0;i<=b;i++){
			sum+=a;
			a*=10;
		}
		System.out.println(sum);
	}
}