import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class test {
    static long pow(int b, int n,int mod){
        if(n==0)return 1L;
        long t=pow(b,n/2,mod);
        if(n%2==1)return ((t*t)%mod*b)%mod;
        else return t*t%mod;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N=sc.nextInt(),M=sc.nextInt();
        int [] n = new int [N];
        for(int i=0;i<N;i++)
            n[i]=sc.nextInt();
        Arrays.sort(n);
       long sum=0;
       for(int i=N-1;i>=0;i--){
           sum+=pow(n[i],(N-1-i)/M,1000000007);
       }
        System.out.println(sum%1000000007);
    }
}