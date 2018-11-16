import java.io.*;
import java.util.*;


public class main{

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int a= Integer.parseInt(in.readLine());
		String[] b = in.readLine().split(" ");
		for(int g=0;g<b.length;g++){
			if(g==b.length-1){
				System.out.println(b[g]);
			}else{
				System.out.print(b[g]+" ");
			}
		}
		for(int j = 0;j<b.length-1;j++){
			for(int q=0;q<b.length-1-j;q++){
				if(Integer.parseInt(b[q])>Integer.parseInt(b[q+1])){
					String swap = b[q];
					b[q]=b[q+1];
					b[q+1]=swap;
					for(int g=0;g<b.length;g++){
						if(g==b.length-1){
							System.out.println(b[g]);
						}else{
							System.out.print(b[g]+" ");
						}
					}
				}
			
			
			}
		}
	}
}