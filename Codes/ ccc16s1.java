import java.util.Arrays;
import java.util.Scanner;

public class ccc16s1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char [] a = sc.nextLine().toCharArray();
		char [] b = sc.nextLine().toCharArray();
		Arrays.sort(a);
		Arrays.sort(b);
		if(a.length!=b.length){
			System.out.println("N");
			return;
		}
		int startp =0;
		int ava=0;
		for(int i=0;i<b.length;i++){
			if(b[i]=='*')ava++;
			else{
				startp=i;
				break;
			}
		}
		boolean checker=true;
		for(int i=0;i<a.length;i++){
			if(startp==b.length)break;
			if(a[i]!=b[startp]){
				if(ava>0)ava--;
				else{
					checker=false;
					break;
				}
			}else{
				startp++;
			}
		}
		if(checker)System.out.println("A");
		else System.out.println("N");
	}
}