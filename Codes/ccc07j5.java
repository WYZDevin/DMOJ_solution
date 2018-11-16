import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ccc07j5 {
	static int min,max,hotels,ways=0;
	static ArrayList <Integer> gr = new ArrayList();
	static void cal(int loc){
		if(loc>=7000){
			ways++;
			return;
		}
		for (int i = 1; i < gr.size(); i++) {
			if(min<=gr.get(i)-loc && gr.get(i)-loc<=max)
				cal(gr.get(i));
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int [] list = {0, 990, 1010, 1970, 2030, 2940, 3060, 3930, 4060, 4970, 5030, 5990, 6010, 7000};
		for (int x:list) gr.add(x);
		min=sc.nextInt();
		max=sc.nextInt();
		hotels=sc.nextInt();
		for (int i = 0; i < hotels; i++) {
			gr.add(sc.nextInt());
		}
		Collections.sort(gr);
		int loc=1;
		cal(loc);
		System.out.println(ways);
	}
}