import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class ccc07s4 {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		int points = sc.nextInt();
		HashMap <Integer,LinkedList<Integer>> map = new HashMap();
		for(int i=1;i<=points;i++){
			map.put(i,new LinkedList<Integer>());
		}
		while(true){
			int p1=sc.nextInt();
			int p2=sc.nextInt();
			if(p1==0)break;
			map.get(p1).add(p2);
		}
		int [] list = new int[points+1];
		list[1]=1;
		for(int i = 1;i<=points;i++){
			for(int j=0;j<map.get(i).size();j++){
				list[map.get(i).get(j)]+=list[i];
			}
		}
		System.out.println(list[points]);
	}
}