import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class test {
    static int N,M;
    static boolean [] v = new boolean [10003];
    static boolean [] [] map = new boolean [10003][10003];
    static boolean run(int cp,int lp){
        if(v[cp])return true;
        v[cp]=true;
        for(int i=0;i<10003;i++){
            if(map[cp][i]){
                if(i==lp)
                    return true;
                if(run(i,cp))
                    return true;

            }
//            System.out.println(cp+ " "+ n);
        }
        v[cp]=false;
        return false;
    }
    public  static  void  main (String [] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        StringTokenizer st;
        N = sc.nextInt();
        M = sc.nextInt();
        boolean [] v = new boolean [N+1];
        int fn=0;
        LinkedList<Integer> ca = new LinkedList<>();
        for(int i=0;i<M;i++) {
            int a = sc.nextInt(), b = sc.nextInt();
            ca.add(a);
            map[a][b] = true;
        }
        boolean c=true;
        for(int i:ca){
            c=run(i,i);
            if(c)break;
        }

        if(c) System.out.println("N");
        else System.out.println("Y");
    }
}