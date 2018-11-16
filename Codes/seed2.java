import java.io.BufferedReader;
import java.io.InputStreamReader;

public class sand {

	public static void main(String args[]) throws Exception
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		// TODO Auto-generated method stub
		int top = 2000000000;
		int bot = 1;
		String c="";
		int mid;
		while(!c.equals("OK")){
			mid = bot+(top-bot)/2;
			System.out.println(mid);
			System.out.flush();
			c=br.readLine();
			if(c.equals("SINKS")){
				bot=mid+1;
			}else if(c.equals("FLOATS")){
				top=mid-1;
			}
		}
	}

}