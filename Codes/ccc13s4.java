import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class ccc13s4 {
	static int N,M;
	static ArrayList <ArrayList<Integer>> com = new ArrayList();
	static boolean tall(int pa,int pb,boolean [] vist){
		LinkedList <Integer> gr = new LinkedList();
		for (int i = 0; i < com.get(pa).size(); i++) 
			gr.add(com.get(pa).get(i));
		while(!gr.isEmpty()){
			int k=gr.poll();
			if(k==pb)return true;
			if(!vist[k]){
				vist[k]=true;
				for (int i = 0; i < com.get(k).size(); i++) 
					gr.add(com.get(k).get(i));
			}
		}
		return false;
	}
	public static void main(String []args) throws IOException{ 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		for (int i = 0; i <=N; i++) {
			com.add(i,new ArrayList<Integer>());
		}
		boolean [] vist=new boolean [N+1];
		for (int i = 0; i <M; i++) {
			st=new StringTokenizer(br.readLine());
			com.get(Integer.parseInt(st.nextToken())).add(Integer.parseInt(st.nextToken()));
		}
		st=new StringTokenizer(br.readLine());
		int pa= Integer.parseInt(st.nextToken());
		int pb= Integer.parseInt(st.nextToken());
		if(tall(pa,pb,vist))
			System.out.println("yes");
		else if(tall(pb,pa,vist))
			System.out.println("no");
		else
			System.out.println("unknown");

	}
}