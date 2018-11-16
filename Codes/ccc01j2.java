import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
		int a  = sc.nextInt();
		int b  = sc.nextInt();
		int count=1;
		int checker=0;
		int cc=a;
		for(int i =cc;i<=a*b;i+=a){
			double fn=count*a;
			if(fn%b==1){
				cc=(int)fn/a;
				checker++;
				break;
			}else{
				count++;
			}
		}
		if(checker ==1 ){
			System.out.println(cc);
		}else{
			System.out.println("No such integer exists.");
		}
    }
}