import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int a = Integer.parseInt(br.readLine());
		Integer [] sb=new Integer [a];
		for(int i = 0;i<a;i++){
			sb[i]=Integer.parseInt(br.readLine());
		}
		Arrays.sort(sb);
		for(int i = 0;i<a;i++){
			System.out.println(sb[i]);
		}
	}

}