import java.util.ArrayList;
import java.util.Scanner;

public class ccc05j2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		int a=sc.nextInt();
		int b=sc.nextInt();
		int count=0;
		for(int i=a;i<=b;i++){

			ArrayList<Integer> q=  new ArrayList();
			for(int j=1;j<=i;j++){
				if(i%j==0)q.add(j);
			}
			if(q.size()==4)count++;
		}
		System.out.println("The number of RSA numbers between "+a+" and "+b+" is "+count);
	}
}