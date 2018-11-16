import java.util.Scanner;

public class bfs17p1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int count=0;
		int a =sc.nextInt();
		for(int i=0;i<a;i++){
			String d=  sc.next();
			if(d.length()<=10)count++;
		}
		System.out.println(count);
	}
}