import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int a = Integer.parseInt(br.readLine());
		long b;
		for (int i = 0; i < a; i++) {
			b=Long.parseLong(br.readLine());
			if((b&b-1)==0){
				System.out.println("T");
			}else{
				System.out.println("F");
			}
		}
}
}