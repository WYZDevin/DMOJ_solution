import java.util.*;
import java.io.*;
public class _2015_P4 {
    static long m = 1000000013;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        long n = Long.parseLong(br.readLine());
        long mod = (n+2)%8;
        if(n==1 || n==2 || n==3) pr.println(1);
        else if(
            n==4) pr.println(2);
        else if(n==5) pr.println(6);
        else {
            long a;
            if(mod == 0 || mod == 4) a = pow(2, n-2);
            else if(mod == 1 || mod == 3 || mod == 2) a = (pow(2, n/2-1) + pow(2, n-2))%m;
            else  a = (m-pow(2, n/2-1) + pow(2, n-2))%m;
            pr.println(a);
        }
        pr.close();
    }

    public static long pow(long b, long e) {
        if(e == 0) return 1;
        long t = pow(b, e/2)%m;
        if(e%2 == 1) return (t*t*(b%m))%m;
        else return (t*t)%m;
    }

}