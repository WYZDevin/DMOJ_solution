import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class dmopc17c1p1 {

    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken()),C = Integer.parseInt(st.nextToken());
        TreeSet<Integer>x = new TreeSet<Integer>();
        TreeSet<Integer>y = new TreeSet();
        char [] [] grid = new char[1001][1001];
        for(int i=1;i<=R;i++){
            String c = br.readLine();
            for(int j=1;j<=C;j++){
                grid[i][j]=c.charAt(j-1);
                if(grid[i][j]=='X'){
                    x.add(j);
                    y.add(i);
                }
            }
        }
//        for(int i=1;i<=R;i++){
//            for(int j=1;j<=C;j++){
//                System.out.print(grid[i][j]);
//            }
//            System.out.println();
//        }
        int N =Integer.parseInt(br.readLine());
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int xx = Integer.parseInt(st.nextToken());
            int yy = Integer.parseInt(st.nextToken());
            if(x.contains(xx) || y.contains(yy)){
                System.out.println("Y");
            }else{
                System.out.println("N");
            }
        }
    }
}