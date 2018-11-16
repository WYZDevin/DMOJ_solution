import java.util.Arrays;
import java.util.Scanner;

public class rgss1 {
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		int [] list= new int[2];
		list[0]=sc.nextInt();
		list[1]=sc.nextInt();
		int tc=sc.nextInt();
		Arrays.sort(list);
		if(tc%list[0]==0)System.out.println(tc);
		else if(tc%list[1]==0)System.out.println(tc);
		else{
			int big=0;
			for(int i=0;i<=tc/list[0];i++){
				for(int x=0;x<=tc/list[1];x++){
					int l=i*list[0]+x*list[1];
					if(l==tc)big=tc;
					else if(l>big && l<tc)big=l;
				}
			}
			System.out.println(big);
		}
			
	}
}