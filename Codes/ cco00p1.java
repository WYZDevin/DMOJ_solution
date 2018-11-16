import java.io .*;
import java.util.*;
public class cco00p1 {
	static String alp = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	static String alp2="abcdefghijklmnopqrstuvwxyz";
	static HashMap<Character,LinkedList<Character>> map = new HashMap();
	static boolean [] [] grid=new boolean[26][26];
	static LinkedList<Character> find(LinkedList<Character> pass,boolean []visted,char k){
		if(visted[alp.indexOf(k)]){
			for(int i = 0;i<map.get(k).size();i++){
				if(Character.isLowerCase(map.get(k).get(i))){
					pass.add(map.get(k).get(i));
				}
			}
			return pass;
		}else visted[alp.indexOf(k)]=true;
		for(int i = 0;i<map.get(k).size();i++){
			if(map.get(k).get(i)=='-')continue;
			if(Character.isLowerCase(map.get(k).get(i))){
				pass.add(map.get(k).get(i));
			}else{
				find(pass,visted,map.get(k).get(i));
			}
		}
		return pass;
	}
	static void print(LinkedList<Character> pass,boolean [] ok){
		for(int i = 0;i<pass.size();i++)ok[alp2.indexOf(pass.get(i))]=true;
		String c="";
		for(int i = 0;i<ok.length;i++)if(ok[i])c+=(alp2.charAt(i)+",");
		if(c.length()>0){
		System.out.print(c.substring(0, c.length()-1));
		}
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int a = Integer.parseInt(br.readLine());
		String [] list = new String[a];
		for(int x = 0;x<alp.length();x++)
			map.put(alp.charAt(x),new LinkedList<Character>());
		for(int x=0;x<a;x++){
			String k=br.readLine();
			char c=k.charAt(0);
			char v=k.charAt(k.length()-1);
			map.get(c).add(v);
			if(Character.isUpperCase(v))map.get(v).add('-');
		}
		for(int x=0;x<alp.length();x++){
			char k = alp.charAt(x);
			if(!map.get(k).isEmpty()){
				boolean [] ok =new boolean[26];
				System.out.print(alp.charAt(x)+" = {");
				print(find(new LinkedList<Character>(),new boolean[26],k),ok);
				System.out.println("}");
			}
		}

	}
}