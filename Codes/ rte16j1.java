import java.io.*;
import java.util.*;

public class test{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char [] fuck = sc.nextLine().toCharArray();
        int ans = 0, connect = 0, number_of_L = 0;
        for(char i : fuck){
            if(i==' ')continue;
            if(i == 'L'){
                connect++;
                ans = Math.max(ans,connect);
                number_of_L ++;
            }else{
                connect=0;
            }
        }
        System.out.println(number_of_L+" "+ans);
    }
}