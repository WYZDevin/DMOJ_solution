import java.util.Scanner;

public class dmopc15c1p4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int x = sc.nextInt();
		boolean [] prime = new boolean[N+3];
		int count=0;
		if(N<2){
			System.out.println(0);
		}
		else{
			for(int i=2;i<=N;i++){
				if(prime[i])continue;
				int l=i*i;
				while(l<=N && l>=0){
					prime[l]=true;
					l+=i;
				}
				for(int j=0;j<=N-i;j+=x){
					if(N-i-j>=1)count+=2;
					else count++;
				}
			}
			System.out.println(count);
		}
	}
}