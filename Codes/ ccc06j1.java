import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
		int c =0;
		int [] a = {sc.nextInt(),sc.nextInt(),sc.nextInt(),sc.nextInt()};
		if(a[0]==1){
			c=c+461;
		}else if(a[0]==2){
			c=c+431;
		}else if(a[0]==3){
			c=c+420;
		}
		if(a[2]==1){
			c=c+130;
		}else if(a[2]==2){
			c=c+160;
		}else if(a[2]==3){
			c=c+118;
		}
		if(a[1]==1){
			c=c+100;
		}else if(a[1]==2){
			c=c+57;
		}else if(a[1]==3){
			c=c+70;
		}
		if(a[3]==1){
			c=c+167;
		}else if(a[3]==2){
			c=c+266;
		}else if(a[3]==3){
			c=c+75;
		}
		System.out.println("Your total Calorie count is "+c+".");
		
    }
}