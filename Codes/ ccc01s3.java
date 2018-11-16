import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class ccc01s3 {
	public static void main(String[] args) {
		Scanner sc=  new Scanner(System.in);
		LinkedList <String> a = new LinkedList();
		boolean [] [] graph = new boolean[26][26];
		String read="";
		int d,e;
		while(true){
			read=sc.nextLine();
			if(read.equals("**")){
				break;
			}
			d=(int)read.charAt(0);
			d-=65;
			e=(int)read.charAt(1);
			e-=65;
			graph[d][e]=true;
			graph[e][d]=true;
			a.add(read);
		}
		LinkedList <Integer> que = new LinkedList();
		LinkedList <String> bri = new LinkedList();
		int b=a.size();
		for (int i = 0; i < b; i++) {
			boolean []vist=new boolean[26]; 
			que.clear();
			que.add(0);
			read=a.removeFirst();
			d=(int)read.charAt(0);
			d-=65;
			e=(int)read.charAt(1);
			e-=65;
			graph[d][e]=false;
			graph[e][d]=false;
			while(!que.isEmpty()){
				int cur = que.poll();
				vist[cur]=true;
				for(int j = 0;j<26;j++){
					if(graph[cur][j]&&!vist[j]){
						que.add(j);
						vist[j]=true;
					}
				}
			}
			if(!vist[1]){
				bri.add(read);
			}
			graph[d][e]=true;
			graph[e][d]=true;
		}
		b=bri.size();
		while(!bri.isEmpty()){
			System.out.println(bri.removeFirst());
		}
		System.out.println("There are "+b+" disconnecting roads.");
		
	}
}