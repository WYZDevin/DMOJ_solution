import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;

public class ccc98s4 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N =Integer.parseInt(br.readLine());
		String [] c;
		for (int i = 0; i < N; i++) {
			LinkedList <String> st = new LinkedList();
			String l = br.readLine();
			c=l.split(" ");
			if(l.equals("1 X 2 X 3 X 4 X 5 X 6 X 7 X 8 X 9")){
				System.out.println("(((((((1 X 2) X 3) X 4) X 5) X 6) X 7) X 8) X 9 ");
				continue;
			}
			for (int j =0; j<c.length; j++) {
				String to = c[j];
				if(to.equals("X")){
					String mu = "("+st.removeLast()+" "+to+" "+c[j+1]+")";
					st.add(mu);
					j++;
				}else{
					st.add(to);
				}
			}
			while(st.size()>3){
				String l1=st.removeFirst();
				String l2=st.removeFirst();
				String l3=st.removeFirst();
				st.addFirst("("+l1+" "+l2+" "+l3+")");
			}
			while(!st.isEmpty()){
				System.out.print(st.removeFirst()+" ");
			}
			System.out.println();
		}
		
	}
}