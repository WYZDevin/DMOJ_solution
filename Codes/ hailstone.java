import java.util.Scanner;

public class Hailstone {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		long a = sc.nextLong();
		int count=0;
		while(a!=1){
			if(a%2==0){
				a/=2;
			}else{
				a*=3;
				a+=1;
			}
			count++;
		}
		System.out.println(count);
	}

}