import java.util.Scanner;

public class ccc06j2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int count = 0;
		for(int i = 1;i<a+1;i++){
			for(int j = 1;j<b+1;j++){
				if(j+i==10){
					count++;
				}
			}
		}
		if(count==1){
			System.out.println("There is "+count+" way to get the sum 10.");
			
		}else{
			System.out.println("There are "+count+" ways to get the sum 10.");
		}
		
	}

}