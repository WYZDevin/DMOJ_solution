import java.io.*;
import java.util.*;
import java.awt.*;
public class test {
    public static void main(String[] args){
        Scanner sc = new Scanner (System.in);
        int N = Integer.parseInt(sc.nextLine());
        for(int i=0;i<N;i++){
            char [] words = sc.nextLine().toCharArray();
            int t = 0;
            for(char j : words){
                if(Character.isAlphabetic(j)){
                  if(t%2==0){
                      System.out.print(Character.toLowerCase(j));
                  }else{
                      System.out.print(Character.toUpperCase(j));
                  }
                  t++;
                }else System.out.print(j);
            }
            System.out.println();
        }
    }
}