import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
		int j = sc.nextInt();
		if(j==1){
			System.out.println("2");
		}else{	do{
			int g=0;
			for(int i = 2;i<j/20;i++){
				if(j%i==0){
					g=1;
					j++;
					break;
				}
			}
				if (g==0){
					System.out.println(j);
					break;
				}
			}while(j>0);
	}
    }
}