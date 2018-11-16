import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
		while(true){
			String a = sc.nextLine();
			if(a.toString().equals("quit!")){
				break;
			}
			if(a.length()<=4){
				System.out.println(a.toString());
			}else if(a.charAt(a.length()-3)=='a' ||a.charAt(a.length()-3)=='e' ||a.charAt(a.length()-3)=='i'||a.charAt(a.length()-3)=='o'||a.charAt(a.length()-3)=='u'||a.charAt(a.length()-3)=='y'){
				System.out.println(a);
			}else{
				String c = "our";
				System.out.println(a.substring(0, a.length()-2)+c);
			}
			
		}
    }
}