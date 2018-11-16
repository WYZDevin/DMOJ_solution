import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class test {
    static BufferedReader br;
    static PrintWriter out;
    static StringTokenizer st;

    static String next() throws IOException {
        while (st == null || !st.hasMoreTokens())
            st = new StringTokenizer(br.readLine().trim());
        return st.nextToken();
    }

    static long readLong() throws IOException {
        return Long.parseLong(next());
    }

    static int readInt() throws IOException {
        return Integer.parseInt(next());
    }

    static double readDouble() throws IOException {
        return Double.parseDouble(next());
    }

    static char readCharacter() throws IOException {
        return next().charAt(0);
    }

    static String readLine() throws IOException {
        return br.readLine().trim();
    }


    public static void dfs(int n) {
        vis[n] = true;
        for (int j=0;j<chk[n].size();j++ ) {
            int i=chk[n].get(j);
            if (vis[i] == false) {
                dfs(i);
            }
        }
    }

    static ArrayList<Integer>[] chk = new ArrayList[10001];
    static boolean[] vis = new boolean[10001];

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int a = readInt();
        int b = readInt();
        for(int i=0;i<=a;i++)
            chk[i]=new ArrayList<>();
        for (int i = 0; i < b; i++) {
            int e = readInt();
            int f = readInt();
            chk[e].add(f);
            chk[f].add(e);
        }
        int c = readInt();
        int d = readInt();
        dfs(c);
        if (vis[d] == true)
            System.out.println(1);
        else
            System.out.println(0);

    }
}