import java.util.Scanner;

public class ccc11s2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		char [] s = new char[a];
		char c ;
		for(int i=0;i<a;i++){
			s[i]=sc.next().charAt(0);
		}
		int count=0;
		for(int i=0;i<a;i++){
			c=sc.next().charAt(0);
			if(c==s[i]){
			count++;	
			}
		}
		System.out.println(count);
	}

}