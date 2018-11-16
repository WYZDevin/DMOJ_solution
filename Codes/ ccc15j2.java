import java.util.Scanner;

public class ccc15j2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String c= sc.nextLine();
		int happy=0;
		int sad=0;
		for(int i = 0;i<c.length()-1;i++){
			if(c.charAt(i)==':' &&c.charAt(i+1)=='-' &&c.charAt(i+2)==')')happy++;
			if(c.charAt(i)==':' &&c.charAt(i+1)=='-' &&c.charAt(i+2)=='(')sad++;
		}
		if(happy==0 && sad==0)System.out.println("none");
		else if(happy==sad)System.out.println("unsure");
		else if(happy>sad)System.out.println("happy");
		else System.out.println("sad");
	}
}