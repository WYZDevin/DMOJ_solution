import java.util.Scanner;

public class ccc03s1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int p=1;
		int a;
		while(true){
			a=sc.nextInt();
				p+=a;
				if(a==0){
				System.out.println("You Quit!");
				break;
				}
				if(p==9){
					p=34;
				}else if(p==40){
					p=64;
				}else if(p==67){
					p=86;
				}else if(p==54){
					p=19;
				}else if(p==90){
					p=48;
				}else if(p==99){
					p=77;
				}else if(p>100){
					p-=a;
				}
				if(p==100){
					System.out.println("You are now on square "+p);
					System.out.println("You Win!");
					break;
				}
				System.out.println("You are now on square "+p);
			}
		}
	}