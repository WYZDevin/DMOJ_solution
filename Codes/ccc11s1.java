import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ccc11s1 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int a= Integer.parseInt(br.readLine());
		String c;
		int t=0,s=0;
		for(int i =0;i<a;i++){
			c=br.readLine();
			for(int j = 0;j<c.length();j++){
				if(c.charAt(j)=='T' ||c.charAt(j)=='t'){
					t++;
				}else if(c.charAt(j)=='S' ||c.charAt(j)=='s'){
					s++;
				}
			}
		}
		if(t>s){
			System.out.println("English");
		}else{
			System.out.println("French");
		}
		
	}

}