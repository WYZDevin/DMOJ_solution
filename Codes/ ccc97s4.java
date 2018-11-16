import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class ccc97s4 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int a= Integer.parseInt(br.readLine());
		String [] c;
		String in;
		for (int i = 0; i < a; i++) {
			HashMap <String,Integer> map = new HashMap();
			int count=1;
			while(true){
				in=br.readLine();
				if(in.equals(""))break;
				c=in.split(" ");
				for (int j = 0; j < c.length; j++) {
					if(map.get(c[j])==null){
						System.out.print(c[j]+" ");
						map.put(c[j], count++);
					}else{
						System.out.print(map.get(c[j])+" ");
					}
				}
				System.out.println();
			}
		}
	}
}