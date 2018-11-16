import java.util.LinkedList;
import java.util.Scanner;

public class test {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String a=sc.next();
        String b=sc.next();
        if(a.length()+b.length()!=10) System.out.println("invalid");
        else if(a.equals("647") || a.equals("437")) System.out.println("valueless");
        else if(a.equals("416")) System.out.println("valuable");
        else System.out.println("invalid");
    }

}