import java.util.Arrays;
import java.util.Scanner;

public class vmss7wc16c1p2 {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int a = sc.nextInt();
		if(a==0);
		boolean ch = false;
		int count=0;
		boolean z=false;
		int [] list = new int [a];
		for (int i = 0; i <a; i++) {
			list[i]=sc.nextInt();
		}
		for (int i = 0; i < list.length; i++) {
			int x = list[i];
			int c = 0;
			if(x==0)z=true;
			for (int j = 0; j < list.length; j++) {
				if(list[j]==x)c++;
			}
			if(c==x){
				ch=true;
				if(count<=c)count=c;
			}
		}
		if(!ch&&z)System.out.println("Paradox!");
		else System.out.println(count);
	}
}