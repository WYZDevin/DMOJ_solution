import java.util.*;

public class Test_Animal {
    public static void main(String [] agrs){
        Scanner sc = new Scanner(System.in);//import scanner
        System.out.println("guess 0");
        System.out.flush();
        int a = sc.nextInt();
        System.out.println("guess "+a);
        System.out.flush();
        int b= sc.nextInt();
        if(b==0) System.out.println("answer "+a);
        else System.out.println("answer "+-a);
        System.out.flush();
    }
}