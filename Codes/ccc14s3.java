import java.io.*;
import java.util.*;

public class Main {
   public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int h = Integer.parseInt(br.readLine());
		for(int j = 0;j<h;j++){
			int a = Integer.parseInt(br.readLine());
			Stack <Integer> top = new Stack();
			Stack <Integer> branch = new Stack();
			LinkedList <Integer> lake = new LinkedList();
			int ini = 0;
			for(int i = 0;i<a;i++){
				top.push(Integer.parseInt(br.readLine()));
			}
			while(true){
				if(top.isEmpty()){
					if(top.isEmpty() && branch.isEmpty()){
						break;
					}
					if(branch.lastElement()!=ini+1){
						break;
					}else{
						lake.add(branch.pop());
						ini++;
					}
				}else{
					if(branch.isEmpty()){
						if(ini+1==top.lastElement()){
							lake.add(top.pop());
							ini++;
						}else{
							branch.push(top.pop());
						}
					}else{
						if(ini+1==top.lastElement()){
							lake.add(top.pop());
							ini++;
						}else if(ini+1==branch.lastElement()){
							lake.add(branch.pop());
							ini++;
						}else{
							branch.push(top.pop());
						}
					}
				}
			}
			if(lake.size()!=a){
				System.out.println("N");
			}else{
				System.out.println("Y");
			}

			
		}
	}
}