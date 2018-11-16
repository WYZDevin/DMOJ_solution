import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
Scanner input = new Scanner(System.in);
		TreeSet<Integer> gt = new TreeSet<Integer>();
		int G = input.nextInt();
		int P = input.nextInt();
		int cc = 0;
		for(Integer i=1;i<=G;i++){
			gt.add(-i);
		}
		Integer plane;
		for(int i =0;i<P;i++){
			plane=input.nextInt();
			if(gt.ceiling(-plane)!=null){
				gt.remove(gt.ceiling(-plane));
				cc++;
			}else{
				break;
			}

		}
		System.out.println(cc);
		input.close();
    }
}