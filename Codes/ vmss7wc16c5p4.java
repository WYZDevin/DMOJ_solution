import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class vmss7wc16c5p4 {
	static 	int [] list = new int[3];
	static int maxs;
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc= new Scanner(System.in);
		int N = sc.nextInt();

		for(int i = 0;i<3;i++){
			list[i]=sc.nextInt();
		}
		int count=0;
		Arrays.sort(list);
		for(int x = 0;x<=N/list[0];x++){
			for(int y=0;y<=N/list[1];y++){
				for(int z=0;z<=list[2];z++){
					if(x*list[0]+y*list[1]+z*list[2]==N){
						if(x+y+z>count)count=x+y+z;
					}
				}
			}
		}
		System.out.println(count);
	}
}