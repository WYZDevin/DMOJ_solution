import java.util.Scanner;

public class coci08c6p1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String a = sc.nextLine();
		String b = sc.nextLine();
		String c = sc.nextLine();
		if(a.length()==c.length() && b.equals("+")){
			System.out.print(2);
			for (int i = 1; i < a.length(); i++) {
				System.out.print(a.charAt(i));
			}
		}
		else if(b.equals("*")){
			System.out.print(a);
			for(int i = 1;i<c.length();i++){
				System.out.print(c.charAt(i));
			}
		}else{
			if(a.length()>c.length()){
				for(int i =0;i<a.length()-c.length();i++){
					System.out.print(a.charAt(i));
				}
				System.out.print(c);
			}else{
				for(int i =0;i<c.length()-a.length();i++){
					System.out.print(c.charAt(i));
				}
				System.out.print(a);
			}
		}
				
	}
}