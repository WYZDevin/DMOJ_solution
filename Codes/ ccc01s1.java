import java.io.*;
import java.util.*;

public class FUCK {
    static BufferedReader br = new BufferedReader(new InputStreamReader (System.in));
    static int n;
    public static void main (String [] args) throws IOException {
        String str;
        int total = 0;
        char c1 = 'D', c2 = 'H', c3 = 'S';
        str = br.readLine ();
        System.out.println ("Cards Dealt              Points");
        System.out.print ("Clubs ");
        total += points (str, c1);
        System.out.print ("Diamonds ");
        total += points (str, c2);
        System.out.print ("Hearts ");
        total += points (str, c3);
        System.out.print ("Spades ");
        total += points (str);
        System.out.print ("Total " + total);

    }
    public static int points (String str, char c){
        int p = 0, count = 0;
        n++;
        while (str.charAt (n) != c){
            if (str.charAt (n) == 'A') {
                p += 4;
                count ++;
            } else if (str.charAt (n) == 'K') {
                p += 3;
                count ++;
            } else if (str.charAt (n) == 'Q') {
                p += 2;
                count ++;
            } else if (str.charAt (n) == 'J') {
                p += 1;
                count ++;
            } else {
                count ++;
            }
            System.out.print (str.charAt (n) + " ");
            n++;
        }
        if (count == 0) {
            p += 3;
        } else if (count == 1) {
            p += 2;
        } else if (count == 2){
            p += 1;
        }
        System.out.println ("   " + p);
        return p;
    }
    public static int points (String str){
        int p = 0, count = 0;
        n++;
        while (n <= str.length () - 1) {
            if (str.charAt (n) == 'A') {
                p += 4;
                count ++;
            } else if (str.charAt (n) == 'K') {
                p += 3;
                count ++;
            } else if (str.charAt (n) == 'Q') {
                p += 2;
                count ++;
            } else if (str.charAt (n) == 'J') {
                p += 1;
                count ++;
            } else {
                count ++;
            }
            System.out.print (str.charAt (n) + " ");
            n++;
        }
        if (count == 0) {
            p += 3;
        } else if (count == 1) {
            p += 2;
        } else if (count == 2){
            p += 1;
        }
        System.out.println ("    " + p);
        return p;
    }
}