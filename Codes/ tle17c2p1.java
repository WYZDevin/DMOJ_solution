import java.io.*;
import java.util.*;

public class test {
  public static void main(String [] args){
  Scanner sc= new Scanner(System.in);
    String a = sc.nextLine();
    String [] c=  a.split(" ");
    String q = c[0].substring(2,c[0].length()-1);
      int l = q.length();
      for(int i=0;i<q.length();i++){
          if(q.charAt(i)=='a') System.out.print("(car ");
          else if(q.charAt(i)=='d') System.out.print("(cdr ");
      }
      System.out.print("x");
      for(int i=0;i<l;i++)
          System.out.print(")");
  }
}