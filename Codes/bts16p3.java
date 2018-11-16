import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Integer a = Integer.parseInt(br.readLine());
		String [] name=br.readLine().split(" ");
		Integer count = 0;
		for(int i = 0;i<a;i++){
			count++;
			for(int j=i+1;j<a;j++){
				if(name[i].charAt(0) == name[j].charAt(0)){
					count++;
				}else{
					break;
				}
			}
		}
		System.out.println(count);
	}
}