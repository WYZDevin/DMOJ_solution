import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
		int [] a = {9,7,8,0,9,2,1,4,1,8,sc.nextInt(),sc.nextInt(),sc.nextInt()};
		int sum=0;
		for(int i = 0;i<a.length;i+=2){
			sum=sum+a[i];
		}
		for(int i = 1;i<a.length;i+=2){
			sum=sum+a[i]*3;
		}
		System.out.println("The 1-3-sum is "+sum);
    }
}