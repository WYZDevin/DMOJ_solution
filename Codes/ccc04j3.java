import java.io.BufferedReader;
import java.io.IOException;
import java.io.*;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class test {


    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int a=sc.nextInt(),b=sc.nextInt();
        String [] s1 = new String [a];
        String [] s2 = new String [b];
        for(int i=0;i<a;i++)
            s1[i]=sc.next();
        for(int i=0;i<b;i++)
            s2[i]=sc.next();
        for(String i : s1)
            for(String j : s2)
                System.out.println(i+" as "+j);
    }

}