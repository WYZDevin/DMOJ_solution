import java.util.*;
public class mock3s2 {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int []med = new int[N];
        for(int i=0;i<N;i++){
            int [] sb = new int[N];
            for (int j=0;j<N;j++){
                sb[j]=sc.nextInt();
            }
            Arrays.sort(sb);
            med[i]=sb[N/2];
        }
        Arrays.sort(med);
        System.out.println(med[N/2]);
    }
}