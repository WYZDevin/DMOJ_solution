import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class DMOPC14P4 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int a = Integer.parseInt(br.readLine());
		int [] b = new int[a];
		int [] sumb=new int[a+1];
		String [] c = new String[2];
		sumb[0]=0;
		int g=0;
		int g1,g2;
		for (int i = 0; i < a; i++) {
			b[i]=Integer.parseInt(br.readLine());
			sumb[i+1]=sumb[i]+b[i];
		}
		a=Integer.parseInt(br.readLine());
		for (int i = 0; i < a; i++) {
			c=br.readLine().split(" ");
			g1=Integer.parseInt(c[1])+1;
			g2=Integer.parseInt(c[0]);
			g=sumb[g1]-sumb[g2];
			System.out.println(g);
		}
	}

}