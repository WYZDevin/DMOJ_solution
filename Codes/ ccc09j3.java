import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
		Integer a =sc.nextInt();
		int [] td={0,-300,-200,-100,0,100,130};
		String [] tdp={"Ottawa","Victoria","Edmonton","Winnipeg","Toronto","Halifax","St. John's"};
		for(int i =0;i<td.length;i++){
			String s=a.toString();
			String [] s1=s.split("");
			int [] a1=new int [s1.length];
			for(int j = 0;j<s1.length;j++){
				a1[j]=Integer.parseInt(s1[j]);
			}
			int [] a2={0,0,0,0};
			int kk=a2.length-1;
			for(int j = a1.length-1;j>=0;j--){
				a2[kk]=a1[j];
				kk--;
			}
			while(a2[3]>9){
				a2[3]-=10;
				a2[2]++;
			}
			while(a2[2]>=6){
				a2[2]-=6;
				a2[1]++;
			}
			while(a2[1]>=4 && a2[0]>=2){
				a2[1]-=4;
				a2[0]-=2;
			}
			Integer g=1000*a2[0]+100*a2[1]+10*a2[2]+a2[3];
			g=g+td[i];
			if(g>=2400){
				g=g-2400;
			}else if(g<0){
				g=g+2400;
			}
			if(g==275){
				g=315;
			}
			System.out.println(g+" in "+tdp[i]);
		}
    }
}