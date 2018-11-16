import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
Scanner sc = new Scanner (System.in);
		double a = sc.nextDouble();
		double b = sc.nextDouble();
		double BMI=a/Math.pow(b, 2);
		if(BMI>25){
			System.out.println("Overweight");
		}else if(BMI>=18.5){
			System.out.println("Normal weight");
		}else{
			System.out.println("Underweight");
		}
    }
}