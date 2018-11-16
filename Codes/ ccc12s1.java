import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int count = 0;
		if(a<4){
			System.out.println("0");
		}else{
			for(int i =1;i<a-2;i++){
				for(int j = i+1;j<a-1;j++){
					for(int g = j+1;g<a;g++){
							count++;
					}
				}
			}
			
			System.out.println(count);
		}
    }
}