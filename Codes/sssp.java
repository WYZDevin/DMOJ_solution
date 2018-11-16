import java.io.*;
import java.util.*;

public class test {
    static class pair{
        int f,s;
        pair(int f,int s){
            this.f=f;
            this.s=s;
        }
    }
    static BufferedReader br;
    static PrintWriter out;
    static StringTokenizer st;
    static String next () throws IOException {
        while (st == null || !st.hasMoreTokens())
            st = new StringTokenizer(br.readLine().trim());
        return st.nextToken();
    }

    static long readLong () throws IOException {
        return Long.parseLong(next());
    }

    static int readInt () throws IOException {
        return Integer.parseInt(next());
    }

    static double readDouble () throws IOException {
        return Double.parseDouble(next());
    }

    static char readCharacter () throws IOException {
        return next().charAt(0);
    }

    static String readLine () throws IOException {
        return br.readLine().trim();
    }
    static HashMap<Integer,ArrayList<pair>> adj = new HashMap<>();
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int a=readInt();
        int b=readInt();
        for(int i=0;i<=1000;i++){
            adj.put(i,new ArrayList<pair>());
        }
        for(int i=0;i<b;i++) {
            int c=readInt();
            int d=readInt();
            int e=readInt();
           adj.get(c).add(new pair(d,e));
           adj.get(d).add(new pair(c,e));
        }
        LinkedList<Integer> q = new LinkedList<>();
        q.add(1);
        boolean [] in = new boolean[1005];
        in[1]=true;
        int [] mins = new int [1005];
        int MAX = Integer.MAX_VALUE;
        Arrays.fill(mins,MAX);
        mins[1]=0;
        while (!q.isEmpty()){
            int cp=q.poll();
            in[cp]=false;
            for(pair i : adj.get(cp)){
                int np=i.f;
                int nd=i.s;
                if(mins[np]>mins[cp]+nd){
                    mins[np]=mins[cp]+nd;
                    q.add(np);
                }
            }
        }
        for(int i=1;i<=a;i++) {
            if(mins[i]==MAX)mins[i]=-1;
            System.out.println(mins[i]);
        }
    }

}