import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class ccc13s2 {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int weight = Integer.parseInt(br.readLine());
		int cars = Integer.parseInt(br.readLine());
		int passed=0;
		int check=0;
		int [] car = new int[cars];
		for (int i = 0; i <cars; i++) {
			car[i]=Integer.parseInt(br.readLine());
		}
		if(cars<=4){
			int sum=0;
			for (int i = 0; i < cars; i++) {
				sum+=car[i];
				if(sum<=weight){
					passed+=1;
				}
			}
		}else{
			for (int i = 0; i <cars-3; i++) {
				int sum=0;
				int ss = i;
				for(int j=1;j<=4;j++){
					sum+=car[ss];
					if(sum>weight){
						passed+=j-1;
						check=1;
						break;
					}
					ss++;
				}
				if(check==1){
					break;
				}
				if(sum<=weight){
					passed++;
				}else{
					check=1;
					break;
				}

			}
		}
		if(check==0){
			System.out.println(cars);
		}else{
			System.out.println(passed);
		}
	}
}