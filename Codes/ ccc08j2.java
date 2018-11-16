import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
Scanner sc = new Scanner (System.in);
		// TODO Auto-generated method stub
		int b;
		String [] a = {"A","B","C","D","E"};
		do{
		b=sc.nextInt();
		int n=sc.nextInt();
		for(int i = 0;i<n;i++){
			if(b==1){
				String c =a[0];
				for(int j = 0;j<4;j++){
					a[j]=a[j+1];
				}
				a[4]=c;
					
			}else if(b==2){
				String c =a[4];
				for(int j = 4;j>0;j--){
					a[j]=a[j-1];
				}
				a[0]=c;
			}else if(b==3){
				String s =a[0];
				a[0]=a[1];
				a[1]=s;
			}else if(b==4){
				for(int j=0;j<a.length;j++){
					System.out.print(a[j]+" ");
				}
			}
		}
		}while(b!=4);
    }
}