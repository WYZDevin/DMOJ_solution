import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class artSnow {
	public static boolean bs(Integer[] a, int b) {

		int high=a.length;
		int low =0;
		while(low<high){
			int middle=low+(high-low)/2;
			if(b>a[middle]){
				low=middle+1;
			}else if(b<a[middle]){
				high=middle-1;
			}else{
				return true;
			}
		}
		return false;
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int a = Integer.parseInt(br.readLine());
		String [] c = br.readLine().split(" ");
		Integer [] data = new Integer[a];
		for (int i = 0; i < c.length; i++) {
			data[i]=Integer.parseInt(c[i]);
		}
		Arrays.sort(data);
		int tt=0;
		int first,sec,third,dif;
		for (int i = 0; i < data.length-2; i++) {
			first=data[i];
			for (int j = i+2; j < data.length; j++) {
				third=data[j];
				if((first+third)%2==0){
					sec = (first+third)/2;
					if(Arrays.binarySearch(data,sec)>0){
					int tt2=first+sec+third;
						if(tt2>tt){
							tt=tt2;
						}
					}
				}
			}			
		}
		System.out.println(tt);

	}
}