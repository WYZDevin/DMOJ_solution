import java.util.Scanner;

public class dmopc15c2p1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a =sc.nextInt();
		int b =sc.nextInt();
		int c=0;
		while(a>0){
			if(a<b){
				c+=a;
				break;
			}
			int e = a%b;
			int d=a/b;
			c+=(b*d);
			a=d;
			a+=e;
		}
		System.out.println(c);
	}
}