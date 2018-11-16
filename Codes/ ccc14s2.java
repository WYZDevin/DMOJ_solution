import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class ccc14s2 {

    public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int c=Integer.parseInt(br.readLine());
		LinkedList <String> aa = new LinkedList();
		LinkedList <String> bb = new LinkedList();
		String [] a =br.readLine().split(" ");
		String [] b =br.readLine().split(" ");
		LinkedList <String> aaa = new LinkedList();
		LinkedList <String> bba = new LinkedList();
		String d,e,f;
		int check=0,index=0;
		for (int i = 0; i < b.length; i++) {
			if(aa.contains(a[i]) || bb.contains(b[i])){
				check=1;
				break;
			}else{
			aa.add(a[i]);
			bb.add(b[i]);
			}
		}
		for (int i = 0; i < b.length; i++) {
			d=a[i];
			e=b[i];
			index=aa.indexOf(e);
			f=bb.get(index);
			if(!d.equals(f)){
				check=1;
				break;
			}else if(d.equals(e)){
				check=1;
				break;
			}else if(aaa.contains(d) || bba.contains(e)){
				check=1;
				break;
			}else{
				aaa.add(d);
				bba.add(e);
			}
		}
		if(check==0){
			System.out.println("good");
		}else{
			System.out.println("bad");
		}
	 }

}